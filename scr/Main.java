/**
 * Project: Lab3
 * Purpose Details: Solo Lab3 Database Assignment
 * Course: IST242
 * Author: zizhou xiang
 * Date Developed: 2026/2/26
 * Last Date Changed: 2026/3/1
 * Rev: 1.0
 */
public class Main {
    public static void main(String[] args) {

        Customer c1 = new Customer(1, "Alice", "alice@gmail.com", 100);
        Customer c2 = new Customer(2, "Bob", "bob@gmail.com", 200);
        Customer c3 = new Customer(3, "Charlie", "charlie@gmail.com", 300);

        MySQLCRUD  mysql = new MySQLCRUD ();
        MongoDB_CRUD mongo = new MongoDB_CRUD();

        // INSERT
        mysql.insertCustomer(c1);
        mysql.insertCustomer(c2);
        mysql.insertCustomer(c3);

        mongo.insertCustomer(c1);
        mongo.insertCustomer(c2);
        mongo.insertCustomer(c3);

        // READ
        mysql.readCustomers();
        mongo.readCustomers();

        // UPDATE
        mysql.updateCustomer(1, 999);
        mongo.updateCustomer(1, 999);

        // DELETE
        mysql.deleteCustomer(3);
        mongo.deleteCustomer(3);
    }
}