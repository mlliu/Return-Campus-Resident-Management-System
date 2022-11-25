package ProjectCode;


import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class OrderPanel extends JPanel implements ActionListener{			//Record application info
	JTextField name, gender, ID, ArriveTime, roomType ;	
	JButton button ;					//submit button
	Box baseBox, box1, box2 ;
	Connection con ;
	Statement sql ;
	ResultSet rs ;
	OrderPanel() {
		box1 = Box.createVerticalBox() ;			//Left side Labels
		box1.add(new JLabel("Name")) ;
		box1.add(Box.createVerticalStrut(10)) ;
		box1.add(new JLabel("Gender")) ;
		box1.add(Box.createVerticalStrut(10)) ;
		box1.add(new JLabel("ID")) ;
		box1.add(Box.createVerticalStrut(10)) ;
		box1.add(new JLabel("Arrive time")) ;
		box1.add(Box.createVerticalStrut(10)) ;
		//box1.add(new JLabel("离开时间")) ;
		//box1.add(Box.createVerticalStrut(20)) ;
		box1.add(new JLabel("room type")) ;
		box2 = Box.createVerticalBox() ;			//Right side input box
		box2.add(Box.createVerticalStrut(20)) ;
		box2.add(name = new JTextField(30)) ;
		box2.add(Box.createVerticalStrut(10)) ;
		box2.add(gender = new JTextField(30)) ;
		box2.add(Box.createVerticalStrut(10)) ;
		box2.add(ID = new JTextField(30)) ;
		box2.add(Box.createVerticalStrut(10)) ;
		box2.add(ArriveTime = new JTextField(30)) ;
		//box2.add(Box.createVerticalStrut(10)) ;
		//box2.add(leaveTime = new JTextField(30)) ;
		box2.add(Box.createVerticalStrut(10)) ;
		box2.add(roomType = new JTextField(30)) ;
		box2.add(Box.createVerticalStrut(10)) ;
		baseBox = Box.createHorizontalBox() ;
		baseBox.add(box1) ;
		baseBox.add(Box.createHorizontalStrut(10)) ;
		baseBox.add(box2) ;
		button = new JButton("Confirm") ;
		button.addActionListener(this) ;
		add(baseBox) ;
		add(button) ;
		setBounds(0, 30, 800, 300) ;
		setVisible(true) ;
	}
	public void actionPerformed(ActionEvent e) {}
}

