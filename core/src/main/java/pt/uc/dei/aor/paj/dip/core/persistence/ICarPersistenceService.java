package pt.uc.dei.aor.paj.dip.core.persistence;

import java.util.Collection;

import pt.uc.dei.aor.paj.dip.core.model.ICar;

/**
 * Provides pseudo-CRUD and custom queries on ICar model.
 */
public interface ICarPersistenceService {

    ICar save(ICar car);

    void delete(ICar car);

    ICar find(long id);

    Collection<ICar> findAll();

    // add custom queries here
}