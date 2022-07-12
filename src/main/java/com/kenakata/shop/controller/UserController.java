package com.kenakata.shop.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController{

	@GetMapping("/register")
	public String registerUser()
	{
		return "register";
	}
	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	@GetMapping("/buy")
	public String buy()
	{
		return "buy";
	}
	
	@GetMapping("/user/products")
	public String getproduct(Model model) {
		return "uproduct";
	}
	@RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	public String newUseRegister(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("address") String address)
	{
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kenakata","root","");
			PreparedStatement pst = con.prepareStatement("insert into users(username,email,password) values(?,?,?);");
			pst.setString(1,username);
			pst.setString(2, email);
			pst.setString(3, password);
			
			int i = pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "redirect:/";
	}
}
