package pt.uc.dei.aor.paj.dip.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
@NamedQuery(name = CarEntity.NQ_FIND_ALL, query = "SELECT e FROM CarEntity e")
public class CarEntity {

    public static final String NQ_FIND_ALL = "FIND_ALL";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String brand;

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
