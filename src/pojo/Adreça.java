package pojo;

import java.io.Serializable;

public class Adreça implements Serializable {
    private String carrrer;
    private String numero;
    private String municipi;
    private int codiPostal;
    private String pais;

    public Adreça(String carrrer, String numero, String municipi, int codiPostal, String pais) {
        this.carrrer = carrrer;
        this.numero = numero;
        this.municipi = municipi;
        this.codiPostal = codiPostal;
        this.pais = pais;
    }

    public String getCarrrer() {
        return carrrer;
    }

    public void setCarrrer(String carrrer) {
        this.carrrer = carrrer;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "carrrer: " + carrrer +
                ", numero: " + numero +
                ", " + municipi + ", " + codiPostal + ", " + pais ;
    }
}
