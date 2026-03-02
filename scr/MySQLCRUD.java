/**
 * Project: Lab3
 * Purpose Details: Solo Lab3 Database Assignment
 * Course: IST242
 * Author: zizhou xiang
 * Date Developed: 2026/2/26
 * Last Date Changed: 2026/3/1
 * Rev: 1.0
 */
import java.sql.*;

public class MySQLCRUD {

    private Connection conn;

    public MySQLCRUD () {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lab3",
                    "root",
                    "password"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(Customer c) {
        try {
            String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getEmail());
            ps.setDouble(4, c.getBalance());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readCustomers() {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int id, double newBalance) {
        try {
            String sql = "UPDATE Customer SET balance=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newBalance);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        try {
            String sql = "DELETE FROM Customer WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}