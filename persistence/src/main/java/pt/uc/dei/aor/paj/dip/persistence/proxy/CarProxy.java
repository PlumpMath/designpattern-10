package pt.uc.dei.aor.paj.dip.persistence.proxy;

import pt.uc.dei.aor.paj.dip.core.model.ICar;
import pt.uc.dei.aor.paj.dip.persistence.entity.CarEntity;

public class CarProxy implements IEntityAware<CarEntity>, ICar {

    private CarEntity entity;

    public CarProxy() {
        this(null);
    }

    @Override
    public CarEntity getEntity() {
        return entity;
    }

    public CarProxy(CarEntity entity) {
        this.entity = entity != null ? entity : new CarEntity();
    }

    @Override
    public void setBrand(String brand) {
        entity.setBrand(brand);
    }

    @Override
    public String getBrand() {
        return entity.getBrand();
    }
}
