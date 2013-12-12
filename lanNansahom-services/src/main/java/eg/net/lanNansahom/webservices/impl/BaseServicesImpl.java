package eg.net.lanNansahom.webservices.impl;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.ServiceProcessor;
import eg.net.lanNansahom.ApplicationContext;
import eg.net.lanNansahom.services.BaseServices;
import eg.net.lanNansahom.services.RetrieveAllLookupService;
import eg.net.lanNansahom.services.requests.RetrieveAllLookupRequest;
import eg.net.lanNansahom.services.responses.RetrieveAllLookupResponse;
import eg.net.services.ServiceException;

/**
 * The Class BaseServicesImpl.
 */
public class BaseServicesImpl implements BaseServices {

	private final ApplicationContext context;

	@Autowired
	public BaseServicesImpl(ApplicationContext context) {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eg.net.lanNansahom.services.BaseServicesImpl#retrieveLookup(eg
	 * .net.lanNansahom.services.requests.RetrieveLookupRequest)
	 */
	public RetrieveAllLookupResponse retrieveAllLookup(RetrieveAllLookupRequest request) throws ServiceException {
		ServiceProcessor processor = new ServiceProcessor();
		return (RetrieveAllLookupResponse) processor.handleService(
				context.getInstanceOf(RetrieveAllLookupService.class), request);
	}

}
