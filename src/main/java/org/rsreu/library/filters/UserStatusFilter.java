package org.rsreu.library.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.entity.User;

import java.io.IOException;

public class UserStatusFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Retrieve the user object from the session
        User user = (User) httpRequest.getSession().getAttribute("user");
        Object isAuthorized = httpRequest.getSession().getAttribute("isAuthorized");
        if ((user == null || user.getStatus().equals("SUSPENDED")) && (isAuthorized != null) ) {
            // If user status is suspended, redirect or handle accordingly

            httpResponse.sendRedirect(httpRequest.getContextPath() + "/user-suspended.jsp");
            return;
        }

        // User is active or not found in session, proceed with the chain
        chain.doFilter(request, response);
    }

    // Other methods of the Filter interface (init and destroy) can be left unimplemented for brevity
}
