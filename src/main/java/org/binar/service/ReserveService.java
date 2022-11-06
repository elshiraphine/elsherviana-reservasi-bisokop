package org.binar.service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.binar.model.Reserve;
import org.binar.model.Ticket;

import java.io.FileNotFoundException;

public interface ReserveService {
    public Reserve createReserve (Reserve reserve);
    JasperPrint generateTicket(Long ticketId) throws FileNotFoundException, JRException;
}
