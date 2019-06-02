package GUI;

import model.Client;
import repository.ClientRepository;
import service.ClientService;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ClientFrame extends JFrame {


    //GUI has only CREATE / DELETE options; double click to delete (implementare din laborator)


    private ClientRepository cRep = new ClientRepository();
    private ClientService clientService = new ClientService(cRep);

    private JPanel p1 = new JPanel(new BorderLayout());
    private JPanel p2 = new JPanel();
    //p2.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


    private JLabel e1 = new JLabel("Nume:");
    private JLabel e2 = new JLabel("Venit:");
    private JLabel e3 = new JLabel("Imprumut:");
    private JLabel e4 = new JLabel("Dobanda:");
    private JLabel e5 = new JLabel("Durata:");

    private JTextField t1 = new JTextField(12);
    private JTextField t2 = new JTextField(6);
    private JTextField t3 = new JTextField(6);
    private JTextField t4 = new JTextField(6);
    private JTextField t5 = new JTextField(6);

    private JButton b1 = new JButton("ADAUGA");


    private DefaultListModel<Client> model = new DefaultListModel<>();
    private JList<Client> list = new JList<>(model);

    public ClientFrame() {

        super("Clienti");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1700, 700);
        setLocationRelativeTo(null);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);


        p2.add(e1);
        p2.add(t1);
        p2.add(e2);
        p2.add(t2);
        p2.add(e3);
        p2.add(t3);
        p2.add(e4);
        p2.add(t4);
        p2.add(e5);
        p2.add(t5);
        p2.add(b1);


        b1.addActionListener(ev -> adaugaClient());

        p1.add(list);

        list.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Client c = list.getSelectedValue();
                    if (c != null) {
                        stergeClient(c);
                    }
                }
            }

        });
        afisareClienti();

        setVisible(true);
    }

    private void adaugaClient() {
        String nume = t1.getText();
        int venit = Integer.parseInt(t2.getText());
        double suma_initiala = Double.parseDouble(t3.getText());
        double dobanda = Double.parseDouble(t4.getText());
        int durata = Integer.parseInt(t5.getText());

        clientService.creeazaClient(nume, venit, suma_initiala, dobanda, durata);
        t1.setText(null);
        t2.setText(null);
        afisareClienti();
        JOptionPane.showMessageDialog(this, "Ai adaugat un client!");
    }

    private void afisareClienti() {
        model.clear();
        List<Client> clienti = clientService.getClienti();
        clienti.forEach(c -> model.addElement(c));
    }

    private void stergeClient(Client c) {
        clientService.stergeClient(c);
        afisareClienti();
    }
}



