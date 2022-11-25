package ProjectCode;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class Display {			//Show room & user information
	ArrayList<People> customers ;		
	ArrayList<Room> rooms ;
	public void setCustomer() {		//Retrieve user's information from database
		customers = new ArrayList<People>() ;
		try {	Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;	}
		catch(Exception ee) {}
		try {
			Connection con = DriverManager.getConnection("jdbc:derby:data;create=false") ;
			Statement sql = con.createStatement() ;
			ResultSet rs = sql.executeQuery("SELECT * FROM bookingMessage ") ;
			while(rs.next()) {
				String name = rs.getString(1) ;
				int roomNum = rs.getInt(2) ;
				String gender = rs.getString(3) ;
				String ID = rs.getString(4) ;
				String ArriveTime = rs.getString(5) ;
				//String leaveTime = rs.getString(6) ;
				String type = rs.getString(6) ;
				People c = new Students(ArriveTime, type, ID, name, gender) ;
				
				customers.add(c) ;
			}
			con.close() ;
		}
		catch(Exception ee) {}
	}
	void setRoom() {			//Retrieve room information from database
		rooms = new ArrayList<Room>() ;	
		try {	Class.forName("org.apache.derby.jdbc.EmbeddedDriver") ;	}
		catch(Exception ee) {}
		try {
			Connection con = DriverManager.getConnection("jdbc:derby:data;create=false") ;
			Statement sql = con.createStatement() ;
			ResultSet rs = sql.executeQuery("SELECT * FROM roomInf ") ;
			while(rs.next()) {
				String roomType = rs.getString(1) ;
				int roomNum = rs.getInt(2) ;
				String state = rs.getString(3) ;
				double price = rs.getDouble(4) ;
				Room r = new Doom(roomType, roomNum, state, price) ;
				rooms.add(r) ;
			}
			con.close() ;
		}
		catch(Exception ee) {}
	}
	int getRoomLength() {				//Get room amount
		return rooms.size() ;
	}
	int getCustomerLength() {			//Get user amount
		return customers.size() ;
	}
	Room getRoom(int i) {				//Get room info
		return rooms.get(i) ;
	}
	People getCustomer(int i) {		    //Get user info
		return customers.get(i) ;
	}
}

