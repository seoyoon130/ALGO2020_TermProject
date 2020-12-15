import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hollys_seat {
	private static String theSeat;	// class º¯¼ö
	public static void setTheSeat(String seat){
		theSeat = seat;
	}
	public static String getTheSEat(){
		return theSeat;
	}
	private JFrame hollys;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hollys_seat window = new Hollys_seat();
					window.hollys.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hollys_seat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		hollys = new JFrame();
		hollys.setBounds(100, 100, 1138, 621);
		hollys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hollys.getContentPane().setLayout(null);
		
		JPanel Hpanel = new JPanel();
		Hpanel.setBackground(new Color(255, 255, 255));
		Hpanel.setBounds(0, 0, 1144, 584);
		hollys.getContentPane().add(Hpanel);
		Hpanel.setLayout(null);
		
		JButton checkbtn = new JButton("Check!");
		checkbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, theSeat);

			}
		});
		checkbtn.setBackground(new Color(255, 255, 255));
		checkbtn.setForeground(new Color(178, 34, 34));
		checkbtn.setFont(new Font("Dialog", Font.ITALIC, 18));
		checkbtn.setBounds(883, 398, 129, 29);
		Hpanel.add(checkbtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\hseat.jpg"));
		lblNewLabel_1.setBounds(55, 39, 811, 466);
		Hpanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uD560\uB9AC\uC2A4.png"));
		lblNewLabel.setBounds(835, 142, 225, 224);
		Hpanel.add(lblNewLabel);
	}

}
