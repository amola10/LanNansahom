package eg.net.lanNansahom;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;

import eg.net.lanNansahom.services.exception.ServiceExceptionMapperConstant;
import eg.net.services.ServiceException;

/**
 * The Class ServiceExceptionMapper.
 */
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	public Response toResponse(ServiceException exception) {
		ResponseBuilder builder = Response.status(Response.Status.NOT_ACCEPTABLE);
		builder = builder.header(ServiceExceptionMapperConstant.EXCEPTION_CODE_HEADER_NAME, exception.getCode());
		builder = builder.header(ServiceExceptionMapperConstant.EXCEPTION_MESSAGE_HEADER_NAME, exception.getMessage());
		return builder.build();
	}

}
