import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Choice;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Choose {

	private JFrame Choose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choose window = new Choose();
					window.Choose.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Choose() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Choose = new JFrame();
		Choose.setBounds(100, 100, 346, 440);
		Choose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Choose.setResizable(false);
		Choose.getContentPane().setLayout(null);
		JPanel Purpose = new JPanel();
		Purpose.setBounds(0, 0, 344, 427);
		Purpose.setBackground(new Color(222, 184, 135));
		Choose.getContentPane().add(Purpose);
		Purpose.setLayout(null);
		
		JLabel purposelabell = new JLabel("What's Your Purpose?\r\n");
		purposelabell.setFont(new Font("DialogInput", Font.BOLD, 23));
		purposelabell.setBounds(31, 24, 282, 59);
		Purpose.add(purposelabell);
		
		JLabel warnlabel = new JLabel("*Choose only 1");
		warnlabel.setForeground(new Color(220, 20, 60));
		warnlabel.setFont(new Font("DialogInput", Font.BOLD, 17));
		warnlabel.setBounds(191, 98, 151, 21);
		Purpose.add(warnlabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 132, 344, 297);
		Purpose.add(panel);
		panel.setLayout(null);
		
		JRadioButton rbtn1 = new JRadioButton("Studying");
			rbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Studying")) {
					
				}
			}
		});
		
		rbtn1.setBounds(25, 11, 129, 35);
		rbtn1.setFont(new Font("Consolas", Font.PLAIN, 21));
		rbtn1.setBackground(new Color(222, 184, 135));
		panel.add(rbtn1);
		
		JRadioButton rbtn5 = new JRadioButton("Meeting");
		rbtn5.setBounds(25, 211, 129, 35);
		rbtn5.setFont(new Font("Consolas", Font.PLAIN, 21));
		rbtn5.setBackground(new Color(222, 184, 135));
		panel.add(rbtn5);
		
		JRadioButton rbtn2 = new JRadioButton("Taking Picture");
		rbtn2.setBounds(25, 61, 211, 35);
		rbtn2.setFont(new Font("Consolas", Font.PLAIN, 21));
		rbtn2.setBackground(new Color(222, 184, 135));
		panel.add(rbtn2);
		
		JRadioButton rbtn4 = new JRadioButton("Web Surfing");
		rbtn4.setBounds(25, 161, 165, 35);
		rbtn4.setFont(new Font("Consolas", Font.PLAIN, 21));
		rbtn4.setBackground(new Color(222, 184, 135));
		panel.add(rbtn4);
		
		JRadioButton rbtn3 = new JRadioButton("Reading books");
		rbtn3.setBounds(25, 111, 211, 35);
		rbtn3.setFont(new Font("Consolas", Font.PLAIN, 21));
		rbtn3.setBackground(new Color(222, 184, 135));
		panel.add(rbtn3);
		
		ButtonGroup Group = new ButtonGroup();
		Group.add(rbtn1);
		Group.add(rbtn2);
		Group.add(rbtn3);
		Group.add(rbtn4);
		Group.add(rbtn5);
		
		JButton okbtn = new JButton("");
		okbtn.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\okayicon.png"));
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		okbtn.setBackground(UIManager.getColor("text"));
		okbtn.setForeground(new Color(222, 184, 135));
		okbtn.setFont(new Font("Consolas", Font.PLAIN, 18));
		okbtn.setBounds(280, 236, 47, 34);
		panel.add(okbtn);

		
	}
}
