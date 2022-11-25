package ProjectCode;

public class Students implements People {				
	String ArriveTime ;			
	String roomType ;				
	String ID ;					
	String name ;					
	String gender ;					
	
	Students(String ArriveTime, String roomType, String ID, String name, String gender) {
		this.gender = gender ;
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