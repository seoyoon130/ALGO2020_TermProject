import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TomnToms_seat {
	private static String theSeat;	// class º¯¼ö
	public static void setTheSeat(String seat){
		theSeat = seat;
	}
	public static String getTheSEat(){
		return theSeat;
	}
	private JFrame tomntoms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TomnToms_seat window = new TomnToms_seat();
					window.tomntoms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TomnToms_seat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tomntoms = new JFrame();
		tomntoms.setBounds(100, 100, 1138, 621);
		tomntoms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tomntoms.getContentPane().setLayout(null);
		
		JPanel Tpanel = new JPanel();
		Tpanel.setBackground(new Color(255, 255, 255));
		Tpanel.setBounds(0, -19, 1144, 617);
		tomntoms.getContentPane().add(Tpanel);
		Tpanel.setLayout(null);
		
		JButton tcheckbtn = new JButton("Check!");
		tcheckbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, popup.gettheSeat());

			}
		});
		tcheckbtn.setBackground(new Color(255, 255, 255));
		tcheckbtn.setForeground(new Color(139, 69, 19));
		tcheckbtn.setFont(new Font("Dialog", Font.ITALIC, 18));
		tcheckbtn.setBounds(883, 398, 129, 29);
		Tpanel.add(tcheckbtn);
		
		JLabel tLabel = new JLabel("");
		tLabel.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uD0D0\uD0D0.jpg"));
		tLabel.setBounds(835, 142, 225, 224);
		Tpanel.add(tLabel);
		
		JLabel ttlabel = new JLabel("\r\n");
		ttlabel.setHorizontalAlignment(SwingConstants.CENTER);
		ttlabel.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\ttseat.jpg"));
		ttlabel.setBounds(31, 53, 854, 466);
		Tpanel.add(ttlabel);
	}
}
