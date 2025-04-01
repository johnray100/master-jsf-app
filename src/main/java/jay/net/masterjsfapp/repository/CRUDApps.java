package jay.net.masterjsfapp.repository;

import java.util.List;

public interface CRUDApps<T> {

    // Create a new record
    void create(T entity);

    // Read a record by ID
    T read(Object id);

    // Update an existing record
    void update(T entity);

    // Search records based on criteria
    List<T> search(String keyword);

    // Delete a record by ID
    void delete(Object id);

    // Execute a custom query (e.g., SELECT statements)
    List<T> executeQuery(String query, Object... params);

    // Execute an update query (e.g., INSERT, UPDATE, DELETE)
    int executeUpdate(String query, Object... params);

    // List all records
    List<T> list();

    // Get a dropdown list (for UI components)
    List<String> dropdown();

    // Look up a record based on a unique field (e.g., username, email, code, etc.)
    T lookUp(String fieldName, Object value);
}
