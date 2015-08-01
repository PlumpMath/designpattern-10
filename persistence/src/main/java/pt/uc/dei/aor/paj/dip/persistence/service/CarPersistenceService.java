package pt.uc.dei.aor.paj.dip.persistence.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.paj.dip.core.model.ICar;
import pt.uc.dei.aor.paj.dip.core.persistence.ICarPersistenceService;
import pt.uc.dei.aor.paj.dip.persistence.entity.CarEntity;
import pt.uc.dei.aor.paj.dip.persistence.proxy.CarProxy;
import pt.uc.dei.aor.paj.dip.persistence.proxy.IEntityAware;

@Stateless
public class CarPersistenceService implements ICarPersistenceService {

    @PersistenceContext(unitName = "Test")
    private EntityManager em;

    @Override
    public ICar save(ICar car) {
        CarEntity entity = getEntity(car);

        entity = em.merge(entity);

        return new CarProxy(entity);
    }

    @Override
    public void delete(ICar car) {
        CarEntity entity = getEntity(car);

        em.remove(em.merge(entity));
    }

    @Override
    public ICar find(long id) {
        final CarEntity entity = em.find(CarEntity.class, id);

        return new CarProxy(entity);
    }

    @SuppressWarnings("unchecked")
    private CarEntity getEntity(ICar carProxy) {
        if (carProxy instanceof IEntityAware<?>) {
            return ((IEntityAware<CarEntity>) carProxy).getEntity();
        }

        throw new IllegalStateException();
    }

    @Override
    public Collection<ICar> findAll() {
        Collection<ICar> cars = new ArrayList<>();

        final TypedQuery<CarEntity> nq = em.createNamedQuery(CarEntity.NQ_FIND_ALL, CarEntity.class);

        for (CarEntity carEntity : nq.getResultList()) {
            cars.add(new CarProxy(carEntity));
        }

        return cars;
    }
}
