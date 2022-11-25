package ProjectCode;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentFill extends OrderPanel implements ActionListener{		//record student application
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			try {	Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;	}
			catch(Exception ee) {}
			try {
				Connection con = DriverManager.getConnection("jdbc:derby:data;create=false") ;
				Statement sql = con.createStatement() ;
				//System.out.println("room type is: "+roomType.getText());
				ResultSet rs = sql.executeQuery("SELECT * FROM roomInf WHERE roomType='"+roomType.getText()+"'") ;//search by room type
				//System.out.println("room type is: "+roomType.getText());
				
				boolean flag = true ;			//mark as success
				while(rs.next()) {
					String type = rs.getString(1) ;
					int number = rs.getInt(2) ;
					String state = rs.getString(3) ;
				
					if(state.equals("available")) {				//check the target room is available or not											
						
						sql.executeLargeUpdate("UPDATE roomInf SET state='reserved' WHERE roomNum="+number) ;		//update room status
						
					
						sql.executeUpdate("INSERT INTO bookingMessage VALUES ('"+name.getText()+
								"', "+number+", '"+gender.getText()+"', '"+ID.getText()+"', '"+
								ArriveTime.getText()+"', '"+
								type+"')") ;				//store in database
						
						System.out.println("enter2");
						
						JOptionPane.showMessageDialog(this, "Success! Your room number is: "+number+" ",null, JOptionPane.INFORMATION_MESSAGE);
						flag = false ;
						break ;
					}
				}
				if(flag) 
					JOptionPane.showMessageDialog(this, "Fail!",null, JOptionPane.INFORMATION_MESSAGE);
				con.close() ;
			}
			catch(Exception ee) {}
		}
	}
}
