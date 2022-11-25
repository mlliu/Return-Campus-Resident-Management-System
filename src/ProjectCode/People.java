package ProjectCode;

public interface People {
	String getGender();
	//int getRoomNum();
	String getName() ;
	String getID() ;
	String getArriveTime() ;
	String getRoomType();
	
	void setGender(String gender) ;
	//void setRoomNum(int roomNum);
	void setArriveTime(String ArriveTime);
	void setID(String phone) ;
	void setName(String name) ;
	void setRoomType(String roomType);
}
