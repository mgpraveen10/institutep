package com.institute.core.servlets;

public class Login {
	 
		String userName = "praveen";
		String password = "@12345";
		public boolean isvalid = false;
		
		public boolean valid(String user,String pass){
			if(user.equals(userName) && pass.equals(password)){
				 isvalid = true;
				
			}
			else{
				isvalid= false;
			}
			
			return isvalid;
			
		}

	 }
