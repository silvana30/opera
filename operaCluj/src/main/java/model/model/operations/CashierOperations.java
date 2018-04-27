package model.model.operations;

import model.Cashier;
import model.Show;
import model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class CashierOperations {


    public boolean logCashier(String username, String password) {
        boolean rez = false;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Query query = session.createQuery("SELECT cashier FROM Cashier cashier");
        List<Cashier> list = query.getResultList();
        for (Cashier a : list) {

            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                rez = true;
                break;
            } else {
                rez = false;
            }
        }

        System.out.println(list.toString());


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return rez;


    }

    public void addTickets(int showID, int number, int row) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Ticket ticket = new Ticket();
        TicketOP ti = new TicketOP();
        Show s = session.find(Show.class, showID);
        List<Ticket> tickets = ti.readTickets();

        for (Ticket t : tickets) {
            if (t.getShow().getId() == showID && t.getNumber() == number && t.getRow() == row) {
                throw new Exception("ticket sold");

            } else {
                ticket.setNumber(number);
                ticket.setRow(row);
                ticket.setSold(true);
                ticket.setShow(s);
            }


            session.save(ticket);
            s.setNrTickets(s.getNrTickets() - 1);
        }


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
