package pt.uc.dei.aor.paj.dip.persistence.proxy;

import javax.enterprise.context.RequestScoped;

import pt.uc.dei.aor.paj.dip.core.model.ICar;
import pt.uc.dei.aor.paj.dip.core.model.IModelFactory;

@RequestScoped
public class ModelFactory implements IModelFactory {

    @Override
    public ICar car() {
        return new CarProxy();
    }
}
