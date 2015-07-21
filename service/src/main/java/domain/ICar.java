package domain;

import javax.ejb.Remote;

@Remote
public interface ICar {

	void setBrand(String brand);

	String getBrand();

	void addNewCar();

	void removeCar(Object id);

}
