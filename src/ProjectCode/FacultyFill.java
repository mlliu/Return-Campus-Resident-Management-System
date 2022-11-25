package ProjectCode;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class FacultyFill extends OrderPanel implements ActionListener{		//Record faculty's check in
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			try {	Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;	}
			catch(Exception ee) {}
			try {
				Connection con = DriverManager.getConnection("jdbc:derby:data;create=false") ;
				Statement sql = con.createStatement() ;
				ResultSet rs = sql.executeQuery("SELECT * FROM roomInf WHERE type='"+roomType.getText()+"'") ;//é¦–å…ˆä»Žæˆ¿é—´ä¿¡æ�¯è¡¨ä¸­æ‰¾ç¬¦å�ˆæ�¡ä»¶çš„æˆ¿é—´
				boolean flag = true ;			//Record operation successful or not
				while(rs.next()) {
					String type = rs.getString(1) ;
					int number = rs.getInt(2) ;
					String state = rs.getString(3) ;
					if(state.equals("available")) {	//Approve check in if the selected room is available
						sql.executeLargeUpdate("UPDATE roomInf SET state='reserved' WHERE roomNum="+number) ;		//æ›´æ–°æˆ¿é—´çŠ¶æ€�
						sql.executeUpdate("INSERT INTO bookingMessage VALUES ('"+name.getText()+
								"', "+number+", "+gender.getText()+", '"+ID.getText()+"', '"+
								ArriveTime.getText()+"', '"+
								type+"')") ;				//Add check in information to database
						JOptionPane.showMessageDialog(this, "success"+number+" ",null, JOptionPane.INFORMATION_MESSAGE);
						flag = false ;
						break ;
					}
				}
				if(flag) 
					JOptionPane.showMessageDialog(this, "fail",null, JOptionPane.INFORMATION_MESSAGE);
				con.close() ;
			}
			catch(Exception ee) {}
		}
	}
}
