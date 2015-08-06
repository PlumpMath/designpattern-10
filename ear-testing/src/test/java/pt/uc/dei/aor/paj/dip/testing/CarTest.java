package pt.uc.dei.aor.paj.dip.testing;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import pt.uc.dei.aor.paj.dip.core.model.ICar;
import pt.uc.dei.aor.paj.dip.core.model.IModelFactory;
import pt.uc.dei.aor.paj.dip.core.persistence.ICarPersistenceService;
import pt.uc.dei.aor.paj.dip.core.service.CarBusinessService;
import pt.uc.dei.aor.paj.dip.core.service.ICarBusinessService;
import pt.uc.dei.aor.paj.dip.persistence.entity.CarEntity;
import pt.uc.dei.aor.paj.dip.persistence.proxy.CarProxy;
import pt.uc.dei.aor.paj.dip.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.paj.dip.persistence.proxy.ModelFactory;
import pt.uc.dei.aor.paj.dip.persistence.service.CarPersistenceService;
import pt.uc.dei.aor.paj.dip.presentation.CarBean;

@RunWith(Arquillian.class)
public class CarTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addClass(CarBean.class)
				.addClass(ICarBusinessService.class)
				.addClass(CarBusinessService.class)
				.addClass(ICarPersistenceService.class)
				.addClass(CarPersistenceService.class)
				.addClass(IModelFactory.class)
				.addClass(ModelFactory.class)
				.addClass(ICar.class)
				.addClass(CarProxy.class)
				.addClass(CarEntity.class)
				.addClass(IEntityAware.class)
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Inject
	CarBean car;
	
	@Test
	public void test() {
		car.setBrand("ferrari");
		assertEquals("index?redirect=true",car.createCar());
	}

}
