import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class popup extends JDialog {

	private static String theSeat;	// class 변수
	public static void setTheSeat(String seat){
		theSeat = seat;
	}
	public static String gettheSeat(){
		return theSeat;
	}


	private final JPanel Result = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			popup dialog = new popup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public popup() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		Result.setBackground(SystemColor.info);
		Result.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(Result, BorderLayout.CENTER);
		Result.setLayout(null);

		JLabel rlabel1 = new JLabel("The Best Choice\r\n");
		rlabel1.setFont(new Font("Courier New", Font.BOLD, 25));
		rlabel1.setBounds(99, 36, 230, 21);
		Result.add(rlabel1);

		JLabel rlable2 = new JLabel("is\r\n");
		rlable2.setHorizontalAlignment(SwingConstants.CENTER);
		rlable2.setFont(new Font("Courier New", Font.BOLD, 25));
		rlable2.setBounds(99, 80, 230, 21);
		Result.add(rlable2);
		System.out.println(theSeat);
		JLabel result = new JLabel(theSeat);
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setFont(new Font("Courier New", Font.BOLD, 25));
		result.setBounds(99, 129, 230, 21);
		Result.add(result);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(250, 235, 215));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
	}
	
}
