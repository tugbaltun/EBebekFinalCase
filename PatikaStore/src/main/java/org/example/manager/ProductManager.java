package org.example.manager;
import java.io.IOException;

public interface ProductManager {
    void menu() throws IOException;
    void list() throws IOException;
    void filter();
    void filterById();
    void add() throws IOException;
    void delete();
}
