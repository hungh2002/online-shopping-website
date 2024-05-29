package com.hungh2002.controller;

import java.io.IOException;

import com.hungh2002.service.HelloWorldService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello-world")
public class HelloWorldController extends HttpServlet {

	// Controller is where operations management takes place

	// GET, POST, PUT, DELETE method
	// -->
	// "https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/HTTP-methods"

	// HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	// response) {}
	// HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	// response) {}
	// HttpServlet#doUpdate(HttpServletRequest request, HttpServletResponse
	// response) {}
	// HttpServlet#doDetele(HttpServletRequest request, HttpServletResponse
	// response) {}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Send to logical processor (service)
		HelloWorldService helloWorld = new HelloWorldService();
		helloWorld.sendRedirect(request, response);
	}

}
