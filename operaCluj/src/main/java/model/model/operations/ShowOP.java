package model.model.operations;

import model.Show;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ShowOP {
    public List<Show> readShow() {

        List<Show> list;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        list = session.createSQLQuery("SELECT * FROM show_table").addEntity(Show.class).list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list;
    }
}
