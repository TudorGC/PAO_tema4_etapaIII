package repository;
import model.Client;

import java.util.List;

public interface IClientRepository {

    public void adaugaClient(Client c);

    public void eliminaClient(Client c);

    public Client cautareClient();

    public List<Client> getClienti();

    public void afisareClienti();

}
