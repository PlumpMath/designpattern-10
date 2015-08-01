package pt.uc.dei.aor.paj.dip.presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.uc.dei.aor.paj.dip.core.model.ICar;
import pt.uc.dei.aor.paj.dip.core.service.ICarBusinessService;

@Named
@RequestScoped
public class CarBean {

    @EJB
    private ICarBusinessService carEJB;

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String createCar() {
        carEJB.createNewCar(brand);

        return "index?redirect=true";
    }

    public Collection<String> getBrands() {
        Collection<String> brands = new ArrayList<>();

        for (ICar car : carEJB.retrieveAllCars()) {
            brands.add(car.getBrand());
        }

        return brands;
    }
}
