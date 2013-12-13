package eg.net.lanNansahom.server;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.ResponseExceptionMapper;

import eg.net.lanNansahom.services.exception.ServiceExceptionMapperConstant;
import eg.net.services.ServiceException;

/**
 * The Class ResponseServiceExceptionMapper.
 */
public class ResponseServiceExceptionMapper implements ResponseExceptionMapper<ServiceException> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.cxf.jaxrs.client.ResponseExceptionMapper#fromResponse(javax
	 * .ws.rs.core.Response)
	 */
	public ServiceException fromResponse(Response response) {
		String code = getHeader(response, ServiceExceptionMapperConstant.EXCEPTION_CODE_HEADER_NAME);
		String message = getHeader(response, ServiceExceptionMapperConstant.EXCEPTION_MESSAGE_HEADER_NAME);
		return new ServiceException(code, message);
	}

	/**
	 * Gets the header.
	 * 
	 * @param response
	 *            the response
	 * @param headerName
	 *            the header name
	 * @return the header
	 */
	private String getHeader(Response response, String headerName) {
		String result = null;
		List<Object> values = response.getMetadata().get(headerName);
		if (values != null && values.size() > 0) {
			result = values.get(0).toString();
		}

		return result;
	}
}
