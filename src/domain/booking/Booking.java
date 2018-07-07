package domain.booking;

public class Booking {
	private String userId;
	private int arenaId;
	private String arenaName;
	private int slotTime;
	
	public Booking(String userId, int arenaId,String arenaName, int slotTime) {
		this.userId = userId;
		this.arenaId = arenaId;
		this.arenaName = arenaName;
		this.slotTime = slotTime;
	}
	
	public String getuserId() {
		return this.userId;
	}
	public int getarenaId() {
		return this.arenaId;
	}
	public int getslotTime() {
		return this.slotTime;
	}
	public String getarenaName() {
		return this.arenaName;
	}
}
