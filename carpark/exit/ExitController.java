package bcccp.carpark.exit;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class ExitController 
		implements ICarSensorResponder,
		           IExitController {
	
	private IGate exitGate;
	private ICarSensor insideSensor;
	private ICarSensor outsideSensor; 
	private IExitUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long exitTime;
	private String seasonTicketId = null;
	
	

	public ExitController(Carpark carpark, IGate exitGate, 
			ICarSensor is,
			ICarSensor os, 
			IExitUI ui) {
		//contructor
		this.carpark = carpark;
		this.exitGate = exitGate;
		this.is = is;
		this.os = os;
		this.ui = ui;
		
		os.registerResponder(this);
		is.registerResponder(this);
		ui.registerController(this);
		
		prevState = STATE.IDLE;
		setState(STATE.IDLE);
		//completed constructor
	}



	@Override
	public void ticketInserted(String ticketStr) {
		//generating the method 
		if(state == STATE.WAITING) {
			adhocTicket = carpark.getAdhocTicket(ticketStr);
			exitTime = System.currentTimeMillis();
			if(adhocTicket != null && adhocTicket.isPaid()){
				setState(STATE.PROCESSED);
			}
			else{
				ui.beep();
				setState(STATE.REJECTED);
			}
		}
		else if(carpark.isSeasonTicketValid(ticketStr) &&
			carpark.isSeasonTicketInUse(ticketStr)) {
			seasonTicketId = ticketStr;
			setState(STATE.PROCESSED);
		}
		else{
			ui.beep();
			setState(STATE.REJECTED);
		}
		
	}
				   else{
					   ui.beep();
				   }
			   }
//completed the method 



	@Override
	public void ticketTaken() {
		// ticketTaken method
		if (state_ == STATE.ISSUED || state_ == STATE.VALIDATED ) {
			setState(STATE.TAKEN);
		}
		
	}
	else {
			ui.beep();
			log("ticketTaken: called while in incorrrect state");
		}	
	}
//method is completed



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// carEventDetected method commences
		
		log("carEventDetected: " + detectorId + ", car Detected: " + detected );
		switch (state) {
				case BLOCKED;
				if (detectorId.equals(is.getId()) && !detected) {
					setState(prevState);
				}
				    break;
		 case IDLE;
				    log("eventDetected: IDLE");
				    if (detectorId.equals(is.getId()) && detected) {
					    log("eventDetected: setting state to WAITING");
					    setState(STATE.WAITING);
				    }
		else if(detectorId.equals(os.getId()) && detected) {
			setState(STATE.BLOCKED);
		}
				    break;
	}

	
	
}
