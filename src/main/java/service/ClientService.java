package service;
import model.Client;
import repository.IClientRepository;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ClientService implements IClientService{

    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }




    @Override
    public void creeazaClient(){

        System.out.println("\n------------\nClient nou: ");
        String nume;
        int id, venit, durata;
        double sumaInit, dobanda;

        System.out.println("Nume: ");
        Scanner input = new Scanner(System.in);
        nume = input.nextLine();

        System.out.println("venit: ");
        venit = input.nextInt();

        System.out.println("suma Credit: ");
        sumaInit = input.nextDouble();

        System.out.println("dobanda: ");
        dobanda = input.nextDouble();

        System.out.println("durata: ");
        durata = input.nextInt();





        Client c = new Client(nume, venit);
        c.setCredit(sumaInit, dobanda, durata);
        //c.credit = new Credit()

        clientRepository.adaugaClient(c);
    }

    public void creeazaClient(String nume, int venit, double sumaInitiala, double dobanda, int durata){


        Client c = new Client(nume, venit);
        c.setCredit(sumaInitiala, dobanda, durata);
        //c.credit = new Credit()

        clientRepository.adaugaClient(c);
    }



    @Override
    public void actualizareDatePers(){
        //Client c = clientRepository.cautareClient();
        //to do


    }

    @Override
    public double interogareSold(){
        Client c = clientRepository.cautareClient();
        return c.soldDisponibil();

    }

    @Override
    public List<String> istoricTranzactii(){
        Client c = clientRepository.cautareClient();
        return c.istoricTranzactii();

    }

    @Override
    public void cautareTranzactie(){

        Client c = clientRepository.cautareClient();

        System.out.println("Tranzactie - Cautare generala \nIntroduceti detalii (tip tranzactie / suma (partial sau complet)");

        Scanner scan = new Scanner(System.in);
        String deCautat = scan.next();
        Boolean gasit = false;

        while(gasit == false){

            for(String s : c.istoricTranzactii()){
                gasit = false;

                if(s.toLowerCase().contains(deCautat.toLowerCase())) {
                    System.out.println("\n\nTranzactie gasita. \nDetalii tranzactie: " + s);
                    gasit = true;
                }
            }
        }
        if(gasit == false)
            System.out.println("Nu s-a gasit tranzactie cu detaliile specificate");

    }

    @Override
    public void stergeClient(){
        Client c = clientRepository.cautareClient();
        clientRepository.eliminaClient(c);
    }

    public void stergeClient(Client c){

        clientRepository.eliminaClient(c);
    }

    public List<Client> getClienti(){
        return clientRepository.getClienti();
    }

    @Override
    public void afisareDetaliiComplete(){
        Client c = clientRepository.cautareClient();
        System.out.println(c.toString());
    }



}
