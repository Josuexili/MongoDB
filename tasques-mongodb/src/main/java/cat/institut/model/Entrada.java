package cat.institut.model;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;

public class Entrada {

    private ObjectId id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private Date dataEntrada;
    private boolean completa;
    private String observacions;

    /**
     * Constructor per crear una nova Entrada (sense id).
     */
    public Entrada(String nom,
            String cognom1,
            String cognom2,
            Date dataEntrada,
            boolean completa,
            String observacions) {

        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.dataEntrada = dataEntrada;
        this.completa = completa;
        this.observacions = observacions;
    }

    /**
     * Constructor per crear una Entrada a partir d'un Document de MongoDB.
     */
    public Entrada(Document doc) {
        this.id = doc.getObjectId("_id");
        this.nom = doc.getString("nom");
        this.cognom1 = doc.getString("cognom1");
        this.cognom2 = doc.getString("cognom2");
        this.dataEntrada = doc.getDate("dataEntrada");
        this.completa = doc.getBoolean("completa", false);
        this.observacions = doc.getString("observacions");
    }

    /**
     * Converteix l'objecte Entrada a un Document MongoDB.
     */
    public Document toDocument() {
        Document doc = new Document()
                .append("nom", nom)
                .append("cognom1", cognom1)
                .append("cognom2", cognom2)
                .append("dataEntrada", dataEntrada)
                .append("completa", completa)
                .append("observacions", observacions);

        if (id != null) {
            doc.append("_id", id);
        }

        return doc;
    }

    // GETTERS

    public ObjectId getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public boolean isCompleta() {
        return completa;
    }

    public String getObservacions() {
        return observacions;
    }

    // SETTERS

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nom + " " + cognom1 +
                " | Data: " + dataEntrada +
                " | Completa: " + completa;
    }
}
