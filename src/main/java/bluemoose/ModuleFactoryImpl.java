package bluemoose;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import bluemoose.adal.ADALImpl;
import bluemoose.adal.ADALInterface;
import bluemoose.idal.IDALImpl;
import bluemoose.idal.IDALInterface;
import bluemoose.libdal.LibDALImpl;
import bluemoose.libdal.LibDALInterface;
import bluemoose.mediator.MediatorImpl;
import bluemoose.mediator.MediatorInterface;
import bluemoose.translators.Translator;
import bluemoose.translators.web.WebTranslator;

/*
 * Our implementation of the Module Factory Interface for production usage.
 */
public class ModuleFactoryImpl implements ModuleFactoryInterface {

	private IDALInterface iDAL = new IDALImpl(this);
	private ADALInterface aDAL = new ADALImpl(this);
	private LibDALInterface libDAL = new LibDALImpl(this);
	private MediatorInterface mediator = new MediatorImpl(this);
	private List<Translator> translators = Collections.singletonList(new WebTranslator(this));
	
	@Override
	public IDALInterface getIDAL() {
		return iDAL;
	}

	@Override
	public LibDALInterface getLibDAL() {
		return libDAL;
	}

	@Override
	public ADALInterface getADAL() {
		return aDAL;
	}

	@Override
	public MediatorInterface getMediator() {
		return mediator;
	}

	@Override
	public Collection<Translator> getTranslators() {
		return translators;
	}

}
