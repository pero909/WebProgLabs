package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Balloon {
    private String name;
    private String description;
    private Long id;
    private Manufacturer manufacturer;

    public Balloon(String name, String description,Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.id=(long) (Math.random() * 1000);
        this.manufacturer=manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
