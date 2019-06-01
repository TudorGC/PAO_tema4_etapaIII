package model;

import java.util.Date; // inca nu e folosita

public class Rata {              //posibil sa nu fie necesara clasa Rata

    private Date dataScadenta;
    private double suma;

    public Date getDataScadenta() {
        return dataScadenta;
    }

    public void setDataScadenta(Date dataScadenta) {
        this.dataScadenta = dataScadenta;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Rata(double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Rata{" +
                "dataScadenta=" + dataScadenta +
                ", suma=" + suma +
                '}';
    }
}
