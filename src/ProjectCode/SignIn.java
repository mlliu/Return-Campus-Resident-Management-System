package ProjectCode;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SignIn {
	Connection con ;
	Statement sql ;
	ResultSet rs ;
	SignIn(String phone) {
		sign(phone) ;
	}
	void sign(String ID) {		//update status
		try {	Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;	}
		catch(Exception e) {}
		try {
			con = DriverManager.getConnection("jdbc:derby:data;create=false") ;
			sql = con.createStatement() ;
			
			//System.out.print("Id is : "+ID);
			rs = sql.executeQuery("SELECT * FROM bookingMessage WHERE ID='"+ID+"'") ;//search by id
			//System.out.print("Id is : "+ID);
			
			rs.next() ;				//jump to next, which is the search result
			//System.out.print("enter0");
			
			int roomNum = rs.getInt(2) ;		//get room number
			//System.out.print("enter1");
			sql.executeLargeUpdate("UPDATE roomInf SET state='arrived' WHERE roomNum="+roomNum) ;	//update room status
			
			//System.out.print("enter2");
			
			JOptionPane.showMessageDialog(new RHDPanel(), "Arrive success", null, JOptionPane.INFORMATION_MESSAGE);
			con.close() ;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(new RHDPanel(), "Arrive Fail", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
