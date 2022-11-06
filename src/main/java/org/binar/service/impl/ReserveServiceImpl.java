package org.binar.service.impl;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.model.Reserve;
import org.binar.model.Ticket;
import org.binar.repository.ReserveRepository;
import org.binar.service.ReserveService;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReserveServiceImpl implements ReserveService {
    private ReserveRepository reserveRepository;

    public ReserveServiceImpl(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    @Override
    public Reserve createReserve (Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    @Override
    public JasperPrint generateTicket(Long ticketId) throws FileNotFoundException, JRException {
        Reserve reserve = reserveRepository.findById(ticketId).orElseThrow();
        Map<String, Object> dataMap = dataParameter(reserve);
        List<Reserve> reserveCollect = new LinkedList<>();
        dataMap.put("userData", new JRBeanCollectionDataSource(reserveCollect));
        return JasperFillManager.fillReport(
                JasperCompileManager.compileReport(
                        ResourceUtils.getFile("ticket.jrxml").getAbsolutePath()
                ), dataMap, new JREmptyDataSource()
        );
    }

    public Map<String, Object> dataParameter(Reserve reserve) {
        String ticket = String.format(reserve.getTickets().toString());
        String username = String.format(reserve.getUsers().getUser_name().toString());

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", username);
        dataMap.put("ticket", ticket);
        return dataMap;
    }
}
