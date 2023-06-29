import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIDostepneGry extends JFrame {
    private static List<Gra> gameList = new ArrayList<>();
    private static List<Integer> ex = new ArrayList<>();
    private JPanel contentPane;

    public GUIDostepneGry() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Wybierz gry z listy");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        String[] gry = new String[Gra.getListaGierGui().size()];
        for (int i = 0; i < gry.length; i++) {
            gry[i] = Gra.getListaGierGui().get(i).getNazwa();
        }
        JList list = new JList(gry);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(list);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 0;
        gbc_scrollPane.gridheight = 2;
        contentPane.add(scrollPane, gbc_scrollPane);

        JButton btnNewButton_1 = new JButton("Anuluj");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Rezerwacja.showExtent();
                    Rezerwacja.saveExtent();
                    Klient.showExtent();
                    Klient.saveExtent();
                    Gra.showExtent();
                    Gra.saveExtent();
                    Stanowisko.showExtent();
                    Stanowisko.saveExtent();
                    VR.showExtent();
                    VR.saveExtent();
                    Uwagi.showExtent();
                    Uwagi.saveExtent();
                    Wlasciciel.showExtent();
                    Wlasciciel.saveExtent();
                    PracownikSalonuGier.showExtent();
                    PracownikSalonuGier.saveExtent();
                    Komputer.showExtent();
                    Komputer.saveExtent();
                    Umiejetnosci.showExtent();
                    Umiejetnosci.saveExtent();
                    Dyzur.showExtent();
                    Dyzur.saveExtent();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                ex.add(1);
                System.exit(0);
            }
        });
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_1.gridx = 0;
        gbc_btnNewButton_1.gridy = 2;
        contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Zmień termin");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUITerminy frame = new GUITerminy();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_2.gridx = 2;
        gbc_btnNewButton_2.gridy = 2;
        contentPane.add(btnNewButton_2, gbc_btnNewButton_2);

        JButton btnNewButton = new JButton("Dalej");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIVrPc frame = new GUIVrPc();
                frame.setVisible(true);
                for (int i = 0; i < list.getSelectedValuesList().size(); i++) {
                    gameList.add((Gra)  returngame((ArrayList<Gra>) Gra.listaGierGui,String.valueOf(list.getSelectedValuesList().get(i))) );
                }
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 2;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }

    public static List<Gra> getGameList() {
        return gameList;
    }

    public static List<Integer> getEx() {
        return ex;
    }

    public Gra returngame(ArrayList<Gra> gra,String nazwa){
        Gra ok=null;
        for (int i = 0; i <gra.size() ; i++) {
            if (gra.get(i).getNazwa().equals(nazwa)){
                ok = gra.get(i);
            }
        }
        return ok;
    }
}
