package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Credit {

    protected Rata rata;
    protected double dobanda, sumaInitiala, sold, sumaDePlata;
    protected String tipCredit;
    protected int durata;
    protected ArrayList<String> istoricTranzactii = new ArrayList<>();



    public Credit(double sumaInitiala, double procent, int durata) {

        this.sold = sumaInitiala;
        this.sumaInitiala = sumaInitiala;
        this.dobanda = procent;
        this.durata = durata;

        sumaDePlata = (sumaInitiala/100)*(100+procent);
        this.rata = new Rata(sumaDePlata / durata);
    }

    public double getRata() {
        return rata.getSuma();


    }

    public void setRata(Rata rata) {
        this.rata = rata;
    }

    public double getDobanda() {
        return dobanda;
    }

    public void setDobanda(double dobanda) {
        this.dobanda = dobanda;
    }

    public double getSumaInitiala() {
        return sumaInitiala;
    }

    public double getSold() {
        return sold;
    }

    public Credit() {
    }

    public void setSumaInitiala(double sumaInitiala) {
        this.sumaInitiala = sumaInitiala;
    }

    public String getTipCredit() {
        return tipCredit;
    }

    public void setTipCredit(String tipCredit) {
        this.tipCredit = tipCredit;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void withdraw(double amount){
        this.sold -= amount;
        adaugaIstoric( "retragere: " + amount);
    }

    public void deposit(double amount){
        this.sumaDePlata -= amount;
        adaugaIstoric( "deposit: " + amount);
    }

    public void plataRata(double amount){
        this.sumaDePlata -= amount;
        adaugaIstoric( "plata rata: " + amount);
    }

    public void adaugaIstoric(String tranzactie){
        istoricTranzactii.add(tranzactie);

    }

    public void afisIstoric(){
        for (String ex:istoricTranzactii)
            System.out.println(ex + "\n");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "Credit : " +
                "Suma Initiala = " + sumaInitiala +
                ", dobanda = " + dobanda +
                ", rata = " + df.format(rata.getSuma()) +
                ", suma de plata = " + df.format(sumaDePlata) +
                ", durata = " + durata + " luni";

    }
}

