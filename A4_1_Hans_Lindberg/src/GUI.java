import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;  

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField fieldHuman;
	private JTextField fieldDog;
	private JTextField fieldInfo;
	private JTextField fieldError;
	
	static Human human;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New Human");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fieldHuman.getText().length() >= 3){
					fieldError.setText("");
					human = new Human(fieldHuman.getText());
				}
				else{
					fieldError.setText("Please give the human a longer name!");
				}
			}
		});
		btnNewButton.setBounds(277, 11, 147, 23);
		contentPane.add(btnNewButton);
		

		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fieldDog.getText().length() > 0){
					fieldError.setText("");
					if(human == null){
						fieldError.setText("The dog needs an owner to be bought!");
					}
					else{
						fieldError.setText("");
						human.buyDog(new Dog(fieldDog.getText()));
					}		
				}
				else{
					fieldError.setText("Please write a name for the dog!");
				}
			}
		});
		btnBuyDog.setBounds(277, 46, 147, 23);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (human != null){
						fieldError.setText("");
						fieldInfo.setText(human.getInfo());
					}
					else{
						fieldError.setText("No info to print!");
					}
			}
		});
		btnPrintInfo.setBounds(277, 80, 147, 23);
		contentPane.add(btnPrintInfo);
		
		fieldHuman = new JTextField();
		fieldHuman.setBounds(181, 11, 86, 20);
		contentPane.add(fieldHuman);
		fieldHuman.setColumns(10);
		
		fieldDog = new JTextField();
		fieldDog.setColumns(10);
		fieldDog.setBounds(181, 46, 86, 20);
		contentPane.add(fieldDog);
		
		fieldInfo = new JTextField();
		fieldInfo.setEditable(false);
		fieldInfo.setColumns(10);
		fieldInfo.setBounds(10, 124, 414, 43);
		contentPane.add(fieldInfo);
		
		fieldError = new JTextField();
		fieldError.setEditable(false);
		fieldError.setColumns(10);
		fieldError.setBounds(10, 203, 414, 47);
		contentPane.add(fieldError);
		
		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		lblHumansAndDogs.setBounds(10, 11, 161, 47);
		contentPane.add(lblHumansAndDogs);
		
		JLabel lblError = new JLabel("Error");
		lblError.setBounds(10, 178, 46, 14);
		contentPane.add(lblError);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(10, 99, 46, 14);
		contentPane.add(lblInfo);
	}
}
