package ProjectCode;
import java.sql.*;
import javax.swing.*;

public class Change {
	Connection con ;
	Statement sql ;
	ResultSet rs ;
	Change(String ID, int newNum) {
		transfer(ID, newNum) ;
	}
	void transfer(String ID, int newNum) {		//Update check in status
		try {	Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;	}
		catch(Exception e) {}
		try {
			con = DriverManager.getConnection("jdbc:derby:data;create=false") ;
			sql = con.createStatement() ;
			rs = sql.executeQuery("SELECT * FROM bookingMessage WHERE ID='"+ID+"'") ;//Search by id
			rs.next() ;				//Jump to the next one(the search result)
			//String type = rs.getString(6) ;		//Room type		
			int befortNum = rs.getInt(2) ;		   //Original room number
			rs = sql.executeQuery("SELECT * FROM roomInf WHERE roomNum="+newNum) ;
			rs.next() ;
			String state = rs.getString(3) ;
			if( state.equals("available") ) {
				sql.executeLargeUpdate("UPDATE bookingMessage SET roomNum="+newNum+" WHERE roomNum="+befortNum) ;
				sql.executeLargeUpdate("UPDATE roomInf SET state='available' WHERE roomNum="+befortNum) ;//Update before room status
				sql.executeLargeUpdate("UPDATE roomInf SET state='reserved' WHERE roomNum="+newNum) ;	//Update new room status
				JOptionPane.showMessageDialog(new RHDPanel(), "Transfor successfully", null, JOptionPane.INFORMATION_MESSAGE);
			}
			else 
				JOptionPane.showMessageDialog(new RHDPanel(), "Failed", null, JOptionPane.INFORMATION_MESSAGE);
			con.close() ;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(new RHDPanel(), "Failed", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

