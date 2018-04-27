package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "show_table")
public class Show {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "genre")
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Column(name = "distribution")
    private String distribution;

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    @Column(name = "dateDistribution")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "nrTickets")
    private int nrTickets;

    public int getNrTickets() {
        return nrTickets;
    }

    public void setNrTickets(int nrTickets) {
        this.nrTickets = nrTickets;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", distribution='" + distribution + '\'' +
                ", date=" + date +
                ", nrTickets=" + nrTickets +
                '}';
    }
}



