package eg.net.lanNansahom.server;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ClientPasswordCallback implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
				if (pc.getIdentifier().equals("lannansahomGWTClient")) {
					pc.setPassword("ThAWrA2011$&*");
				}
			} else {
				throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
			}

		}
	}

}
