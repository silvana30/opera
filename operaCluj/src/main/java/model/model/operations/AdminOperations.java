package model.model.operations;

import model.Admin;
import model.Cashier;
import model.Show;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AdminOperations {


    public AdminOperations() {
    }

    public List<Cashier> readCashier() {

        List<Cashier> list;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();


        list = session.createSQLQuery("SELECT * FROM cashier_table").addEntity(Cashier.class).list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list;
    }

    public void createCashier(String name, String username, String password) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Cashier cashier = new Cashier();
        cashier.setName(name);
        cashier.setUsername(username);
        cashier.setPassword(password);

        session.save(cashier);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void createAdmin(String username, String password) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Admin admin = new Admin();

        admin.setUsername(username);
        admin.setPassword(password);

        session.save(admin);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void createShow(String date, String distribution, String genre, int nrTickets, String title) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date datee = null;
        try {
            datee = sdf1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlStartDate = new java.sql.Date(datee.getTime());

        Show show = new Show();
        show.setDate(sqlStartDate);
        show.setDistribution(distribution);
        show.setGenre(genre);
        show.setNrTickets(nrTickets);
        show.setTitle(title);

        session.save(show);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void updateShow(int id, String date, String distribution, String genre, int nrTickets, String title) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date datee = null;
        try {
            datee = sdf1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlStartDate = new java.sql.Date(datee.getTime());

        Show show = session.find(Show.class, id);
        show.setDate(sqlStartDate);
        show.setDistribution(distribution);
        show.setGenre(genre);
        show.setNrTickets(nrTickets);
        show.setTitle(title);

        session.update(show);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void deleteShow(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Show show = session.find(Show.class, id);
        session.delete(show);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public boolean logAdmin(String username, String password) {
        boolean rez = false;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();


        Query query = session.createQuery("SELECT admin FROM Admin admin");
        List<Admin> list = query.getResultList();
        for (Admin a : list) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                rez = true;
                break;
            } else {
                rez = false;
            }
        }


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return rez;


    }

}
