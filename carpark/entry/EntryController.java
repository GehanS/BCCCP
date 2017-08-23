package bcccp.carpark.entry;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class EntryController 
		implements ICarSensorResponder,
				   ICarparkObserver,
		           IEntryController {
	
	private IGate entryGate;
	private ICarSensor outsideSensor; 
	private ICarSensor insideSensor;
	private IEntryUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long entryTime;
	private String seasonTicketId = null;
	
	

	public EntryController(Carpark carpark, IGate entryGate, 
			ICarSensor os, 
			ICarSensor is,
			IEntryUI ui) {
		//Implementing the Constructor
		this.carpark = carpark;
		this.entryGate = entryGate;
		this.outsideEntrySensor = os;
		this.insideEntrySensor = is;
		this.ui = ui;
		
		outsideEntrySensor_.registerResponder(this);
		insideEntrySensor_.registerResponder(this);
		ui.registerController(this);
		setState(STATE.IDLE);
		
		
	}



	@Override
	public void buttonPushed() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketInserted(String barcode) {
		//Method try-catch
		if (state_ == STATE>WAITING) {
			try{
				if(carpark.isSeasonTicketValid(barcode) &&
				   !carpark.isSeasonTicketInUse(barcode)){
					this.seasonTicketId = barcode;
					setState(STATE>VALIDATED);
				}
				else{
					ui.beep();
					seasonTicketId = null;
					log("ticketInserted: invalid ticket id");
				}
			}
			catch (NumberFormatException e) {
				ui.beep();
				seasonTicketId = null;
				log("ticketInserted: invalid ticket id");
			}
		}
		else {
			ui.beep();
			log("ticketInserted: called while in incorrect state");
		}
	}
		//above method is completed
		
	



	@Override
	public void ticketTaken() {
		//ticketTaken method initialised
		if (state_ == STATE.ISSUED || state_ == STATE.VALIDATED ) {
			setState(STATE.TAKEN);
		}
		else {
			ui.beep();
			log("ticketTaken: called while in incorrrect state");
		}	
	}
		//ticketTaken method is completed


	@Override
	public void notifyCarparkEvent() {
		// method for notification
		if (state_ == STATE.FULL){
			if(!carpark.isFull()) {
				setState(STATE.WAITING);
			}
		}	
	}
	// notify method is completed


	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		
	}

	
	
}
