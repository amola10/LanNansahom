package eg.net.gxt.client;

public abstract class BaseAsyncCallbackHandler<T> implements com.google.gwt.user.client.rpc.AsyncCallback<T> {

	public void onFailure(Throwable throwable) {
		GXTUtil.hideLoadingMessage();
		ClientExceptionHandler handler = new ClientExceptionHandler();
		handler.handlerException(throwable);
	}

}
