package model;

import java.util.List;
import java.util.Random;

public class Client implements Comparable<Client>{
    private int cust_ID;
    private String nume;
    private int venit;
    private Credit credit;


    public Client( String nume, int venit) {

        Random rand = new Random();
        int id = rand.nextInt(20000);
        id +=1;

        this.cust_ID = id;
        this.nume = nume;
        this.venit = venit;


    }

    public Client(int id, String nume, int venit, double sumaInitiala, double procent, int durata) {



        this.cust_ID = id;
        this.nume = nume;
        this.venit = venit;
        this.credit = new Credit(sumaInitiala, procent, durata);



    }


    public void setCredit(double sumaInitiala, double procent, int durata){
        this.credit = new Credit(sumaInitiala, procent, durata);
    }

    public int getCust_ID() {

        return cust_ID;
    }

    public void setCust_ID(int cust_ID) {

        this.cust_ID = cust_ID;
    }

    public String getNume() {

        return nume;
    }

    public void setNume(String nume) {

        this.nume = nume;
    }

    public int getVenit() {

        return venit;
    }

    public void setVenit(int venit) {
        this.venit = venit;
    }

    public double soldDisponibil(){
        return this.credit.getSold();
    }

    public List<String> istoricTranzactii(){
        return this.credit.istoricTranzactii;
    }

    public double getSumaInit(){
        return this.credit.getSumaInitiala();
    }

    public double getDobanda(){
        return this.credit.getDobanda();
    }

    public int getDurata(){
        return this.credit.durata;
    }

    public double getRata(){
        return this.credit.getRata();
    }

    @Override
    public String toString() {
        return "Client : " +
                "ID = " + cust_ID +
                ", nume: " + nume +
                ", venit = " + venit +
                ",\n" + credit.toString()+
                " .\n\n";
    }

    @Override
    public int compareTo(Client c){
        if(this.credit.sumaDePlata < c.credit.sumaDePlata) return -1;
        if(this.credit.sumaDePlata > c.credit.sumaDePlata) return 1;
        return 0;
    }

    public void withdraw(double suma){
        this.credit.withdraw(suma);
    }

    public void deposit(double suma){
        this.credit.deposit(suma);
    }
}
