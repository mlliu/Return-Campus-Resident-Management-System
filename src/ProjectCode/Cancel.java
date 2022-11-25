package ProjectCode;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Cancel {
	Connection con ;
	Statement sql ;
	ResultSet rs ;
	Cancel(String phone) {
		del(phone) ;
	}
	void del(String ID) {		//cancel application
		try {	Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;	}
		catch(Exception e) {}
		try {
			con = DriverManager.getConnection("jdbc:derby:data;create=false") ;
			sql = con.createStatement() ;
			rs = sql.executeQuery("SELECT * FROM bookingMessage WHERE ID='"+ID+"'") ;   //search by id
			rs.next() ;							//Jump to the next one, which is the search result
			int flag = JOptionPane.showConfirmDialog(new RHDPanel(), "Do you want to delete itï¼Ÿ", null, JOptionPane.YES_NO_CANCEL_OPTION) ;
			if(flag == JOptionPane.YES_OPTION) {
				int roomNum = rs.getInt(2) ;		//Get room number
				sql.executeLargeUpdate("DELETE FROM bookingMessage WHERE ID='"+ID+"'") ;	
				sql.executeLargeUpdate("UPDATE roomInf SET state='available' WHERE roomNum="+roomNum) ;	//update room status
				JOptionPane.showMessageDialog(new RHDPanel(), "Delete success", null, JOptionPane.INFORMATION_MESSAGE);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.print(e) ;
			JOptionPane.showMessageDialog(new RHDPanel(), "Delete failed", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
