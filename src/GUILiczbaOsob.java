import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class GUILiczbaOsob extends JFrame {

    private static List<Integer> liczbaOsob=new ArrayList<Integer>();
    private JPanel contentPane;
    private JTextField textField;


    public GUILiczbaOsob() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;  // kolumna 0
        constraints.gridy = 0;  // wiersz 0
        constraints.fill = GridBagConstraints.NONE;  // brak rozszerzania
        constraints.anchor = GridBagConstraints.CENTER;  // wyrównanie do środka



        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Podaj liczbe osób");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 4;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 1;
        contentPane.add(textField, gbc_textField);
        textField.setColumns(10);


        JButton btnNewButton = new JButton("Dalej");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(textField.getText())>10){
                    contentPane.setVisible(false);
                    GUIOsobyError frame = new GUIOsobyError();
                    frame.setVisible(true);
                }else {
                    contentPane.setVisible(false);
                    GUIPlatnosc frame = new GUIPlatnosc();
                    frame.setVisible(true);
                }
                liczbaOsob.add(Integer.parseInt(textField.getText()));
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 6;
        gbc_btnNewButton.gridy = 12;
        contentPane.add(btnNewButton, gbc_btnNewButton);

    }

    public static List<Integer> getLiczbaOsob() {
        return liczbaOsob;
    }
}
