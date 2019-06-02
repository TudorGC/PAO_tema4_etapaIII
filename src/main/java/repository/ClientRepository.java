package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import model.Client;
import exceptions.ClientNotFoundException;


public class ClientRepository implements IClientRepository {

    private List<Client> clienti = new ArrayList<>();

    private String url = "jdbc:mysql://localhost/clienti";
    private String username = "user1";
    private String password = "12345";

    @Override
    public void adaugaClient(Client c){

            String  sql = "INSERT INTO general VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
            try (
                    Connection con = DriverManager.getConnection(url, username, password);
                    PreparedStatement s = con.prepareStatement(sql);
            ) {

                s.setString(1, c.getNume());
                s.setInt(2, c.getVenit());
                s.setDouble(3, c.getSumaInit());
                s.setDouble(4, c.getDobanda());
                s.setDouble(5, c.soldDisponibil());
                s.setInt(6, c.getDurata());
                s.setDouble(7, c.getRata());

                s.executeUpdate(); // INSERT, UPDATE, DELETE
            } catch (Exception e) { // SQLException
                e.printStackTrace();
            }
        }



    @Override
    public void eliminaClient(Client c){
        String sql = "DELETE FROM general WHERE id = ?";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setInt(1, c.getCust_ID());
            s.executeUpdate();
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }

    public String cautareAll(String s){

        String found = "negasit";
        Boolean gasit = false;

        while(gasit == false){

            for(int i=0; i < clienti.size(); i++) {
                gasit = false;

                if(clienti.get(i).getNume().toLowerCase().contains(s.toLowerCase())) {
                    found = "Client gasit. \n Detalii " + clienti.get(i).toString();
                    gasit = true;
                }
            }
        }
        return found;
    }



    @Override
    public Client cautareClient(){
        //return statement luat din laborator 5


        this.getClienti();

        System.out.println("Client - Cautare \nIntroduceti nume complet: ");
        Scanner scan = new Scanner(System.in);
        String deCautat = scan.nextLine();
        return clienti
                .stream()
                .filter(c -> (c.getNume()).toLowerCase().equals((deCautat).toLowerCase()))
                .findFirst()
                .map(c -> c)
                .orElseThrow(ClientNotFoundException::new);
    }


    @Override
    public List<Client> getClienti(){
        //List<Client> list = new ArrayList<>();

        this.clienti.clear();
        String sql = "SELECT * FROM general";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
                ResultSet rs = s.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                int venit = rs.getInt("venit");
                double suma_init = rs.getDouble("suma_initiala");
                double dobanda = rs.getDouble("dobanda");
                int durata = rs.getInt("durata");

                clienti.add(new Client(id, nume, venit, suma_init,dobanda,durata));
            }
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }

        return clienti;
    }

    @Override
    public void afisareClienti() {
        this.getClienti();
        for(Client b:clienti)
            System.out.println(b);
    }

    public void sortareDupaSumaDePlata(){

        Collections.sort(clienti);
        System.out.println(clienti);
    }
}
