//Tudor Ceapraz gr. 231
//Tema 4

package main;

import GUI.ClientFrame;
import repository.ClientRepository;
import service.ClientService;
import model.Client;

import java.util.Scanner;


public class Main {

//    public static void displayOP(){
//        System.out.println("------------------------------");
//        System.out.println ( "1. Adaugare client" ) ;
//        System.out.println ( "2. Cautare client" );
//        System.out.println ( "3. Eliminare client" ) ;
//        System.out.println ( "4. Afisare clienti " ) ;
//        System.out.println ( "5. Consultare sold per client " ) ;
//        System.out.println ( "6. Istoric tranzactii per client (nefunctional momentan)" ) ;
//        System.out.println ( "7. Cautare tranzactie per client (nefunctional momentan)");
//        System.out.println ( "8. Sortare dupa suma de plata ");
//        System.out.println ( "9. Operatii disponibile ");
//        System.out.println ( "0. Iesire");
//        System.out.println("------------------------------");
//    }



    public static void main(String[] args) {

        //GUI has only CREATE / DELETE options



        ClientRepository rep = new ClientRepository();


        //cativa clienti si activitate

        Client c1 = new Client("John Doe", 15000);
        c1.setCredit(50000, 5.5, 60);
        c1.withdraw(1234);
        c1.withdraw(111);
        c1.deposit(333);


        Client c2 = new Client("Rick Sanchez", 20000);
        c2.setCredit(100000, 6.2, 24);
        c2.withdraw(456);
        c2.withdraw(222);
        c2.deposit(1134);

        Client c3 = new Client("Peter Parker", 5000);
        c3.setCredit(11000, 7.6, 24);
        c3.withdraw(1100);
        c3.withdraw(500);
        c3.deposit(250);

        System.out.println(c3.istoricTranzactii());

        rep.adaugaClient(c1);
        rep.adaugaClient(c2);
        rep.adaugaClient(c3);

        ClientFrame cf = new ClientFrame();





//
//        Scanner input = new Scanner(System.in);
//
//
//
//        int Choice;
//
//        {
//
//
//
//            int exit = 1;
//            do{
//                displayOP();
//                Choice = input.nextInt();
//
//
//            switch (Choice)
//            {
//                case 1:
//                    admin.creeazaClient();
//
//                    /*System.out.println("Tip credit: ");
//                    Scanner in = new Scanner(System.in);
//                    String tip = in.next();
//
//                    switch (tip){
//                        case "consum":
//
//                    }*/
//
//
//                    break;
//
//
//                case 2:
//                    System.out.println(rep.cautareClient());
//                    break;
//
//                case 3:
//                    admin.stergeClient();
//                    break;
//
//                case 4:
//                    rep.afisareClienti();
//                    break;
//
//                case 5:
//                    System.out.println(admin.interogareSold());
//                    break;
//
//                case 6:
//                    System.out.println(admin.istoricTranzactii());
//                    break;
//
//                case 7:
//                    admin.cautareTranzactie();
//                    break;
//
//                case 8:
//                    //System.out.println("to do");
//                    rep.sortareDupaSumaDePlata();
//                    break;
//
//                case 9:
//                    displayOP();
//                    break;
//
//
//                case 0:
//                    exit = 0;
//                    break;
//
//
//
//
//
//            }
//            } while(exit !=0);
//        }



    }


}
