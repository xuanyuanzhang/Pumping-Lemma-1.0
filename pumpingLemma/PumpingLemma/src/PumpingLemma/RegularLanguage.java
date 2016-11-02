package PumpingLemma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class RegularLanguage {

	private JFrame frame;
	private JTextField txtPumpingLemmaFor;
	private JTextField txtAttack;
	private JTextField txtDefend;
	private JTextField AttackInstruction;
	private JTextField DefendInstruction;

	private List<String> attIns = new ArrayList<String>();
	boolean a = attIns.add("Create a String longer than n please");
	boolean b = attIns.add("How many times do you want to pump (hint, 0 might be effective)");
	boolean c = attIns.add("");
	private int attTrack;
	
	private List<String> defIns = new ArrayList<String>();
	boolean d = defIns.add("Pick the length, write it below");
	boolean e = defIns.add("Partition the String into xyz");
	boolean f = defIns.add("");
	private int defTrack;
	
	private String length;
	private String sample;
	private int xyzCount;
	private String x;
	private String y;
	private String z;
	private String pumpLength;
	private String finalString;
	private JTextField txtLength;
	private JTextField txtRegex;
	private JTextField txtXIs;
	private JTextField txtYIs;
	private JTextField txtZIs;
	private JTextField txtFinal;
	private JTextField txtPumpLength;
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegularLanguage window = new RegularLanguage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String Combine(String y, String n){
		StringBuilder s = new StringBuilder();
		s.append(y);
		boolean poly = false;
		for(int i=0;i<y.length();i++){
			if(y.charAt(i)=='^'){
				if(i!=y.length()-1){
					poly = true;
					s.insert(i+1, "(");
				}
				else{
					return "";
				}
			}
		}
		if(poly){
			s.append("+");
			s.append(n+")");
		}
		else if(s.length()>1){
			s.insert(0,"(");
			s.append(")"+"^"+n);
		}
		else{
			s.append("^"+n);
		}
		
		return s.toString();
	}
	

	/**
	 * Create the application.
	 */
	public RegularLanguage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1092, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtPumpingLemmaFor = new JTextField();
		txtPumpingLemmaFor.setFont(new Font("Tahoma", Font.PLAIN, 37));
		txtPumpingLemmaFor.setText("Pumping Lemma for regular language");
		txtPumpingLemmaFor.setBounds(225, 21, 625, 57);
		frame.getContentPane().add(txtPumpingLemmaFor);
		txtPumpingLemmaFor.setColumns(10);
		
		JEditorPane AttackInput = new JEditorPane();
		AttackInput.setFont(new Font("Tahoma", Font.PLAIN, 28));
		AttackInput.setBounds(21, 392, 347, 57);
		frame.getContentPane().add(AttackInput);
		
		JButton btnAttackFinishMove = new JButton("Finish Move");
		btnAttackFinishMove.setBounds(21, 184, 141, 35);
		frame.getContentPane().add(btnAttackFinishMove);
		
		btnAttackFinishMove.setEnabled(false);
		
		JButton btnDefendFinishMove = new JButton("Finish Move");
		btnDefendFinishMove.setBounds(904, 184, 141, 35);
		frame.getContentPane().add(btnDefendFinishMove);
		
		btnDefendFinishMove.setEnabled(false);
		
		JEditorPane DefendInput = new JEditorPane();
		DefendInput.setFont(new Font("Tahoma", Font.PLAIN, 28));
		DefendInput.setBounds(698, 391, 347, 57);
		frame.getContentPane().add(DefendInput);
		
		btnAttackFinishMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(defTrack==0){
					if(AttackInput.getText().equals("")){
						JOptionPane.showMessageDialog(null, "You have to pick a string with length greater than "+length, "warning", JOptionPane.ERROR_MESSAGE);
					}
					else{
						sample = AttackInput.getText();
						txtRegex.setText(sample);
						txtRegex.setEditable(false);
						AttackInput.setText("");
						defTrack++;
						DefendInstruction.setText(defIns.get(defTrack));
						AttackInstruction.setText("");
						btnAttackFinishMove.setEnabled(false);
						btnDefendFinishMove.setEnabled(true);
					}
				}
				else if(defTrack==1){
					if(AttackInput.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Input cannot be empty", "warning", JOptionPane.ERROR_MESSAGE);
					}
					else{
						pumpLength = AttackInput.getText();
						txtPumpLength.setText(pumpLength);
						AttackInput.setText("");
						finalString = x + Combine(y,pumpLength) + z;
						txtFinal.setText(finalString);
						defTrack++;
						DefendInstruction.setText(defIns.get(defTrack));
						AttackInstruction.setText("");
						btnAttackFinishMove.setEnabled(false);
						btnDefendFinishMove.setEnabled(true);
					}
				}
				else{
					btnDefendFinishMove.setEnabled(false);
					btnAttackFinishMove.setEnabled(false);
				}
			}
		});
		
		btnDefendFinishMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(attTrack==0){
					if(DefendInput.getText().equals("")){
						JOptionPane.showMessageDialog(null, "pick a length please", "warning", JOptionPane.ERROR_MESSAGE);
					}
					else{
						length = DefendInput.getText();
						txtLength.setText(length);
						txtLength.setEditable(false);
						DefendInput.setText("");
						AttackInstruction.setText(attIns.get(attTrack));
						attTrack++;
						DefendInstruction.setText("");
						btnAttackFinishMove.setEnabled(true);
						btnDefendFinishMove.setEnabled(false);
					}
				}
				else if(attTrack==1&&xyzCount<3){
					
						if(DefendInput.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Input cannot be empty", "warning", JOptionPane.ERROR_MESSAGE);
						}
						else{
							
							if(xyzCount==0){
								x = DefendInput.getText();
								txtXIs.setText(x);
							}
							if(xyzCount==1){
								y = DefendInput.getText();
								txtYIs.setText(y);
							}
							if(xyzCount==2){
								z = DefendInput.getText();
								txtZIs.setText(z);
							}
							xyzCount++;
							DefendInput.setText("");
						}
					
				}
				else if(attTrack==1){
					AttackInstruction.setText(attIns.get(attTrack));
					attTrack++;
					btnAttackFinishMove.setEnabled(true);
					btnDefendFinishMove.setEnabled(false);
				}
				else{
					btnDefendFinishMove.setEnabled(false);
					btnAttackFinishMove.setEnabled(false);
				}
			}
		});
		
		txtAttack = new JTextField();
		txtAttack.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtAttack.setText("Attack");
		txtAttack.setBounds(21, 106, 146, 57);
		frame.getContentPane().add(txtAttack);
		txtAttack.setColumns(10);
		
		txtDefend = new JTextField();
		txtDefend.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtDefend.setText("Defend");
		txtDefend.setColumns(10);
		txtDefend.setBounds(899, 106, 146, 57);
		frame.getContentPane().add(txtDefend);
		
		AttackInstruction = new JTextField();
		AttackInstruction.setFont(new Font("Tahoma", Font.PLAIN, 28));
		AttackInstruction.setBounds(21, 300, 347, 57);
		frame.getContentPane().add(AttackInstruction);
		AttackInstruction.setColumns(10);
		
		DefendInstruction = new JTextField();
		DefendInstruction.setFont(new Font("Tahoma", Font.PLAIN, 28));
		DefendInstruction.setColumns(10);
		DefendInstruction.setBounds(698, 300, 347, 57);
		frame.getContentPane().add(DefendInstruction);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(809, 608, 141, 35);
		frame.getContentPane().add(btnBack);
		
		JButton btnGetStart = new JButton("Get Start");
		btnGetStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xyzCount = 0;
				defTrack = 0;
				attTrack = 0;
				DefendInstruction.setText(defIns.get(defTrack));
				AttackInstruction.setText("");
				txtLength.setText("Pumping length");
				txtRegex.setText("String for pumping");
				txtXIs.setText("x");
				txtYIs.setText("y");
				txtZIs.setText("z");
				txtFinal.setText("String after pumping");
				txtPumpLength.setText("Pump length");
				btnDefendFinishMove.setEnabled(true);
			}
		});
		btnGetStart.setBounds(456, 99, 122, 35);
		frame.getContentPane().add(btnGetStart);
		
		txtLength = new JTextField();
		txtLength.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtLength.setText("Pumping length");
		txtLength.setBounds(377, 144, 282, 57);
		frame.getContentPane().add(txtLength);
		txtLength.setColumns(10);
		
		txtRegex = new JTextField();
		txtRegex.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtRegex.setText("String for pumping");
		txtRegex.setBounds(377, 222, 326, 57);
		frame.getContentPane().add(txtRegex);
		txtRegex.setColumns(10);
		
		txtXIs = new JTextField();
		txtXIs.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtXIs.setText("x");
		txtXIs.setBounds(419, 300, 122, 57);
		frame.getContentPane().add(txtXIs);
		txtXIs.setColumns(10);
		
		txtYIs = new JTextField();
		txtYIs.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtYIs.setText("y");
		txtYIs.setColumns(10);
		txtYIs.setBounds(488, 365, 105, 59);
		frame.getContentPane().add(txtYIs);
		
		txtZIs = new JTextField();
		txtZIs.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtZIs.setText("z");
		txtZIs.setColumns(10);
		txtZIs.setBounds(524, 432, 122, 57);
		frame.getContentPane().add(txtZIs);
		
		txtFinal = new JTextField();
		txtFinal.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtFinal.setText("String after pumping");
		txtFinal.setColumns(10);
		txtFinal.setBounds(377, 588, 382, 55);
		frame.getContentPane().add(txtFinal);
		
		txtPumpLength = new JTextField();
		txtPumpLength.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtPumpLength.setText("Pump length");
		txtPumpLength.setColumns(10);
		txtPumpLength.setBounds(377, 510, 326, 57);
		frame.getContentPane().add(txtPumpLength);
	}
}
