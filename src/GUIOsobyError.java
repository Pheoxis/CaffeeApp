import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class GUIOsobyError extends JFrame {

    private JPanel contentPane;


    public GUIOsobyError() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JTextPane txtpnPodanaLiczbaOsb = new JTextPane();
        txtpnPodanaLiczbaOsb.setText("Podana liczba osób na jedno stanowisko jest za duza prosimy o zmniejszenie liczby osób lub rozłozenia ich na pare stanowisk");
        contentPane.add(txtpnPodanaLiczbaOsb, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        GridBagLayout gbl_buttonPanel = new GridBagLayout();
        gbl_buttonPanel.columnWidths = new int[] { 0, 0, 0 };
        gbl_buttonPanel.rowHeights = new int[] { 0, 0 };
        gbl_buttonPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
        gbl_buttonPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
        buttonPanel.setLayout(gbl_buttonPanel);

        JButton btnNewButton = new JButton("Cofnij");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUILiczbaOsob frame = new GUILiczbaOsob();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 0;
        buttonPanel.add(btnNewButton, gbc_btnNewButton);

        JButton btnNewButton_1 = new JButton("Rozdziel");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIPlatnosc frame = new GUIPlatnosc();
                frame.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 0;
        buttonPanel.add(btnNewButton_1, gbc_btnNewButton_1);
    }

}
