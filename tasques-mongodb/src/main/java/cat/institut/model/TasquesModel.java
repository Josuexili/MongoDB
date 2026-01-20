package cat.institut.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;

public class TasquesModel {

    private final MongoCollection<Document> collection;

    /**
     * Constructor del model.
     * Obté la connexió a la BBDD a través del ConnectionManager.
     */
    public TasquesModel() {
        MongoDatabase database = ConnectionManager.getDatabase();
        collection = database.getCollection("entrades");
    }

    /**
     * Inserir una nova tasca a la col·lecció.
     */
    public void inserirTasca(String nom,
            String cognom1,
            String cognom2,
            Date dataEntrada,
            boolean completa,
            String observacions) {

        Document tasca = new Document("nom", nom)
                .append("cognom1", cognom1)
                .append("cognom2", cognom2)
                .append("dataEntrada", dataEntrada)
                .append("completa", completa)
                .append("observacions", observacions);

        collection.insertOne(tasca);
    }

    /**
     * Retorna totes les tasques.
     */
    public FindIterable<Document> getAllTasques() {
        return collection.find();
    }

    /**
     * Elimina una tasca a partir del seu ObjectId.
     */
    public void deleteTasca(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    /**
     * Actualitza una tasca existent.
     */
    public void updateTasca(ObjectId id,
            String nom,
            String cognom1,
            String cognom2,
            Date dataEntrada,
            boolean completa,
            String observacions) {

        collection.updateOne(
                Filters.eq("_id", id),
                Updates.combine(
                        Updates.set("nom", nom),
                        Updates.set("cognom1", cognom1),
                        Updates.set("cognom2", cognom2),
                        Updates.set("dataEntrada", dataEntrada),
                        Updates.set("completa", completa),
                        Updates.set("observacions", observacions)));
    }

    /**
     * Retorna les tasques entre dues dates.
     */
    public FindIterable<Document> getTasquesEntreDates(Date dataInici, Date dataFi) {
        return collection.find(
                Filters.and(
                        Filters.gte("dataEntrada", dataInici),
                        Filters.lte("dataEntrada", dataFi)));
    }

    /**
     * Cerca tasques pel nom de l'alumne (coincidència parcial).
     */
    public FindIterable<Document> getTasquesByNom(String nom) {
        return collection.find(
                Filters.regex("nom", nom, "i"));
    }
}
