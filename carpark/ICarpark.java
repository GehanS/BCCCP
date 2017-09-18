package bcccp.carpark;

import bcccp.tickets.adhoc.IAdhocTicket;


public interface ICarpark {
	
	public void register(ICarparkObserver observer);
	public void deregister(ICarparkObserver observer);
	public String getName();
	public boolean isFull();
