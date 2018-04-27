package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ticket_table")
public class Ticket {
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


    @Column(name = "row")
    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "number")
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Column(name = "isSold")
    private boolean isSold;

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showID", nullable = false)
    private Show show;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", row=" + row +
                ", number=" + number +
                ", isSold=" + isSold +
                ", show=" + show.toString() +
                '}';
    }
}
