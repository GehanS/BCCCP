
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.test;
// import bcccp.carpark.entry.EntryController;
/////**

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.IGate;
import bcccp.carpark.entry.EntryController;
import bcccp.carpark.entry.IEntryController;
import bcccp.carpark.entry.IEntryUI;
import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
import java.util.List;

// *
// * @author Gehan
// */
public class entrycontroller_test {
   
public static void main ( String [] args)   {
    
    EntryController ec = new EntryController();
     ec.carEventDetected("test", true);
     ec.log("testrun");
 }
}

