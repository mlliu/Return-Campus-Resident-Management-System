package ProjectCode;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SystemFrame extends JFrame implements ActionListener {
	JButton bookingFunction ;			//register (book) function
	JButton arriveFunction ;			//mark as arrive function
	JButton changeFunction ;			//change function
	JButton back ;						//back button
	JPanel home ;						//home page
	RegisterPanel registerPanel ;		//student register panel
	RHDPanel rhdPanel ;		            //RHD panel
	int flag = 0 ;					    //mark which panel is used
	SystemFrame() {
		setLayout(null) ;
		setBounds(300, 100, 800, 800);
		setVisible(true) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		bookingFunction = new JButton("CheckIn [for Students & Faculty]") ;
		bookingFunction.addActionListener(this) ;
		bookingFunction.setBounds(100, 300, 250, 100);
		arriveFunction = new JButton("Management [for RHD]") ;
		arriveFunction.addActionListener(this) ;
		arriveFunction.setBounds(450, 300, 250, 100);
		back = new JButton("Return") ;
		back.setBounds(100, 700, 100, 50) ;
		back.addActionListener(this) ;
		back.setVisible(false) ;
		home = new JPanel() ;
		home.setLayout(null) ;
		home.setBounds(0, 0, 800, 800) ;
		home.add(bookingFunction) ;
		home.add(arriveFunction) ;
		add(back) ;
		add(home) ;		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bookingFunction) {		//click to enter the function
			registerPanel = new RegisterPanel() ;
			home.setVisible(false) ;
			remove(home) ;
			add(registerPanel) ;
			back.setVisible(true) ;
			flag = 1 ;
		}
		if(e.getSource() == arriveFunction) {		//click to enter the function
			rhdPanel = new RHDPanel() ;
			home.setVisible(false) ;
			remove(home) ;
			add(rhdPanel) ;
			back.setVisible(true) ;
			flag = 2 ;
		}
		if(e.getSource() == back) {				//back to previous page
			if(flag == 1) {
				registerPanel.setVisible(false) ;
				remove(registerPanel) ;				//remove text box
			}
			if(flag == 2) {
				rhdPanel.setVisible(false) ;		//remove RHD panel
				remove(rhdPanel) ;
 			}
			home.setVisible(true) ;
			add(home) ;							//show buttons again
			back.setVisible(false) ;
 		}
	}
}

