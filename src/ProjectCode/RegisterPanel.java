package ProjectCode;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class RegisterPanel extends JPanel implements ActionListener{
	JButton student ;		    //student button
	JButton faculty ;			//faculty button
	JButton back ;				//return to menu Button
	JTextArea roomMessage ;		//show room message
	Display display ;			//display info
	StudentFill studentfill ;	//student check in portal
	FacultyFill facultyfill ;	//faculty check in portal
	int flag = 0 ;				//mark which portal is used
	 RegisterPanel() {
		setLayout(null) ;
		setBounds(0, 0, 800, 800) ;
		setVisible(true) ;
		student = new JButton("Student") ;
		student.addActionListener(this) ;
		student.setBounds(200, 30, 150, 100);
		faculty = new JButton("Faculty") ;
		faculty.addActionListener(this) ;
		faculty.setBounds(450, 30, 150, 100) ;
		roomMessage = new JTextArea(12, 20) ;
		roomMessage.setBounds(250, 300, 300, 200) ;
		back = new JButton("Return") ;
		back.setBounds(600, 700, 100, 50) ;
		back.addActionListener(this) ;
		back.setVisible(false) ;
		add(back) ;
		add(faculty) ;
		add(student) ;
		add(roomMessage) ;
		setInformation() ;				
	}
	void setInformation() {				//show all room info
		display = new Display() ;
		display.setRoom() ;				//read room info from database
		roomMessage.append("Roomtype  Room number   price   Room state\n") ;
		for(int i=0; i<display.getRoomLength(); i++) {		
			Room roomInf = display.getRoom(i) ;
			roomMessage.append(roomInf.getType()+"    "+roomInf.getRoomNum()+"       "
					+roomInf.getPrice()+"                "+roomInf.getState()) ;
			roomMessage.append("\n") ;
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == student) {	
			student.setVisible(false) ;
			remove(student) ;
			faculty.setVisible(false) ;		            //remove button
			remove(faculty) ;
			studentfill = new StudentFill() ;	
			add(studentfill) ;							//add text box to fill information
			back.setVisible(true) ;
			flag = 1 ;
		}
		if(e.getSource() == faculty) {		
			student.setVisible(false) ;
			remove(student) ;
			faculty.setVisible(false) ;		
			remove(faculty) ;
			facultyfill = new FacultyFill() ;	
			add(facultyfill) ;						
			back.setVisible(true) ;	
			flag = 2 ;
		}
		if(e.getSource() == back) {				        //back to previous menu
			if(flag == 1) {
				studentfill.setVisible(false) ;
				remove(studentfill) ;					//remove text box
			}
			if(flag == 2) {
				facultyfill.setVisible(false) ;		//remove text box
				remove(facultyfill) ;
 			}
			student.setVisible(true) ;
			faculty.setVisible(true) ;
			add(faculty) ;					//show text box again
			add(student) ;
			back.setVisible(false) ;
 		}
	}
}
