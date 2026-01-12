package cat.institut;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

public class TasquesCrud {

    private static final String URI = "mongodb+srv://Josue:PASSWORD@cluster0.eo8z9i.mongodb.net/?retryWrites=true&w=majority";

    private static final String DB_NAME = "Tasques";
    private static final String COLLECTION = "entrades";

    public static void main(String[] args) {

        try (MongoClient client = MongoClients.create(URI)) {

            MongoDatabase db = client.getDatabase(DB_NAME);
            MongoCollection<Document> col = db.getCollection(COLLECTION);

            // CREATE
            Document novaTasca = new Document("nom", "Prova")
                    .append("cognom1", "CRUD")
                    .append("cognom2", "Java")
                    .append("dataEntrada", new java.util.Date())
                    .append("completa", false)
                    .append("observacions", "Inserida des de Java");

            col.insertOne(novaTasca);
            ObjectId id = novaTasca.getObjectId("_id");
            System.out.println("Tasca creada amb id: " + id);

            // READ
            System.out.println("\nTasques no completades:");
            col.find(Filters.eq("completa", false))
                    .forEach(d -> System.out.println(d.toJson()));

            // UPDATE
            col.updateOne(
                    Filters.eq("_id", id),
                    Updates.set("completa", true));
            System.out.println("\nTasca actualitzada a completada");

            // DELETE
            col.deleteOne(Filters.eq("_id", id));
            System.out.println("\nTasca eliminada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
