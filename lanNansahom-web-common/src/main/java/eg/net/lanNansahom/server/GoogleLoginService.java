package eg.net.lanNansahom.server;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class GoogleLoginService {

	private static final Logger LOGGER = Logger.getLogger(GoogleLoginService.class);

	private final UserService userService = UserServiceFactory.getUserService();

	public void sendRedirectLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(userService.createLoginURL(request.getRequestURI()));

	}

	public boolean isUserLoggedIn() {
		boolean result = false;
		User user = userService.getCurrentUser();
		if (user != null) {
			result = true;
		}
		return result;
	}

	public boolean isUserAuthorized() {
		boolean result = false;
		User user = userService.getCurrentUser();

		if (user != null
				&& ("admin@lan-nansahom.org".equals(user.getEmail()) || "lan-nansahom.org@lan-nansahom.org".equals(user
						.getEmail()))) {
			result = true;
		}
		return result;
	}
}
