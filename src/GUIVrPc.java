import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIVrPc extends JFrame {
    private static List<String> PcOrVr = new ArrayList<>();
    private JPanel contentPane;

    public GUIVrPc() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("PC");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == rdbtnNewRadioButton) {
                    PcOrVr.add("PC");
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

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("VR");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == rdbtnNewRadioButton_1) {
                    PcOrVr.add("VR");
                }
            }
        });
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_1.gridx = 11;
        gbc_rdbtnNewRadioButton_1.gridy = 1;
        gbc_rdbtnNewRadioButton_1.weightx = 1.0;
        gbc_rdbtnNewRadioButton_1.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton_1);
        group.add(rdbtnNewRadioButton);

        JButton btnNewButton = new JButton("Dalej");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUILiczbaOsob frame = new GUILiczbaOsob();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 8;
        gbc_btnNewButton.weightx = 1.0;
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }

    public static List<String> getPcOrVr() {
        return PcOrVr;
    }
}
