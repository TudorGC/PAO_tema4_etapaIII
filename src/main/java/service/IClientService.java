package service;
import model.Credit;
import model.Client;
import repository.ClientRepository;

import java.util.List;

public interface IClientService {

    public List<String> istoricTranzactii();
    public void cautareTranzactie();
    public double interogareSold();
    public void actualizareDatePers();
    public void creeazaClient();
    public void stergeClient();
    public void afisareDetaliiComplete();


}
