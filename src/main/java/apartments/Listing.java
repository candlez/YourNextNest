package apartments;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Listing {
    private @Id @GeneratedValue Long id;
    private String name;
    private String address;
    private int bedrooms;
    private int rent;

    public Listing() {}

    public Listing(String name, String address, int bedrooms, int rent) {
        this.name = name;
        this.address = address;
        this.bedrooms = bedrooms;
        this.rent = rent;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getBedrooms() {
        return this.bedrooms;
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    public int getRent() {
        return this.rent;
    }
    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Listing temp = (Listing)obj;
            return (temp.getAddress().equals(this.address) &&
                temp.getName().equals(this.name) &&
                temp.getBedrooms() == this.bedrooms &&
                temp.getRent() == this.rent &&
                temp.getId() == this.id);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.address, this.bedrooms, this.rent);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Listing{");
        builder.append("id=");
        builder.append(this.id);
        builder.append(", name='");
        builder.append(this.name);
        builder.append("', address='");
        builder.append(this.address);
        builder.append("', bedrooms=");
        builder.append(this.bedrooms);
        builder.append(", rent=");
        builder.append(this.rent);
        builder.append("}");
        return builder.toString();
    }
}
