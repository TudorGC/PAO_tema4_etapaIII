package model;

public class CreditIpotecar extends Credit { // nu e folosita momentan, trebuie revizuiti constructorii, optiunile etc.

    private double valoareProprietate;

    public CreditIpotecar(double sumaInitiala, double procent, double valoareProprietate, int durata) {
        super(sumaInitiala, procent, durata);
        this.valoareProprietate = valoareProprietate;
        this.tipCredit = "Credit ipotecar";
    }

    @Override
    public String toString() {
        return "CreditIpotecar{" + super.toString() +
                "valoareProprietate=" + valoareProprietate +
                '}';
    }

    public double getValoareProprietate() {
        return valoareProprietate;
    }

    public void setValoareProprietate(double valoareProprietate) {
        this.valoareProprietate = valoareProprietate;
    }
}

