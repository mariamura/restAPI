package model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@javax.persistence.Entity(name = "Users")
@javax.persistence.Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "userName")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Event> events;

    public User(int id, String name, List<Event> events) {
        this.id = id;
        this.name = name;
        this.events = events;
    }

    public User(String name, List<Event> events) {
        this.name = name;
        this.events = events;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", events=" + events +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
