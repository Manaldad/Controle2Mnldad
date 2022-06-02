package com.example.controle2mnldad;

import java.io.Serializable;

public class Entreprise  implements Serializable {
    private int ID;
    private String RaisonSociale ;
    private String Adresse;
    private double Capitale ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRaisonSociale() {
        return RaisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        RaisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public double getCapitale() {
        return Capitale;
    }

    public void setCapitale(double capitale) {
        Capitale = capitale;
    }


    public Entreprise() {
    }

    public Entreprise(int ID, String raisonSociale, String adresse, double capitale) {
        this.ID = ID;
        RaisonSociale = raisonSociale;
        Adresse = adresse;
        Capitale = capitale;
    }
}
