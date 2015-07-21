package crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import entity.CarEntity;
import proxy.CarProxy;

@Stateless
public class CarCRUD {
	@PersistenceUnit(name = "Test")
	private EntityManager em;

	public void createOrUpdate(CarEntity car) {
		em.merge(car);
	}

	public void remove(CarEntity car) {
		em.remove(em.merge(car));
	}

	public CarEntity find(Object id) {
		return em.find(CarEntity.class, id);
	}

}
