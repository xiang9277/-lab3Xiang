/**
 * Project: Lab3
 * Purpose Details: Solo Lab3 Database Assignment
 * Course: IST242
 * Author: zizhou xiang
 * Date Developed: 2026/2/26
 * Last Date Changed: 2026/3/1
 * Rev: 1.0
 */
public class Customer {


    private int id;


    private String name;


    private String email;


    private double balance;

    public Customer(int id, String name, String email, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}