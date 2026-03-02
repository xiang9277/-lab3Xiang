/**
 * Project: Lab3
 * Purpose Details: Solo Lab3 Database Assignment
 * Course: IST242
 * Author: zizhou xiang
 * Date Developed: 2026/2/26
 * Last Date Changed: 2026/3/1
 * Rev: 1.0
 */
import com.mongodb.client.*;
import org.bson.Document;

public class MongoDB_CRUD {

    private MongoCollection<Document> collection;

    public MongoDB_CRUD() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = client.getDatabase("lab3");
        collection = db.getCollection("customers");
    }

    public void insertCustomer(Customer c) {
        Document doc = new Document("id", c.getId())
                .append("name", c.getName())
                .append("email", c.getEmail())
                .append("balance", c.getBalance());
        collection.insertOne(doc);
    }

    public void readCustomers() {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    public void updateCustomer(int id, double newBalance) {
        collection.updateOne(
                new Document("id", id),
                new Document("$set", new Document("balance", newBalance))
        );
    }

    public void deleteCustomer(int id) {
        collection.deleteOne(new Document("id", id));
    }
}