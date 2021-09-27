package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Objects;

@javax.persistence.Entity(name = "Files")
@javax.persistence.Table(name = "file")
public class File {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fileName")
    private String name;

    public File(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public File(String name) {
        this.name = name;
    }

    public File() {
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

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return getId() == file.getId() && Objects.equals(getName(), file.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
