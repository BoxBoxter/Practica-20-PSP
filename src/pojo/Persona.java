package pojo;

import java.io.Serializable;


public class Persona implements Serializable {
    private String nom;
    private String cognom;
    private int edat;
    private int telèfon;
    private String correu;
    private Adreça adreça;

    public Persona(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getTelèfon() {
        return telèfon;
    }

    public void setTelèfon(int telèfon) {
        this.telèfon = telèfon;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public Adreça getAdreça() {
        return adreça;
    }

    public void setAdreça(Adreça adreça) {
        this.adreça = adreça;
    }

    @Override
    public String toString() {
        return nom +", " + cognom +", " + edat +", " + telèfon + ", " + correu + ", direccio: " + adreça;
    }
}
