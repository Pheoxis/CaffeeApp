import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUIPlatnosc extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public GUIPlatnosc() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblNewLabel = new JLabel("                    Wybierz sposob platnosci");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Gotówka");

        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton.gridx = 0;
        gbc_rdbtnNewRadioButton.gridy = 1;
        panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Przelew");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIPlatnoscError frame = new GUIPlatnoscError();
                frame.setVisible(true);

            }
        });
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.NORTHEAST;
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_1.gridx = 2;
        gbc_rdbtnNewRadioButton_1.gridy = 1;
        panel.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_1 = new JLabel("Nr. karty");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 3;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.anchor = GridBagConstraints.NORTH;
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 3;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Imie i Nazwisko");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 4;
        panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.anchor = GridBagConstraints.NORTH;
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 4;
        panel.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("PIN");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 5;
        panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.anchor = GridBagConstraints.NORTH;
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 5;
        panel.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton = new JButton("Dalej");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIZnizka frame = new GUIZnizka();
                frame.setVisible(true);

            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 7;
        panel.add(btnNewButton, gbc_btnNewButton);

        // Add weight and fill properties for responsiveness
        gbc_lblNewLabel.weightx = 1.0;
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.gridwidth = GridBagConstraints.REMAINDER;

        gbc_rdbtnNewRadioButton.weightx = 1.0;
        gbc_rdbtnNewRadioButton.fill = GridBagConstraints.HORIZONTAL;

        gbc_rdbtnNewRadioButton_1.weightx = 1.0;
        gbc_rdbtnNewRadioButton_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_rdbtnNewRadioButton_1.gridwidth = GridBagConstraints.REMAINDER;

        gbc_textField.weightx = 1.0;
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridwidth = GridBagConstraints.REMAINDER;

        gbc_textField_1.weightx = 1.0;
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridwidth = GridBagConstraints.REMAINDER;

        gbc_textField_2.weightx = 1.0;
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridwidth = GridBagConstraints.REMAINDER;

        gbc_btnNewButton.weightx = 1.0;
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;

        pack(); // Adjust the size of the frame to fit the components
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
