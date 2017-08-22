package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ai.api.AIServiceException;
import ai.api.model.AIResponse;
import ai.api.web.AIServiceServlet;

/*@WebServlet(initParams = {
        @WebInitParam(name = MyServiceServlet.PARAM_API_AI_KEY,
        value = "c52536d801de4975a86024f33e87b511")
    })*/

public class MyServiceServlet extends AIServiceServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AIResponse aiResponse = request(request.getParameter("query"), request.getSession());
			response.setContentType("text/plain");
			response.getWriter().append(aiResponse.getResult().getFulfillment().getSpeech());
			//aiResponse.getResult().getFulfillment().getSpeech()
		} catch (AIServiceException e) {
			System.out.println("Exception accesing API AI");

		}
	}
}