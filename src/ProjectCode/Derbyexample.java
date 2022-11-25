package ProjectCode;
import java.sql.*;

public class Derbyexample {
	public static void main(String[] args) throws Exception {
		String jdbcURL = "jdbc:derby:data;create=false";
		
			Connection connection =DriverManager.getConnection(jdbcURL);
			System.out.println("create successfully");
			
			String sqlcreat1 = "Create Table roomInf(roomType varchar(10), roomNum int, state varchar(10),price double)";
			String sqladd1 = "Insert into roomInf(roomType, roomNum, state, price) values ('Plum', 101, 'available',100.00)";
			
			String sqladd2 = "Insert into roomInf(roomType, roomNum, state, price) values ('Orchid', 102, 'reserved',100.00)";
			String sqladd3 = "Insert into roomInf(roomType, roomNum, state, price) values ('Bamboo', 103, 'available',100.00)";
			String sqladd4 = "Insert into roomInf(roomType, roomNum, state, price) values ('Banyan', 104, 'available',100.00)";
			String sqladd5 = "Insert into roomInf(roomType, roomNum, state, price) values ('Maple', 105, 'available',100.00)";
			//String sqladd6 = "Insert into roomInf(roomType, roomNum, state, price) values ('Banyan', 104, 'available',100.00)";
			//String sql = "Create Table bookingMessage(name char(10), roomNum int, cover int,phone char(10),checkInTime char(10),leaveTime char(10),type char(10))";
			//String sql = "Insert into bookingMessage ";
			//String sql = "Drop Table bookingMessage";
			//String sql = "Drop Table roomInf";
			String sqlcreat2 = "Create Table bookingMessage(name varchar(15), roomNum int, gender varchar(10),ID varchar(10),ArriveTime varchar(15), roomType varchar(10))";
					
			String sqladd6 = "INSERT INTO bookingMessage  (name, roomNum,gender,ID,ArriveTime,roomType) VALUES ('Meili', 100,'famale','123456','12.03','lan')";
			Statement statement = connection.createStatement();
			statement.execute(sqlcreat1);
			statement.execute(sqlcreat2);
			statement.executeUpdate(sqladd1);
			statement.executeUpdate(sqladd2);
			statement.executeUpdate(sqladd3);
			statement.executeUpdate(sqladd4);
			statement.executeUpdate(sqladd5);
			statement.executeUpdate(sqladd6);
			/**
			
			String sqldelete1 = "Drop Table roomInf";
			String sqldelete2 = "Drop Table bookingMessage";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sqldelete1);
			statement.executeUpdate(sqldelete2); **/
			
	}
}
