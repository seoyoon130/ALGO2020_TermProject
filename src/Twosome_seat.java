import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Twosome_seat {
	private static String theSeat;	// class º¯¼ö
	public static void setTheSeat(String seat){
		theSeat = seat;
	}
	public static String getTheSEat(){
		return theSeat;
	}
	private JFrame twosome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Twosome_seat window = new Twosome_seat();
					window.twosome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Twosome_seat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		twosome = new JFrame();
		twosome.setBounds(100, 100, 1138, 621);
		twosome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		twosome.getContentPane().setLayout(null);
		
		JPanel Tpanel = new JPanel();
		Tpanel.setBackground(new Color(255, 255, 255));
		Tpanel.setBounds(0, -19, 1144, 617);
		twosome.getContentPane().add(Tpanel);
		Tpanel.setLayout(null);
		
		JButton tsbtn = new JButton("Check!");
		tsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, theSeat);
			}
		});
		tsbtn.setBackground(new Color(255, 255, 255));
		tsbtn.setForeground(new Color(0, 0, 128));
		tsbtn.setFont(new Font("Dialog", Font.ITALIC, 18));
		tsbtn.setBounds(883, 398, 129, 29);
		Tpanel.add(tsbtn);
		
		JLabel tseat = new JLabel("");
		tseat.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uD22C\uC378.png"));
		tseat.setBounds(835, 142, 225, 224);
		Tpanel.add(tseat);
		
		JLabel tslabel = new JLabel("\r\n");
		tslabel.setBounds(31, 53, 854, 466);
		Tpanel.add(tslabel);
		tslabel.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\tsseat.jpg"));
	}

}
