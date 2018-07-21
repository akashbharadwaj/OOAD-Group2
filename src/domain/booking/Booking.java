package domain.booking;

public class Booking {
	private int bookingId;
	private String userId;
	private int arenaId;
	private String arenaName;
	private int slotTime;
	
	public Booking(int bookingId, String userId, int arenaId,String arenaName, int slotTime) {
		this.bookingId = bookingId;
		this.userId = userId;
		this.arenaId = arenaId;
		this.arenaName = arenaName;
		this.slotTime = slotTime;
	}
	public int getbookingId() {
		return this.bookingId;
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
