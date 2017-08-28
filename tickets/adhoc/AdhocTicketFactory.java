package bcccp.tickets.adhoc;

public class AdhocTicketFactory implements IAdhocTicketFactory {

	@Override
	public IAdhocTicket make(String carparkId, int ticketNo) {
		AdhocTicket adhocTicket= new AdhocTicket(carparkId,ticketNo," ");
            
		return adhocTicket;
	}


}
