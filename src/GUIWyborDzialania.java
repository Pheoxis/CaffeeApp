import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIWyborDzialania extends JFrame {

    private JPanel contentPane;

    public GUIWyborDzialania() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Wybierz co chcesz zrobić:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 2;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        JButton btnNewButton_1 = new JButton("Zloz rezerwacje");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUITerminy frame = new GUITerminy();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 0;
        gbc_btnNewButton_1.gridy = 1;
        contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Zarzadzaj kontem");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIFunkcjeKlienta frame = new GUIFunkcjeKlienta();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2.gridx = 1;
        gbc_btnNewButton_2.gridy = 1;
        contentPane.add(btnNewButton_2, gbc_btnNewButton_2);

        JButton btnNewButton = new JButton("Wyjdz");
        btnNewButton.addActionListener(new ActionListener() {
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

                System.exit(0);
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 3;
        gbc_btnNewButton.gridy = 6;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }
}
