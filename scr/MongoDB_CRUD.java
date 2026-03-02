/**
 * Project: lab3YourLastName
 * Purpose Details: Implements CRUD operations for the Customer collection in a MongoDB database.
 * Course: IST888
 * Author: [Your Name]
 * Date Developed: [Date]
 * Last Date Changed: [Date]
 * Rev: 1.0
 */
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDB_CRUD {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "retail_store";
    private static final String COLLECTION_NAME = "Customer";


    private MongoCollection<Document> getCollection() {
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        MongoDatabase db = client.getDatabase(DATABASE_NAME);
        return db.getCollection(COLLECTION_NAME);
    }


    public void createCustomer(Customer customer) {
        Document doc = new Document("id", customer.getId())
                .append("name", customer.getName())
                .append("email", customer.getEmail())
                .append("phone", customer.getPhone())
                .append("address", customer.getAddress());
        getCollection().insertOne(doc);
        System.out.println("MongoDB: Customer " + customer.getName() + " inserted successfully.");
    }

    public Customer readCustomer(int id) {
        Document doc = getCollection().find(Filters.eq("id", id)).first();
        if (doc != null) {
            return new Customer(
                    doc.getInteger("id"),
                    doc.getString("name"),
                    doc.getString("email"),
                    doc.getString("phone"),
                    doc.getString("address")
            );
        }
        return null;
    }


    public void updateCustomer(Customer customer) {
        Document update = new Document("$set", new Document("name", customer.getName())
                .append("email", customer.getEmail())
                .append("phone", customer.getPhone())
                .append("address", customer.getAddress()));
        getCollection().updateOne(Filters.eq("id", customer.getId()), update);
        System.out.println("MongoDB: Customer " + customer.getId() + " updated successfully.");
    }


    public void deleteCustomer(int id) {
        getCollection().deleteOne(Filters.eq("id", id));
        System.out.println("MongoDB: Customer " + id + " deleted successfully.");
    }


    public void readAllCustomers() {
        System.out.println("\n--- All Customers in MongoDB ---");
        getCollection().find().forEach(doc -> {
            System.out.println(new Customer(
                    doc.getInteger("id"),
                    doc.getString("name"),
                    doc.getString("email"),
                    doc.getString("phone"),
                    doc.getString("address")
            ));
        });
    }
}
