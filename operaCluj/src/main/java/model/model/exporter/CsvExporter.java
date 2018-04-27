package model.model.exporter;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Ticket;
import model.model.exporter.Exporter;
import model.model.operations.TicketOP;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvExporter implements Exporter {


    public void exportTicket(int id) {
        TicketOP op = new TicketOP();
        List<Ticket> ticket = op.getTicketsForShow(id);

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("D:\\proiecte_java\\operaCluj\\ticket.csv"), ticket.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
