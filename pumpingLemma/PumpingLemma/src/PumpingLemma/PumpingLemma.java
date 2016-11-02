package PumpingLemma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PumpingLemma {

	private JFrame frame;
	private JTextField txtSelectTheLanguage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PumpingLemma window = new PumpingLemma();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PumpingLemma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRegularLanguage = new JButton("Regular Language");
		btnRegularLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegularLanguage nw = new RegularLanguage();
				nw.NewScreen();
				frame.setVisible(false);
			}
		});
		btnRegularLanguage.setBounds(39, 78, 203, 35);
		frame.getContentPane().add(btnRegularLanguage);
		
		JButton btnContextFree = new JButton("Context Free");
		btnContextFree.setBounds(39, 138, 203, 35);
		frame.getContentPane().add(btnContextFree);
		
		txtSelectTheLanguage = new JTextField();
		txtSelectTheLanguage.setText("Select the language you want to play with");
		txtSelectTheLanguage.setBounds(39, 21, 403, 32);
		frame.getContentPane().add(txtSelectTheLanguage);
		txtSelectTheLanguage.setColumns(10);
	}
}
