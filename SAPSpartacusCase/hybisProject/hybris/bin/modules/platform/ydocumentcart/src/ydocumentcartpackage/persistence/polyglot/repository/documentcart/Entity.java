/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2019 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package ydocumentcartpackage.persistence.polyglot.repository.documentcart;

import de.hybris.platform.persistence.polyglot.PolyglotPersistence.CoreAttributes;
import de.hybris.platform.persistence.polyglot.model.Identity;
import de.hybris.platform.persistence.polyglot.model.ItemState;
import de.hybris.platform.persistence.polyglot.model.Key;
import de.hybris.platform.persistence.polyglot.model.SingleAttributeKey;
import de.hybris.platform.util.RelationsInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;


public class Entity implements ItemState
{
	private final Identity id;
	private final Document document;
	private final Map<SingleAttributeKey, Object> values;
	private long version;

	private Entity(final EntityBuilder builder)
	{
		this.id = builder.id;
		this.document = builder.document;
		this.values = builder.values;
		this.version = builder.version;
	}

	public static Optional<Entity> from(final ItemState state)
	{
		return Optional.of(state).filter(Entity.class::isInstance).map(Entity.class::cast);
	}

	public Identity getId()
	{
		return id;
	}

	public Document getDocument()
	{
		return document;
	}

	@Override
	public EntityModification beginModification()
	{
		return new EntityModification(id, document);
	}

	@Override
	public <T> T get(final Key key)
	{
		Objects.requireNonNull(key, "key mustn't be null.");

		if (CoreAttributes.isPk(key))
		{
			return (T) id;
		}
		if (CoreAttributes.isVersion(key))
		{
			return (T) Long.valueOf(version);
		}

		return (T) values.get(key);
	}

	@Override
	public <T> T get(final RelationsInfo relationsInfo)
	{
		Objects.requireNonNull(relationsInfo, "relationsInfo mustn't be null");
		return (T) document.getRelatedItems(relationsInfo);
	}

	void incrementVersion()
	{
		version++;
	}

	public void set(final SingleAttributeKey key, final Object value)
	{
		Objects.requireNonNull(key, "key mustn't be null.");

		if (CoreAttributes.isPk(key) || CoreAttributes.isVersion(key))
		{
			return;
		}

		if (value == null)
		{
			values.remove(key);
		}
		else
		{
			values.put(key, value);
		}
	}

	public void forEveryAttribute(final BiConsumer<SingleAttributeKey, Object> consumer)
	{
		Objects.requireNonNull(consumer, "consumer mustn't be null.");

		consumer.accept(CoreAttributes.pk(), id);
		consumer.accept(CoreAttributes.version(),  version);
		values.forEach(consumer);
	}

	public static EntityBuilder builder(final Document document)
	{
		return new EntityBuilder(document);
	}

	public static final class EntityBuilder
	{
		private final Document document;
		private Identity id;
		private final HashMap<SingleAttributeKey, Object> values = new HashMap<>();
		private long version = 0;

		private EntityBuilder(final Document document)
		{
			this.document = Objects.requireNonNull(document, "document mustn't be null.");
		}

		public EntityBuilder withId(final Identity id)
		{
			this.id = Objects.requireNonNull(id, "id mustn't be null.");
			return this;
		}

		public EntityBuilder withAttribute(final SingleAttributeKey key, final Object value)
		{
			Objects.requireNonNull(key, "key mustn't be null.");
			Objects.requireNonNull(value, "value mustn't be null.");

			if (CoreAttributes.isPk(key))
			{
				return withId((Identity) value);
			}
			else if (CoreAttributes.isVersion(key))
			{
				return withVersion(((Long) value));
			}

			values.put(key, value);

			return this;
		}

		public EntityBuilder withVersion(final long version)
		{
			this.version = version;
			return this;
		}

		public Entity build()
		{
			Objects.requireNonNull(id, "id must be provided.");
			return new Entity(this);
		}

	}

}
