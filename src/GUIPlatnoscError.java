import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class GUIPlatnoscError extends JFrame {

    private JPanel contentPane;


    public GUIPlatnoscError() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JLabel lblNewLabel = new JLabel("Dany sposób płatności jest niedostępny. Prosimy wybrać inny.");
        lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Zmień");
        btnNewButton.setAlignmentX(CENTER_ALIGNMENT);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setVisible(false);
                GUIPlatnosc frame = new GUIPlatnosc();
                frame.setVisible(true);
            }
        });
        contentPane.add(btnNewButton);
    }

}
