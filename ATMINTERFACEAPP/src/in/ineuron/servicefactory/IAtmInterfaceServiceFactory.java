package in.ineuron.servicefactory;

import in.ineuron.service.IAtmInterface;
import in.ineuron.service.IAtmInterfaceImpl;

public class IAtmInterfaceServiceFactory {

	static IAtmInterface atmInterface = null;

	public static IAtmInterface getIAtmInterfaceImpl() {

		if (atmInterface == null) {

			atmInterface = new IAtmInterfaceImpl();
		}

		return atmInterface;

	}

}
