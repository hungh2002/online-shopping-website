package com.hungh2002.service;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloWorldService {
	// Service is where logic is processed

	public void sendRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Move to the jsp file
		// getContextPath --> get url domain
		response.sendRedirect(request.getContextPath());
	}
}
