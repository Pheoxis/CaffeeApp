import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUIEnd extends JFrame {
    private JPanel contentPane;
    private JTextField textField;


    public GUIEnd() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        JTextArea txtrAsdfdsfs = new JTextArea();
        if (GUIZnizka.getKlient().get(GUIZnizka.getKlient().size() - 1).equals("Staly klient")
                && !GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1).isPierwszeWejscie()) {
            txtrAsdfdsfs.setText("Data rezerwacji: " + GUITerminy.getTime().get(GUITerminy.getTime().size() - 1) + "\n"
                    + "Liczba godzin: " + GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1) + "\n"
                    + "Urządzenie:  " + GUIVrPc.getPcOrVr().get(GUIVrPc.getPcOrVr().size() - 1) + "\n" + "Liczba osob:  "
                    + GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1) + "\n" + "Gry: "
                    + GUIDostepneGry.getGameList().get(GUIDostepneGry.getGameList().size() - 1).getNazwa() + "\n"
                    + "Forma platnosci: gotówka" + "\n" + "Klient: "
                    + GUIZnizka.getKlient().get(GUIZnizka.getKlient().size() - 1) + "\n" + "Naleznosc : " + value());
        } else {
            txtrAsdfdsfs.setText("Data rezerwacji: " + GUITerminy.getTime().get(GUITerminy.getTime().size() - 1) + "\n"
                    + "Liczba godzin: " + GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1) + "\n"
                    + "Urządzenie:  " + GUIVrPc.getPcOrVr().get(GUIVrPc.getPcOrVr().size() - 1) + "\n" + "Liczba osob:  "
                    + GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1) + "\n" + "Gry: "
                    + GUIDostepneGry.getGameList().get(GUIDostepneGry.getGameList().size() - 1).getNazwa() + "\n"
                    + "Forma platnosci: gotówka" + "\n" + "Klient: "
                    + GUIZnizka.getKlient().get(GUIZnizka.getKlient().size() - 1) + "\n" + "Naleznosc : "
                    + (((GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1)) * 50
                    + (GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1)) * 30) * 0.75));
        }

        GridBagConstraints gbc_txtrAsdfdsfs = new GridBagConstraints();
        gbc_txtrAsdfdsfs.insets = new Insets(0, 0, 5, 0);
        gbc_txtrAsdfdsfs.fill = GridBagConstraints.BOTH;
        gbc_txtrAsdfdsfs.gridx = 1;
        gbc_txtrAsdfdsfs.gridy = 2;
        gbc_txtrAsdfdsfs.gridwidth = 3; // Span three columns
        gbc_txtrAsdfdsfs.weightx = 1.0; // Fill the horizontal space
        gbc_txtrAsdfdsfs.weighty = 1.0; // Fill the vertical space
        txtrAsdfdsfs.setEditable(false);
        contentPane.add(txtrAsdfdsfs, gbc_txtrAsdfdsfs);

        JButton btnNewButton = new JButton("Akceptuj");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIWyborDzialania frame = new GUIWyborDzialania();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 6;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }

    public int value() {
        if (GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1).getLiczbaWizyt() < 6) {
            return (int) (((GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1)) * 50
                    + (GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1)) * 30));
        } else if (GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1).getLiczbaWizyt() > 5) {
            return (int) (((GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1)) * 50
                    + (GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1)) * 30) * 0.90);
        } else if (GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1).getLiczbaWizyt() > 15) {
            return (int) (((GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1)) * 50
                    + (GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1)) * 30) * 0.80);
        } else {
            return (int) (((GUITerminy.getHowLong().get(GUITerminy.getHowLong().size() - 1)) * 50
                    + (GUILiczbaOsob.getLiczbaOsob().get(GUILiczbaOsob.getLiczbaOsob().size() - 1)) * 30) * 0.75);
        }
    }
}
