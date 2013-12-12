package eg.net.lanNansahom.webservices.impl;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.ServiceProcessor;
import eg.net.lanNansahom.ApplicationContext;
import eg.net.lanNansahom.services.AddVictimService;
import eg.net.lanNansahom.services.DeleteVictimsService;
import eg.net.lanNansahom.services.SearchVictimsService;
import eg.net.lanNansahom.services.UpdateVictimService;
import eg.net.lanNansahom.services.VictimsAdministrationService;
import eg.net.lanNansahom.services.requests.AddVictimRequest;
import eg.net.lanNansahom.services.requests.DeleteVictimsRequest;
import eg.net.lanNansahom.services.requests.SearchVictimsRequest;
import eg.net.lanNansahom.services.requests.UpdateVictimsRequest;
import eg.net.lanNansahom.services.responses.AddVictimResponse;
import eg.net.lanNansahom.services.responses.DeleteVictimsResponse;
import eg.net.lanNansahom.services.responses.SearchVictimsResponse;
import eg.net.lanNansahom.services.responses.UpdateVictimsResponse;
import eg.net.services.ServiceException;

/**
 * The Class VictimsAdministrationServiceImpl.
 */
public class VictimsAdministrationServiceImpl implements VictimsAdministrationService {

	/** The context. */
	private final ApplicationContext context;

	/**
	 * Instantiates a new victims administration service impl.
	 * 
	 * @param context
	 *            the context
	 */
	@Autowired
	public VictimsAdministrationServiceImpl(ApplicationContext context) {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.services.VictimsAdministrationService#addVictims(eg
	 * .net.lanNansahom.services.requests.AddVictimRequest)
	 */
	public AddVictimResponse addVictim(AddVictimRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (AddVictimResponse) processor.handleService(context.getInstanceOf(AddVictimService.class), request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.services.VictimsAdministrationService#uUpdateVictims
	 * (eg.net.lanNansahom.services.requests.UpdateVictimsRequest)
	 */
	public UpdateVictimsResponse updateVictim(UpdateVictimsRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (UpdateVictimsResponse) processor.handleService(context.getInstanceOf(UpdateVictimService.class),
				request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.net.lanNansahom.services.VictimsAdministrationService#searchVictims
	 * (eg.net.lanNansahom.services.requests.SearchVictimsRequest)
	 */
	public SearchVictimsResponse searchVictims(SearchVictimsRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (SearchVictimsResponse) processor.handleService(context.getInstanceOf(SearchVictimsService.class),
				request);
	}

	public DeleteVictimsResponse deleteVictim(DeleteVictimsRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (DeleteVictimsResponse) processor.handleService(context.getInstanceOf(DeleteVictimsService.class),
				request);
	}

}
