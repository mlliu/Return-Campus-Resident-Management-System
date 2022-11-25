package ProjectCode;

public class Faculty implements People {				//æˆ¿å®¢ç±»
	String ArriveTime ;			//å…¥ä½�æ—¶é—´
	String roomType ;				//æˆ¿é—´åž‹å�·
	String ID ;					//ç”µè¯�å�·ç �
	String name ;					//å��å­—
	String gender ;					//äººæ•°
	//int roomNum ;					//æˆ¿é—´å�·	
	Faculty(String ArriveTime, String roomType, String ID, String name, String gender) {
		this.gender = gender ;
		//this.roomNum = roomNum ;
		this.ArriveTime = ArriveTime ;
		
		this.ID = ID  ;
		this.name = name  ;
		this.roomType = roomType ;
	}
	

	public String getName() {
		return this.name ;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}
	@Override
	public String getArriveTime() {
		
		return this.ArriveTime;
	}
	@Override
	public void setGender(String gender) {
		this.gender = gender;
		
	}
	@Override
	public void setArriveTime(String ArriveTime) {
		this.ArriveTime = ArriveTime;
		
	}
	@Override
	public void setID(String ID) {
		this.ID = ID;
		
	}
	@Override
	public void setName(String name) {
		this.name = name;
		
	}


	@Override
	public String getRoomType() {
		
		return this.roomType;
	}


	@Override
	public void setRoomType(String roomType) {
		this.roomType = roomType;
		
	}
}
