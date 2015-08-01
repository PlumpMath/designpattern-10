package pt.uc.dei.aor.paj.dip.core.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import pt.uc.dei.aor.paj.dip.core.model.ICar;
import pt.uc.dei.aor.paj.dip.core.model.IModelFactory;
import pt.uc.dei.aor.paj.dip.core.persistence.ICarPersistenceService;

@Stateless
public class CarBusinessService implements ICarBusinessService {

    @Inject
    private ICarPersistenceService carPersistenceService;

    @Inject
    private IModelFactory modelFactory;

    @Override
    public ICar createNewCar(String brand) {
        ICar car = modelFactory.car();

        car.setBrand(brand);

        return carPersistenceService.save(car);
    }

    @Override
    public Collection<ICar> retrieveAllCars() {
        return carPersistenceService.findAll();
    }
}
