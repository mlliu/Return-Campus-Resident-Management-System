package ProjectCode;

public class Apartment implements Room {
	String type ;		//room type
	String state ;		//room state
	int roomNum ;		//æˆ¿å�·
	double price ;		//ä»·æ ¼
	Apartment() {}
	Apartment(String type, int roomNum, String state, double price) {
		this.type = type ;
		this.roomNum = roomNum ;
		this.state = state ;				
		this.price = price ;
	}
	public void setState(String state) {	//ä¿®æ”¹æˆ¿é—´çŠ¶æ€�
		this.state = state ;
	}
	public double getPrice() {				//è¿”å›žä»·æ ¼
		return price ;
	}
	public int getRoomNum() {				//è¿”å›žæˆ¿å�·
		return roomNum ;
	}
	public String getType() {				//è¿”å›žæˆ¿é—´ç±»åž‹
		return type ;
	}
	public String getState() {				//è¿”å›žæˆ¿é—´çŠ¶æ€�
		return state ;
	}
}
