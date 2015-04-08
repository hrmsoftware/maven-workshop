package se.hrmsoftware.labb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

	private HelloWorld helloWorld;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.helloWorld = new HelloWorld(Optional.ofNullable(config.getInitParameter("greeting.prefix")).orElse("Howdy Doody, "));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/greeter.jsp").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = Optional.ofNullable(req.getParameter("name-field"))
				.map(String::toString)
				.map(String::trim)
				.orElseThrow(() -> new IllegalArgumentException("name-field is a mandatory parameter"));
		req.setAttribute("greeting", helloWorld.greet(name));
		req.getRequestDispatcher("/WEB-INF/views/greeter.jsp").include(req, resp);
	}
}
