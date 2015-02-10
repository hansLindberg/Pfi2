import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.util.*;


public class GUI extends JFrame {

	private JPanel contentPane;
	
	private ArrayList<Animal> animals = new ArrayList<Animal>();

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 414, 214);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblAnimals = new JLabel("Animals");
		lblAnimals.setBounds(10, 11, 46, 14);
		contentPane.add(lblAnimals);
		
		
		//Fills the list with animals and writes it into the textarea.
		
		animals.add(new Snake("slingrigus serpentus", false));
		animals.add(new Dog("hund", "barkus svansus", true));
		animals.add(new Cat("purrus meowus", 10, 5));
		animals.add(new Snake("slingrigare serpentus", true));
		animals.add(new Dog("barkussss svansigare", false, 8));
		
		for (int i = 0; i < animals.size(); i++){
			textArea.append(animals.get(i).getInfo() + "\n");
		}
		
		
		
	}
}
