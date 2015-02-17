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
import java.util.Random;

@SuppressWarnings("serial")
public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fieldH;
	private JTextField fieldM;

	Random rand = new Random();

	ClockLogic clockLogic;

	JLabel labelTime = new JLabel("00:00:00");
	JLabel labelAlarmNotice = new JLabel("");
	final JLabel labelMessage = new JLabel("");
	final JLabel labelAlarm = new JLabel("No alarm");

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				DigitalClockGUI.class.getResource("/images/Clock-icon.png")));
		setTitle("AlarmClock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		clockLogic = new ClockLogic(this);

		labelTime.setFont(new Font("Cooper Std Black", Font.PLAIN, 28));
		labelTime.setBounds(54, 11, 124, 44);
		contentPane.add(labelTime);

		JLabel lblNewLabel_1 = new JLabel("H:");
		lblNewLabel_1.setBounds(10, 236, 11, 14);
		contentPane.add(lblNewLabel_1);

		labelAlarm.setBounds(54, 66, 142, 14);
		contentPane.add(labelAlarm);

		labelAlarmNotice.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelAlarmNotice.setBounds(15, 111, 46, 14);
		contentPane.add(labelAlarmNotice);

		fieldH = new JTextField();
		fieldH.setBounds(31, 233, 30, 20);
		contentPane.add(fieldH);
		fieldH.setColumns(10);

		labelMessage.setForeground(Color.BLACK);
		labelMessage.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC,
				12));
		labelMessage.setBounds(10, 91, 416, 116);
		contentPane.add(labelMessage);

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
				fieldH.setText("");
				fieldM.setText("");
				clockLogic.clearAlarm();
			}
		});
		buttonClear.setBounds(309, 232, 115, 23);
		contentPane.add(buttonClear);

		JButton buttonSet = new JButton("Set Alarm");
		buttonSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Checks if the times set are legal.
				int hourCheck = Integer.parseInt(fieldH.getText());
				int minuteCheck = Integer.parseInt(fieldM.getText());

				if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
						|| minuteCheck > 59) {
					labelMessage.setText("Please input a legit time!");
				} else {
					String zero4 = "";
					String zero5 = "";

					if (hourCheck < 10) {
						zero4 = "0";
					}
					if (minuteCheck < 10) {
						zero5 = "0";
					}

					// Changes the alarm label to match the input alarm
					labelAlarm.setText(zero4 + hourCheck + ":" + zero5
							+ minuteCheck);

					// Sets the alarm
					clockLogic.setAlarm(hourCheck, minuteCheck);

					// Changes the color of the background, disco clock!!
					float hue = rand.nextFloat();
					float sat = (rand.nextInt(2000) + 5000) / 10000f;
					float lum = 0.8f;
					Color color = Color.getHSBColor(hue, sat, lum);

					contentPane.setBackground(color);

					zero4 = "";
					zero5 = "";

					labelMessage.setText("");
					labelAlarmNotice.setText("");

				}

			}
		});
		buttonSet.setBounds(184, 232, 115, 23);
		contentPane.add(buttonSet);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(10, 29, 46, 14);
		contentPane.add(lblTime);

		JLabel lblAlarm = new JLabel("Alarm:");
		lblAlarm.setBounds(10, 66, 46, 14);
		contentPane.add(lblAlarm);

		JLabel imageClock = new JLabel("New label");
		imageClock.setBackground(Color.LIGHT_GRAY);
		imageClock.setIcon(new ImageIcon(DigitalClockGUI.class
				.getResource("/images/clock.png")));
		imageClock.setBounds(236, 29, 188, 178);
		contentPane.add(imageClock);
	}

	public void setTimeOnLabel(String time) {
		labelTime.setText(time);
	}

	public void alarm(boolean activate) {
		if (true) {
			labelAlarmNotice.setText("ALARM!!!");
		}
	}
}
