package pt.uc.dei.aor.paj.dip.core.service;

import java.util.Collection;

import pt.uc.dei.aor.paj.dip.core.model.ICar;

public interface ICarBusinessService {

    ICar createNewCar(String brand);

    Collection<ICar> retrieveAllCars();
}
