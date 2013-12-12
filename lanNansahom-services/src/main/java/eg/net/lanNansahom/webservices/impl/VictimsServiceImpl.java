package eg.net.lanNansahom.webservices.impl;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.ServiceProcessor;
import eg.net.lanNansahom.ApplicationContext;
import eg.net.lanNansahom.services.RetrieveAllInjuriesService;
import eg.net.lanNansahom.services.RetrieveAllMartyrsService;
import eg.net.lanNansahom.services.RetrieveVictimService;
import eg.net.lanNansahom.services.SearchPublishedVictimsService;
import eg.net.lanNansahom.services.VictimsService;
import eg.net.lanNansahom.services.requests.RetrieveAllInjuriesRequest;
import eg.net.lanNansahom.services.requests.RetrieveAllMartyrsRequest;
import eg.net.lanNansahom.services.requests.RetrieveVictimRequest;
import eg.net.lanNansahom.services.requests.SearchPublishedVictimsRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllInjuriesResponse;
import eg.net.lanNansahom.services.responses.RetrieveAllMartyrsRespone;
import eg.net.lanNansahom.services.responses.RetrieveVictimResponse;
import eg.net.lanNansahom.services.responses.SearchPublishedVictimsResponse;
import eg.net.services.ServiceException;

public class VictimsServiceImpl implements VictimsService {

	/** The context. */
	private final ApplicationContext context;

	/**
	 * Instantiates a new victims administration service impl.
	 * 
	 * @param context
	 *            the context
	 */
	@Autowired
	public VictimsServiceImpl(ApplicationContext context) {
		this.context = context;
	}

	public RetrieveAllMartyrsRespone retrieveAllMartyrs(RetrieveAllMartyrsRequest pRequest) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (RetrieveAllMartyrsRespone) processor.handleService(
				context.getInstanceOf(RetrieveAllMartyrsService.class), pRequest);

	}

	public RetrieveAllInjuriesResponse retrieveAllInjuries(RetrieveAllInjuriesRequest pRequest) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (RetrieveAllInjuriesResponse) processor.handleService(
				context.getInstanceOf(RetrieveAllInjuriesService.class), pRequest);

	}

	public SearchPublishedVictimsResponse searchPublishedVictims(SearchPublishedVictimsRequest pRequest)
			throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (SearchPublishedVictimsResponse) processor.handleService(
				context.getInstanceOf(SearchPublishedVictimsService.class), pRequest);

	}

	public RetrieveVictimResponse retrieveVictimById(RetrieveVictimRequest pRequest) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (RetrieveVictimResponse) processor.handleService(context.getInstanceOf(RetrieveVictimService.class),
				pRequest);

	}

}
