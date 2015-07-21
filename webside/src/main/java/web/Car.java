package web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.ICar;

@Named
@RequestScoped
public class Car {
	
	@EJB
	private ICar carimplem;
	
	public Car() {
	}

	public String getBrand() {
		return carimplem.getBrand();
	}

	public void setBrand(String brand) {
		carimplem.setBrand(brand);
	}
	
	public void createCar() {
		carimplem.addNewCar();
	}
	
	

}
