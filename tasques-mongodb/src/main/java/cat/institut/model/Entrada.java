package cat.institut.model;

import java.util.Date;

public class Entrada {

    private String _id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private Date dataEntrada;
    private boolean completa;
    private String observacions;

    /**
     * Constructor buit necessari per JSON.
     */
    public Entrada() {
    }

    /**
     * Constructor manual.
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

    // GETTERS

    public String getId() {
        return _id;
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

    public void setId(String id) {
        this._id = id;
    }

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
        return "ID: " + _id +
                " | " + nom + " " + cognom1 +
                " | Data: " + dataEntrada +
                " | Completa: " + completa;
    }
}
