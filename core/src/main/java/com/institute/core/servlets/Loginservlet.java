package com.institute.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import com.adobe.granite.crypto.CryptoException;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths="+ "/bin/userlogin"
       
})

public class Loginservlet extends SlingAllMethodsServlet{ 

	



		private static final long serialVersionUid = 1L;
	@Override
	protected void doPost(SlingHttpServletRequest request,SlingHttpServletResponse response) throws ServletException,IOException {  
	    java.util.logging.Logger.getLogger(getServletName()+"UserLogin");        

	    String user;
	    String password;
	    String osgiService="";
	    System.out.println("Inside the servlet");

	    try {
				System.out.println("Inside the try");
				user = request.getParameter("user");

				password = request.getParameter("password");
				Login ob = new Login();

				boolean isValid = false;
				isValid = ob.valid(user, password);
				String status = " ";

				if (isValid) {
					status = "202";
				} else {
					status = "404";
				}
	    	JSONObject obj=new JSONObject();
	       // obj.put("id",id);
	        obj.put("status",status);
	   
	    	System.out.println(user+"&&&&"+password);
	    	
	    	 String jsonData = obj.toString();
	    	 response.setCharacterEncoding("UTF-8");
	    	 response.setContentType("application/json");
	    	 
	    	
	         //Return the JSON formatted data
	    	 response.getWriter().write(jsonData);
	    	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	       //TODO
	    }         
	}
	}

	/** Wrapper class to always return GET for AEM to process the request/response as GET. 
	*/


