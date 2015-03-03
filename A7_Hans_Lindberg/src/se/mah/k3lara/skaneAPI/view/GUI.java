package se.mah.k3lara.skaneAPI.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	
	@SuppressWarnings("unused")
	private SearchThread t;

	JLabel labelTitle = new JLabel("Ub\u00E5tshallen");
	JLabel lblLinje = new JLabel("Linje");
	JLabel lblNewLabel = new JLabel("Destination");
	JLabel lblNewLabel_1 = new JLabel("Avg\u00E5r");
	JLabel lblLateTitle = new JLabel("Sen?");

	JLabel labelLinje1 = new JLabel("");
	JLabel labelLinje2 = new JLabel("");
	JLabel labelLinje3 = new JLabel("");
	JLabel labelLinje4 = new JLabel("");

	JLabel labelDes1 = new JLabel("");
	JLabel labelDes2 = new JLabel("");
	JLabel labelDes3 = new JLabel("");
	JLabel labelDes4 = new JLabel("");

	JLabel labelTime1 = new JLabel("");
	JLabel labelTime2 = new JLabel("");
	JLabel labelTime3 = new JLabel("");
	JLabel labelTime4 = new JLabel("");
	
	JLabel labelLate1 = new JLabel("");
	JLabel labelLate2 = new JLabel("");
	JLabel labelLate3 = new JLabel("");
	JLabel labelLate4 = new JLabel("");
	
	

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
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		labelTitle.setForeground(Color.YELLOW);
		labelTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		labelTitle.setBounds(157, 11, 116, 14);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelTitle);


		lblLinje.setForeground(Color.YELLOW);
		lblLinje.setBounds(10, 57, 46, 14);
		contentPane.add(lblLinje);


		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(88, 57, 93, 14);
		contentPane.add(lblNewLabel);


		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(378, 57, 46, 14);
		contentPane.add(lblNewLabel_1);


		labelLinje1.setForeground(Color.YELLOW);
		labelLinje1.setBounds(10, 82, 46, 14);
		contentPane.add(labelLinje1);


		labelLinje2.setForeground(Color.YELLOW);
		labelLinje2.setBounds(10, 107, 46, 14);
		contentPane.add(labelLinje2);


		labelLinje3.setForeground(Color.YELLOW);
		labelLinje3.setBounds(10, 132, 46, 14);
		contentPane.add(labelLinje3);

		labelLinje4.setForeground(Color.YELLOW);
		labelLinje4.setBounds(10, 157, 46, 14);
		contentPane.add(labelLinje4);

		labelDes1.setForeground(Color.YELLOW);
		labelDes1.setBounds(86, 82, 248, 14);
		contentPane.add(labelDes1);


		labelDes2.setForeground(Color.YELLOW);
		labelDes2.setBounds(88, 107, 248, 14);
		contentPane.add(labelDes2);

		labelDes3.setForeground(Color.YELLOW);
		labelDes3.setBounds(88, 132, 248, 14);
		contentPane.add(labelDes3);

		labelDes4.setForeground(Color.YELLOW);
		labelDes4.setBounds(88, 157, 248, 14);
		contentPane.add(labelDes4);


		labelTime1.setForeground(Color.YELLOW);
		labelTime1.setBounds(378, 82, 46, 14);
		contentPane.add(labelTime1);

		labelTime2.setForeground(Color.YELLOW);
		labelTime2.setBounds(378, 107, 46, 14);
		contentPane.add(labelTime2);

		labelTime3.setForeground(Color.YELLOW);
		labelTime3.setBounds(378, 132, 46, 14);
		contentPane.add(labelTime3);

		labelTime4.setForeground(Color.YELLOW);
		labelTime4.setBounds(378, 157, 46, 14);
		contentPane.add(labelTime4);
		
		lblLateTitle.setForeground(Color.YELLOW);
		lblLateTitle.setBounds(354, 573, 614, 14);
		contentPane.add(lblLateTitle);
		
		labelLate1.setBounds(354, 82, 14, 14);
		labelLate1.setForeground(Color.YELLOW);
		contentPane.add(labelLate1);
		labelLate2.setBounds(354, 107, 13, 14);
		labelLate2.setForeground(Color.YELLOW);
		contentPane.add(labelLate2);
		labelLate3.setBounds(354, 132, 14, 13);
		labelLate3.setForeground(Color.YELLOW);
		contentPane.add(labelLate3);
		labelLate4.setBounds(354, 157, 14, 14);
		labelLate4.setForeground(Color.YELLOW);
		contentPane.add(labelLate4);

		//Calls the update once, to draw the labels.
		UpdateLabels();
		
		//Starts the SearchThread to allow for more updates.
		Thread t = new SearchThread(this);
		t.start();
		System.out.println("thread started");
	}

	public void UpdateLabels(){
		Lines lines = Parser.getStationResults(new Station("80046"));

		//Line number of the bus.
		labelLinje1.setText(lines.getLines().get(0).getLine());
		labelLinje2.setText(lines.getLines().get(1).getLine());
		labelLinje3.setText(lines.getLines().get(2).getLine());
		labelLinje4.setText(lines.getLines().get(3).getLine());

		//The destination of the bus.
		labelDes1.setText(lines.getLines().get(0).getDestination());
		labelDes2.setText(lines.getLines().get(1).getDestination());
		labelDes3.setText(lines.getLines().get(2).getDestination());
		labelDes4.setText(lines.getLines().get(3).getDestination());
		
		//Fixes the times, putting a '0' if needed.
		labelTime1.setText(FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.MINUTE)));
		labelTime2.setText(FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.MINUTE)));
		labelTime3.setText(FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.MINUTE)));
		labelTime4.setText(FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.MINUTE)));
		
		//Prints the time in minutes reflecting how late a given buss is.
		try {
			if (Integer.parseInt(lines.getLines().get(0).getDepTimeDeviation()) > 0){
				labelLate1.setText("+" + lines.getLines().get(0).getDepTimeDeviation());
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("late1 == null");
		}
		try {
			if (Integer.parseInt(lines.getLines().get(1).getDepTimeDeviation()) > 0){
				labelLate2.setText("+" + lines.getLines().get(1).getDepTimeDeviation());
			}
		} catch (NumberFormatException e2) {
			// TODO Auto-generated catch block
			//e2.printStackTrace();
			System.out.println("late2 == null");
		}
		try {
			if (Integer.parseInt(lines.getLines().get(2).getDepTimeDeviation()) > 0){
				labelLate3.setText("+" + lines.getLines().get(2).getDepTimeDeviation());
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("late3 == null");
		}
		try {
			if (Integer.parseInt(lines.getLines().get(3).getDepTimeDeviation()) > 0){
				labelLate4.setText("+" + lines.getLines().get(3).getDepTimeDeviation());
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("late4 == null");
		}
		
	}

	public String FixThatClock(int time){
		// Used to create a '0' if a number is single digit, to
		// make it look nicer.
		String zero = "";

		if (time < 10) {
			zero = "0";
		}

		// Compiles the value into a nice, readable string.
		String finalTimeString = zero + Integer.toString(time);

		zero = "";
		
		return finalTimeString;
	}
}
