import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIFunkcjeKlienta extends JFrame {
    private static List<Integer> ex = new ArrayList<>();
    private JPanel contentPane;


    public GUIFunkcjeKlienta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Wybierz co chcesz zrobić:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        JButton btnNewButton = new JButton("Aktualizuj dane osobowe");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIPersonalDataEd frame = new GUIPersonalDataEd();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 1;
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
        contentPane.add(btnNewButton, gbc_btnNewButton);

        JButton btnNewButton_1 = new JButton("Przeglądaj rezerwacje");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1).lookAtReservation();
            }
        });
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 2;
        gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Poproś o usunięcie danych");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1).askToDeleteData();
                contentPane.setVisible(false);
                GUILogin frame = new GUILogin();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2.gridx = 1;
        gbc_btnNewButton_2.gridy = 3;
        gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(btnNewButton_2, gbc_btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Poproś o dostęp do danych");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUILogin.getKlientsList().get(GUILogin.getKlientsList().size() - 1).askForAccess();
            }
        });
        GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
        gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_3.gridx = 1;
        gbc_btnNewButton_3.gridy = 4;
        gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(btnNewButton_3, gbc_btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Wyjdź");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIWyborDzialania frame = new GUIWyborDzialania();
                frame.setVisible(true);
                ex.add(1);
            }
        });
        GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
        gbc_btnNewButton_4.gridx = 1;
        gbc_btnNewButton_4.gridy = 5;
        gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_4.anchor = GridBagConstraints.SOUTH;
        contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
    }

    public static List<Integer> getEx() {
        return ex;
    }
}
