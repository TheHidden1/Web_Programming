package mk.finki.uki.mk.lab.model;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Production {
    private Long id;
    private String name;
    private String country;
    private String address;
    public Production(String name, String country, String address) {
        this.id = (long) (Math.random()*1000);
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
