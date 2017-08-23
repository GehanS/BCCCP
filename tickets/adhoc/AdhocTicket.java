package bcccp.tickets.adhoc;

import java.util.Date;

public class AdhocTicket implements IAdhocTicket {
	
	private String carparkId;
	private int ticketNo;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;

	
	
	public AdhocTicket(String carparkId, int ticketNo, String barcode) {
		//TDO Implement constructor
		this.carparkId = carparkId;
            	this.ticketNo = ticketNo;
            	this.barcode= barcode;
	}


	@Override
	public int getTicketNo() {
		// TODO Auto-generated method stub
		return ticketNo;
	}


	@Override
	public String getBarcode() {
		// TODO Auto-generated method stub
		return barcode;
	}


	@Override
	public String getCarparkId() {
		// TODO Auto-generated method stub
		return carparkId;
	}


	@Override
	public void enter(long dateTime) {
		// TODO Auto-generated method stub
		this.entryDateTime= dateTime
		
	}


	@Override
	public long getEntryDateTime() {
		// TODO Auto-generated method stub
		return return entryDateTime;;
	}


	@Override
	public boolean isCurrent() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void pay(long dateTime, float charge) {
		// TODO Auto-generated method stub
		this.paidDateTime=dateTime;
            	this.charge= charge;
		
	}


	@Override
	public long getPaidDateTime() {
		// TODO Auto-generated method stub
		return paidDateTime;;
	}


	@Override
	public boolean isPaid() {
		// TODO Auto-generated method stub
		if(paidDateTime==0)
		return false;
            else
                return true;
	}


	@Override
	public float getCharge() {
		// TODO Auto-generated method stub
		return charge;
	}


	@Override
	public void exit(long dateTime) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public long getExitDateTime() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean hasExited() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
