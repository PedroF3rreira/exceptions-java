package exceptions.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.model.exceptions.DomainExceptions;

public class Reservation {
	
	private int roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkin, Date checkout) {
		
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("Data de saida têm de ser maior que datade entrada");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public Reservation() {
		
	}
	
	public long duration() {
		
		long diff = checkout.getTime() - checkin.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		
		if(checkin.before(now)  || checkout.before(now)) {
			throw new DomainExceptions("Data datas têm de ser futuras");
		}
		
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("Date de sáida têm de ser maior que data de entrada");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	
	@Override
	public String toString() {
		return "Reservation: RoomNumber " + roomNumber + " Checkin " + sdf.format(checkin) + " Checkout " + sdf.format(checkout) + " Days: " + this.duration();
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	
}
