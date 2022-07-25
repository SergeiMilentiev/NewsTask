package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();
	
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		NewUserInfo newUser = new NewUserInfo();
		
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setDateOfBirth(dateOfBirth);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		try {
			
			boolean isRegistrationComplite = service.registration(newUser);
			
			if(isRegistrationComplite) {
				request.getSession(true).setAttribute("user", "active");
				request.getSession(true).setAttribute("role", "user");
				response.sendRedirect("controller?command=go_to_news_list");
			} else {
				request.getSession(true).setAttribute("user", "not active");
				request.setAttribute("RegistrationError", "wrong data were enter");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			}
		} catch (ServiceException e) {
			//go to error page
		}
	}

}
