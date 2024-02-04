package apartments;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tenant {
    private @Id @GeneratedValue Long id;
    private String name;
    
    public Tenant() {}

    public Tenant(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Tenant temp = (Tenant)obj;
            return (temp.getId() == this.id &&
                temp.getName().equals(this.name));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Tenant{");
        builder.append("id=");
        builder.append(this.id);
        builder.append(", name='");
        builder.append(this.name);
        builder.append("\'}");
        return builder.toString();
    }
}
