/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.smarteditwebservices.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.smarteditwebservices.constants.SmarteditwebservicesConstants;
import org.apache.log4j.Logger;

public class GeneratedSmarteditwebservicesManager extends GeneratedGeneratedSmarteditwebservicesManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( GeneratedSmarteditwebservicesManager.class.getName() );
	
	public static final GeneratedSmarteditwebservicesManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (GeneratedSmarteditwebservicesManager) em.getExtension(SmarteditwebservicesConstants.EXTENSIONNAME);
	}
	
}
