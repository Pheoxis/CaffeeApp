import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIZnizka extends JFrame {
    private static List<String> uwagi = new ArrayList<>();
    private static List<String> klient = new ArrayList<>();
    private JPanel contentPane;
    private JTextField textField;



    public GUIZnizka() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Nowy klient");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == rdbtnNewRadioButton) {
                    klient.add("Nowy klient");
                }
            }
        });
        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton.gridx = 1;
        gbc_rdbtnNewRadioButton.gridy = 1;
        gbc_rdbtnNewRadioButton.weightx = 1.0;
        gbc_rdbtnNewRadioButton.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Staly klient");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == rdbtnNewRadioButton_1) {
                    klient.add("Stały klient");
                }
            }
        });
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_1.gridx = 9;
        gbc_rdbtnNewRadioButton_1.gridy = 1;
        gbc_rdbtnNewRadioButton_1.weightx = 1.0;
        gbc_rdbtnNewRadioButton_1.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);

        JButton btnNewButton = new JButton("Dalej");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIEnd frame = null;
                try {
                    frame = new GUIEnd();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                frame.setVisible(true);
                uwagi.add(textField.getText());
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 9;
        gbc_btnNewButton.gridy = 12;
        gbc_btnNewButton.weightx = 1.0;
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(btnNewButton, gbc_btnNewButton);

        JLabel lblNewLabel = new JLabel("Uwagi");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 8;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 2;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 8;
        gbc_textField.weightx = 1.0;
        contentPane.add(textField, gbc_textField);
        textField.setColumns(10);
    }

    public static List<String> getKlient() {
        return klient;
    }

    public static List<String> getUwagi() {
        return uwagi;
    }
}
