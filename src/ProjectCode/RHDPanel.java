package ProjectCode;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class RHDPanel extends JPanel implements ActionListener{
	JLabel label ;
	JTextField ID ;
	JButton arrive ;				//Record user's arrival
	JButton cancel ;				//Reject application
	JButton transfer ;				//Transfer to Quarantine area
	JTextArea customerMessage ;		///Show user message area
	JTextArea roomMessage ;			//Show room message area
	Display display ;				
	public RHDPanel() {
		setLayout(null) ;
		setBounds(0, 0, 800, 800) ;
		setVisible(true) ;
		label = new JLabel("Please enter your ID") ;
		label.setBounds(100, 60, 100, 50) ;
		ID = new JTextField(30) ;
		ID.setBounds(210, 70, 400, 30) ;
		arrive = new JButton("Approve") ;
		arrive.setBounds(200, 120, 100, 45) ;
		arrive.addActionListener(this) ;
		cancel = new JButton("Reject") ;
		cancel.setBounds(350, 120, 100, 45) ;
		cancel.addActionListener(this) ;
		transfer = new JButton("Modify") ;
		transfer.setBounds(500, 120, 100, 45) ;
		transfer.addActionListener(this) ;
		customerMessage  = new JTextArea(12, 20) ;
		customerMessage.setBounds(150, 200, 500, 200) ;
		roomMessage = new JTextArea(12, 20) ;
		roomMessage.setBounds(150, 450, 500, 200) ;
		add(label) ;
		add(ID) ;
		add(arrive) ;
		add(cancel) ;
		add(transfer) ;
		add(customerMessage) ;
		add(roomMessage) ;
		setCustomerInf() ;	
		setRoomInf() ;
	}
	void setCustomerInf() {				//Show all applications
		display = new Display() ;
		display.setCustomer() ;				//Read information from database
		customerMessage.append("Name        Room type         Gender        ID          Arrive time \n") ;
		for(int i=0; i<display.getCustomerLength(); i++) {		
			People customerInf = display.getCustomer(i) ;
			customerMessage.append(customerInf.getName()+"       "+customerInf.getRoomType()+"        "
					+customerInf.getGender()+"               "+customerInf.getID()+"               "
					+customerInf.getArriveTime());//+"           ";
					//+customerInf.getLeaveTime()) ;
			customerMessage.append("\n") ;
		}
	}
	void setRoomInf() {				//Show all room information
		display = new Display() ;
		display.setRoom() ;				//Read information from database
		roomMessage.append(" Roomtype  Room number   price   Room state\n") ;
		for(int i=0; i<display.getRoomLength(); i++) {		
			Room roomInf = display.getRoom(i) ;
			roomMessage.append(roomInf.getType()+"    "+roomInf.getRoomNum()+"       "
					+"                "+roomInf.getState()) ;
			roomMessage.append("\n") ;
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == arrive) {			//Mark as arrive
			SignIn signIn = new SignIn(ID.getText()) ;
			customerMessage.setText("");		//Update information¯
			roomMessage.setText("") ;
			setCustomerInf() ;
			setRoomInf() ;
		}
		if(e.getSource() == cancel) {			//Cancel application
			Cancel cancel = new Cancel(ID.getText()) ; 
			customerMessage.setText("");		//Update information
			roomMessage.setText("") ;
			setCustomerInf() ;
			setRoomInf() ;
		}
		if(e.getSource() == transfer) {			//Transfer to quarantine area
			int newRoom = Integer.parseInt(JOptionPane.showInputDialog(this,
					"Please enter the modified room number ", null, JOptionPane.INFORMATION_MESSAGE)) ;
			Change change = new Change(ID.getText(), newRoom) ;
			customerMessage.setText("");		//Update information
			roomMessage.setText("") ;
			setCustomerInf() ;
			setRoomInf() ;
		}
	}
}

