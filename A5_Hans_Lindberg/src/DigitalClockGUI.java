import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fieldH;
	private JTextField fieldM;
	
	private JLabel labelTime = new JLabel("00:00:00");
	
	private ClockLogic clockLogic;

	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
					frame.setVisible(true);
					System.out.println("Hej");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public DigitalClockGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DigitalClockGUI.class.getResource("/images/Clock-icon.png")));
		setTitle("AlarmClock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		labelTime.setFont(new Font("Cooper Std Black", Font.PLAIN, 28));
		labelTime.setBounds(54, 11, 124, 44);
		contentPane.add(labelTime);
		
		JLabel lblNewLabel_1 = new JLabel("H:");
		lblNewLabel_1.setBounds(10, 236, 11, 14);
		contentPane.add(lblNewLabel_1);
		
		fieldH = new JTextField();
		fieldH.setBounds(31, 233, 30, 20);
		contentPane.add(fieldH);
		fieldH.setColumns(10);
		
		JLabel lblM = new JLabel("M:");
		lblM.setBounds(71, 236, 17, 14);
		contentPane.add(lblM);
		
		fieldM = new JTextField();
		fieldM.setColumns(10);
		fieldM.setBounds(98, 233, 30, 20);
		contentPane.add(fieldM);
		
		JButton buttonClear = new JButton("Clear Alarm");
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonClear.setBounds(309, 232, 115, 23);
		contentPane.add(buttonClear);
		
		JButton buttonSet = new JButton("Set Alarm");
		buttonSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonSet.setBounds(184, 232, 115, 23);
		contentPane.add(buttonSet);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(10, 29, 46, 14);
		contentPane.add(lblTime);
		
		JLabel labelAlarm = new JLabel("00:00");
		labelAlarm.setBounds(54, 66, 142, 14);
		contentPane.add(labelAlarm);
		
		JLabel lblAlarm = new JLabel("Alarm:");
		lblAlarm.setBounds(10, 66, 46, 14);
		contentPane.add(lblAlarm);
		
		JLabel imageClock = new JLabel("New label");
		imageClock.setBackground(Color.LIGHT_GRAY);
		imageClock.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/clock.png")));
		imageClock.setBounds(236, 29, 188, 178);
		contentPane.add(imageClock);
	}
	
	public void setTimeOnLabel(String time){
		labelTime.setText(time);
		System.out.println("label set");
	}
	
	public void alarm(boolean activate){
		
	}
}
