package proxy;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import crud.CarCRUD;
import domain.ICar;
import entity.CarEntity;

@Stateless
public class CarProxy implements ICar {
	
	private CarEntity car;
	
	@EJB
	private CarCRUD crud;
	
	public CarProxy() {
	}
	
	@Override
	public void setBrand(String brand) {
		if (car != null) {
			car.setBrand(brand);
			crud.createOrUpdate(car);
		}
	}
	
	@Override
	public String getBrand() {
		if (car != null) return car.getBrand();
		return null;
	}
	
	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}
	
	@Override
	public void addNewCar() {
		crud.createOrUpdate(car);
	}
	
	@Override
	public void removeCar(Object id) {
		crud.remove(crud.find(id));
	}
	
	
	
	

}
