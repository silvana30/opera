package model.model.operations;

import model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class TicketOP {
    public Ticket findTicket(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Ticket ticket = session.find(Ticket.class, id);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return ticket;
    }

    public List<Ticket> readTickets() {

        List<Ticket> list;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        list = session.createSQLQuery("SELECT * FROM ticket_table").addEntity(Ticket.class).list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list;
    }

    public List<Ticket> getTicketsForShow(int idShow) {

        List<Ticket> list;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();


        Query query = session.createQuery("SELECT ticket FROM Ticket ticket WHERE ticket.show.id =:show");
        query.setParameter("show", idShow);
        list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list;
    }
}
