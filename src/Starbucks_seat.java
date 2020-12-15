import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Starbucks_seat {
	private static String theSeat;	// class 변수
	public static void setTheSeat(String seat){
		theSeat = seat;
	}
	public static String getTheSEat(){
		return theSeat;
	}

	private JFrame Starbucks_frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Starbucks_seat window = new Starbucks_seat();
					window.Starbucks_frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Starbucks_seat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Starbucks_frame = new JFrame();
		Starbucks_frame.setBounds(100, 100, 1138, 621);
		Starbucks_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Starbucks_frame.getContentPane().setLayout(null);
		
		JPanel Spanel = new JPanel();
		Spanel.setBackground(new Color(255, 255, 255));
		Spanel.setBounds(0, 0, 1144, 584);
		Starbucks_frame.getContentPane().add(Spanel);
		Spanel.setLayout(null);
		
		JLabel sseat = new JLabel("");
		sseat.setBackground(new Color(255, 192, 203));
		sseat.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\sseat.jpg"));
		sseat.setBounds(31, 53, 854, 466);
		Spanel.add(sseat);
		
		JButton scheckbtn = new JButton("Check!");
		scheckbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(popup.gettheSeat());
			}
		});
		scheckbtn.setBackground(new Color(255, 255, 255));
		scheckbtn.setForeground(new Color(0, 128, 0));
		scheckbtn.setFont(new Font("Dialog", Font.ITALIC, 18));
		scheckbtn.setBounds(883, 373, 129, 29);
		Spanel.add(scheckbtn);
		
		JLabel slabel = new JLabel("");
		slabel.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uC2A4\uBC85.png"));
		slabel.setBounds(835, 142, 225, 224);
		Spanel.add(slabel);
		
	}
}
