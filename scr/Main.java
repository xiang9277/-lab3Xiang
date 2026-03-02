/**
 * Project: lab3YourLastName
 * Purpose Details: Main class to test CRUD operations for both MySQL and MongoDB databases.
 * Course: IST888
 * Author: [Your Name]
 * Date Developed: [Date]
 * Last Date Changed: [Date]
 * Rev: 1.0
 */
public class Main {
    public static void main(String[] args) {

        MySQLCRUD mysqlCRUD = new MySQLCRUD();
        MongoDB_CRUD mongoCRUD = new MongoDB_CRUD();


        Customer c1 = new Customer(1, "Alice Smith", "alice@test.com", "123-456-7890", "123 Main St");
        Customer c2 = new Customer(2, "Bob Johnson", "bob@test.com", "234-567-8901", "456 Oak Ave");
        Customer c3 = new Customer(3, "Charlie Brown", "charlie@test.com", "345-678-9012", "789 Pine Rd");


        System.out.println("=== Step 1: Inserting Data ===");
        mysqlCRUD.createCustomer(c1);
        mysqlCRUD.createCustomer(c2);
        mysqlCRUD.createCustomer(c3);
        mongoCRUD.createCustomer(c1);
        mongoCRUD.createCustomer(c2);
        mongoCRUD.createCustomer(c3);


        System.out.println("\n=== Step 2: Reading All Data ===");
        mysqlCRUD.readAllCustomers();
        mongoCRUD.readAllCustomers();


        System.out.println("\n=== Step 3: Updating Data ===");
        c1.setAddress("999 New St");
        mysqlCRUD.updateCustomer(c1);
        mongoCRUD.updateCustomer(c1);
        System.out.println("Updated MySQL Customer 1: " + mysqlCRUD.readCustomer(1));
        System.out.println("Updated MongoDB Customer 1: " + mongoCRUD.readCustomer(1));


        System.out.println("\n=== Step 4: Deleting Data ===");
        mysqlCRUD.deleteCustomer(2);
        mongoCRUD.deleteCustomer(2);
        System.out.println("After Deletion:");
        mysqlCRUD.readAllCustomers();
        mongoCRUD.readAllCustomers();
    }
}