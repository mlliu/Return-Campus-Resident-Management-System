package ProjectCode;



public class Doom implements Room {		
	String type ;		
	String state ;		
	int roomNum ;		
	double price ;		
	Doom() {}
	Doom(String type, int roomNum, String state, double price) {
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