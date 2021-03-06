import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.CopyOnWriteArrayList;

// import java.*;
public class BrandSelect {
	static public JFrame Brandframe;
	Main m = new Main();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrandSelect window = new BrandSelect();
					window.Brandframe.setVisible(true);
					System.out.println("cafe Seating for study");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrandSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Brandframe = new JFrame();
		Brandframe.setBounds(0, 0, 1138, 603);
		Brandframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Brandframe.getContentPane().setLayout(null);
		ImageIcon icon = new ImageIcon("./img/brandselect.png");

		JPanel Brandpanel = new JPanel();
		Brandpanel.setBackground(new Color(139, 69, 19));
		Brandpanel.setForeground(new Color(255, 255, 255));
		Brandpanel.setBounds(0, 0, 1138, 603);
		Brandframe.getContentPane().add(Brandpanel);
		Brandpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please choose the cafe you want to go to.\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel.setBounds(233, 79, 656, 47);
		Brandpanel.add(lblNewLabel);
		
		JPanel logo = new JPanel();
		logo.setBounds(115, 174, 907, 221);
		Brandpanel.add(logo);
		logo.setLayout(null);
		
		JButton starbucks = new JButton("");
		starbucks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// ���� Ŭ�� Event
				hollys ji = new hollys();

				JFrame Choose = new JFrame();	// Choose
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
				rbtn1.setBounds(25, 11, 129, 35);
				rbtn1.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn1.setBackground(new Color(222, 184, 135));
				rbtn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(ji.forStudy()); // popup�� Ŭ���� ���� theSeat�� String���·� seatNumber �ѱ�.
					}
				});
				panel.add(rbtn1);


				JRadioButton rbtn5 = new JRadioButton("Meeting");
				rbtn5.setBounds(25, 211, 129, 35);
				rbtn5.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn5.setBackground(new Color(222, 184, 135));
				rbtn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(ji.forMeet());
					}
				});
				panel.add(rbtn5);
				
				JRadioButton rbtn2 = new JRadioButton("Taking Picture");
				rbtn2.setBounds(25, 61, 211, 35);
				rbtn2.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn2.setBackground(new Color(222, 184, 135));
				rbtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(ji.forPhoto());
					}
				});
				panel.add(rbtn2);
				
				JRadioButton rbtn4 = new JRadioButton("Web Surfing");
				rbtn4.setBounds(25, 161, 165, 35);
				rbtn4.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn4.setBackground(new Color(222, 184, 135));
				rbtn4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(ji.webSurfing());
					}
				});
				panel.add(rbtn4);
				
				JRadioButton rbtn3 = new JRadioButton("Reading books");
				rbtn3.setBounds(25, 111, 211, 35);
				rbtn3.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn3.setBackground(new Color(222, 184, 135));
				rbtn3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(ji.forRead());
					}
				});
				panel.add(rbtn3);
				
				ButtonGroup Group = new ButtonGroup();
				Group.add(rbtn1);
				Group.add(rbtn2);
				Group.add(rbtn3);
				Group.add(rbtn4);
				Group.add(rbtn5);
				
				JButton okbtn = new JButton("");	// ok_button
				okbtn.setIcon(new ImageIcon("./img/okayicon.png"));
				okbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFrame Starbucks_frame = new JFrame();
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
						sseat.setIcon(new ImageIcon("./img/sseat.jpg"));
						sseat.setBounds(31, 53, 854, 466);
						Spanel.add(sseat);

						JButton scheckbtn = new JButton("Check!");
						scheckbtn.setBackground(new Color(255, 255, 255));
						scheckbtn.setForeground(new Color(0, 128, 0));
						scheckbtn.setFont(new Font("Dialog", Font.ITALIC, 18));
						scheckbtn.setBounds(883, 373, 129, 29);
						Spanel.add(scheckbtn);

						JLabel slabel = new JLabel("");
						slabel.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uC2A4\uBC85.png"));
						slabel.setBounds(835, 142, 225, 224);
						Spanel.add(slabel);

						Choose.setVisible(false);
						Starbucks_frame.setVisible(true);
					}
				});
				okbtn.setBackground(UIManager.getColor("text"));
				okbtn.setForeground(new Color(222, 184, 135));
				okbtn.setFont(new Font("Consolas", Font.PLAIN, 18));
				okbtn.setBounds(280, 236, 47, 34);
				panel.add(okbtn);

				Choose.setVisible(true);
				Brandframe.setVisible(false);
			}
		});
		

		starbucks.setBackground(new Color(255, 255, 255));
		starbucks.setIcon(new ImageIcon("./img/sIcon.png"));
		starbucks.setBounds(0, 0, 227, 221);
		logo.add(starbucks);

		// TomnToms
		JButton tomtom = new JButton("");
		tomtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tomntoms su = new tomntoms();

				JFrame Choose = new JFrame();
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
				rbtn1.setBounds(25, 11, 129, 35);
				rbtn1.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn1.setBackground(new Color(222, 184, 135));
				rbtn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(su.forStudy());
					}
				});
				panel.add(rbtn1);
				
				JRadioButton rbtn5 = new JRadioButton("Meeting");
				rbtn5.setBounds(25, 211, 129, 35);
				rbtn5.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn5.setBackground(new Color(222, 184, 135));
				rbtn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(su.forMeet());
					}
				});
				panel.add(rbtn5);
				
				JRadioButton rbtn2 = new JRadioButton("Taking Picture");
				rbtn2.setBounds(25, 61, 211, 35);
				rbtn2.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn2.setBackground(new Color(222, 184, 135));
				rbtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(su.forPhoto());
					}
				});
				panel.add(rbtn2);
				
				JRadioButton rbtn4 = new JRadioButton("Web Surfing");
				rbtn4.setBounds(25, 161, 165, 35);
				rbtn4.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn4.setBackground(new Color(222, 184, 135));
				rbtn4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(su.webSurfing());
					}
				});
				panel.add(rbtn4);
				
				JRadioButton rbtn3 = new JRadioButton("Reading books");
				rbtn3.setBounds(25, 111, 211, 35);
				rbtn3.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn3.setBackground(new Color(222, 184, 135));
				rbtn3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(su.forRead());
					}
				});
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
						JFrame tomntoms = new JFrame();
						tomntoms.setBounds(100, 100, 1138, 621);
						tomntoms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						tomntoms.getContentPane().setLayout(null);
						
						JPanel Tpanel = new JPanel();
						Tpanel.setBackground(new Color(255, 255, 255));
						Tpanel.setBounds(0, -19, 1144, 617);
						tomntoms.getContentPane().add(Tpanel);
						Tpanel.setLayout(null);
						
						JButton tcheckbtn = new JButton("Check!");
						
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
						
						tomntoms.setVisible(true);
						Choose.setVisible(false);
					}
				});
				okbtn.setBackground(UIManager.getColor("text"));
				okbtn.setForeground(new Color(222, 184, 135));
				okbtn.setFont(new Font("Consolas", Font.PLAIN, 18));
				okbtn.setBounds(280, 236, 47, 34);
				panel.add(okbtn);
				
				
				Choose.setVisible(true);
				Brandframe.setVisible(false);
			}
		});
		
		tomtom.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uD0D0\uD0D0.jpg"));
		tomtom.setBackground(Color.WHITE);
		tomtom.setBounds(227, 0, 227, 221);
		logo.add(tomtom);

		// Twosome
		JButton twosom = new JButton("");
		twosom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tomntoms hy = new tomntoms();

				JFrame Choose = new JFrame();
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
				rbtn1.setBounds(25, 11, 129, 35);
				rbtn1.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn1.setBackground(new Color(222, 184, 135));
				rbtn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(hy.forRead());
					}
				});
				panel.add(rbtn1);
				
				JRadioButton rbtn5 = new JRadioButton("Meeting");
				rbtn5.setBounds(25, 211, 129, 35);
				rbtn5.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn5.setBackground(new Color(222, 184, 135));
				rbtn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(hy.forMeet());
					}
				});
				panel.add(rbtn5);
				
				JRadioButton rbtn2 = new JRadioButton("Taking Picture");
				rbtn2.setBounds(25, 61, 211, 35);
				rbtn2.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn2.setBackground(new Color(222, 184, 135));
				rbtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(hy.forPhoto());
					}
				});
				panel.add(rbtn2);
				
				JRadioButton rbtn4 = new JRadioButton("Web Surfing");
				rbtn4.setBounds(25, 161, 165, 35);
				rbtn4.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn4.setBackground(new Color(222, 184, 135));
				rbtn4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(hy.webSurfing());
					}
				});
				panel.add(rbtn4);
				
				JRadioButton rbtn3 = new JRadioButton("Reading books");
				rbtn3.setBounds(25, 111, 211, 35);
				rbtn3.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn3.setBackground(new Color(222, 184, 135));
				rbtn3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(hy.forRead());
					}
				});
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
						JFrame twosome = new JFrame();
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
						twosome.setVisible(true);
						Choose.setVisible(false);
					}
				});
				okbtn.setBackground(UIManager.getColor("text"));
				okbtn.setForeground(new Color(222, 184, 135));
				okbtn.setFont(new Font("Consolas", Font.PLAIN, 18));
				okbtn.setBounds(280, 236, 47, 34);
				panel.add(okbtn);
				Choose.setVisible(true);
				Brandframe.setVisible(false);
			}
		});
		
	
		twosom.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uD22C\uC378.png"));
		twosom.setBackground(Color.WHITE);
		twosom.setBounds(453, 0, 227, 221);
		logo.add(twosom);

		// HollysCoffe
		JButton hollys = new JButton("");
		hollys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hollys se = new hollys();

				JFrame Choose = new JFrame();
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
				rbtn1.setBounds(25, 11, 129, 35);
				rbtn1.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn1.setBackground(new Color(222, 184, 135));
				rbtn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(se.forStudy());
					}
				});
				panel.add(rbtn1);
				
				JRadioButton rbtn5 = new JRadioButton("Meeting");
				rbtn5.setBounds(25, 211, 129, 35);
				rbtn5.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn5.setBackground(new Color(222, 184, 135));
				rbtn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(se.forMeet());
					}
				});
				panel.add(rbtn5);
				
				JRadioButton rbtn2 = new JRadioButton("Taking Picture");
				rbtn2.setBounds(25, 61, 211, 35);
				rbtn2.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn2.setBackground(new Color(222, 184, 135));
				rbtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(se.forPhoto());
					}
				});
				panel.add(rbtn2);
				
				JRadioButton rbtn4 = new JRadioButton("Web Surfing");
				rbtn4.setBounds(25, 161, 165, 35);
				rbtn4.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn4.setBackground(new Color(222, 184, 135));
				rbtn4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(se.webSurfing());
					}
				});
				panel.add(rbtn4);
				
				JRadioButton rbtn3 = new JRadioButton("Reading books");
				rbtn3.setBounds(25, 111, 211, 35);
				rbtn3.setFont(new Font("Consolas", Font.PLAIN, 21));
				rbtn3.setBackground(new Color(222, 184, 135));
				rbtn3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						popup.setTheSeat(se.forRead());
					}
				});
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
						JFrame hollys = new JFrame();
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
						hollys.setVisible(true);
						Choose.setVisible(false);
					}
				});
				okbtn.setBackground(UIManager.getColor("text"));
				okbtn.setForeground(new Color(222, 184, 135));
				okbtn.setFont(new Font("Consolas", Font.PLAIN, 18));
				okbtn.setBounds(280, 236, 47, 34);
				panel.add(okbtn);
				Choose.setVisible(true);
				Brandframe.setVisible(false);

			}
		});
			
		hollys.setIcon(new ImageIcon("C:\\Users\\seoyo\\eclipse-workspace\\CafeSeatProgram\\img\\\uD560\uB9AC\uC2A4.png"));
		hollys.setBackground(Color.WHITE);
		hollys.setBounds(680, 0, 227, 221);
		logo.add(hollys);
		
		JLabel lblNewLabel_1 = new JLabel("@motoong");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(253, 245, 230));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(0, 513, 112, 21);
		Brandpanel.add(lblNewLabel_1);
	}
}
