import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.Insets;

public class GUITerminy extends JFrame {
    private static List<LocalDateTime> time = new ArrayList<>();
    private static List<Integer> howLong = new ArrayList<>();
    private static List<Integer> ex = new ArrayList<>();
    private JPanel contentPane;
    private JTextField textField;
    private JComboBox<LocalDateTime> comboBox;
    private JComboBox<String> comboBox_1;

    public GUITerminy() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 150, 150 };
        gbl_contentPane.rowHeights = new int[] { 30, 30, 30, 30 };
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Wybierz termin rezerwacji:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        LocalDateTime[] termin = new LocalDateTime[Rezerwacja.getRezerwacjeDataSet().size()];

        for (int i = 0; i <termin.length ; i++) {
            termin[i]=Rezerwacja.getRezerwacjeDataSet().get(i).getDataRozpoczecia();
        }

        comboBox = new JComboBox<>(termin);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboBox) {
                    time.add((LocalDateTime) comboBox.getSelectedItem());
                    updateComboBox1();
                }
            }
        });
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 0;
        contentPane.add(comboBox, gbc_comboBox);

        JLabel lblNewLabel_1 = new JLabel("Liczba godzin:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        contentPane.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Wybierz pracownika");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 3;
        contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

        comboBox_1 = new JComboBox<>();
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.gridx = 1;
        gbc_comboBox_1.gridy = 3;
        contentPane.add(comboBox_1, gbc_comboBox_1);

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
                    PracujacyWlasciciel.showExtent();
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
        gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton_1.gridx = 0;
        gbc_btnNewButton_1.gridy = 14;
        contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

        JButton btnNewButton = new JButton("Dalej");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIDostepneGry frame = new GUIDostepneGry();
                frame.setVisible(true);
                howLong.add(Integer.parseInt(textField.getText()));
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.EAST;
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 14;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }

    private void updateComboBox1() {
        Object selectedValue = comboBox.getSelectedItem();
        if (selectedValue != null) {
            String selectedDate = String.valueOf(selectedValue);
            for (Rezerwacja rezerwacja : Rezerwacja.getRezerwacjeDataSet()) {
                if (String.valueOf(rezerwacja.getDataRozpoczecia()).equals(selectedDate)) {
                    List<PracownikSalonuGier> pracownicy = rezerwacja.getPracownikSalonuGiers();
                    comboBox_1.removeAllItems();
                    for (PracownikSalonuGier pracownik : pracownicy) {
                        comboBox_1.addItem(pracownik.getAdresMail());
                    }
                    break;
                }
            }
        }
    }

    public static List<LocalDateTime> getTime() {
        return time;
    }

    public static List<Integer> getHowLong() {
        return howLong;
    }

    public static List<Integer> getEx() {
        return ex;
    }
}
