package model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity(name = "Event")
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private File file;

    public Event(int id, Date date, File file) {
        this.id = id;
        this.date = date;
        this.file = file;
    }

    public Event(Date date, File file) {
        this.date = date;
        this.file = file;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", file=" + file +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return getId() == event.getId() && Objects.equals(getDate(), event.getDate()) && Objects.equals(getFile(), event.getFile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getFile());
    }
}
