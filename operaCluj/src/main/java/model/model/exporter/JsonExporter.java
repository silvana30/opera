package model.model.exporter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Ticket;
import model.model.exporter.Exporter;
import model.model.operations.TicketOP;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class JsonExporter implements Exporter {

    public void exportTicket(int ID) {
        TicketOP op = new TicketOP();
        List<Ticket> ticket = op.getTicketsForShow(ID);


        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("D:\\proiecte_java\\operaCluj\\ticket.json"), ticket.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
