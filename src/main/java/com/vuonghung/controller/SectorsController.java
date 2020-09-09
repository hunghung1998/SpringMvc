package com.vuonghung.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vuonghung.model.Items;
import com.vuonghung.model.Sectors;
import com.vuonghung.model.User;
import com.vuonghung.model.UserAccount;
import com.vuonghung.service.SectorsService;

@Controller
public class SectorsController {
	@Autowired
	private SectorsService sectorsService;
	
	@RequestMapping(value={"/","/customer-list"})
	public String listCustomer( HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}
	
	/*@RequestMapping(value={"/","/customer-list"})
	public String listCustomer( HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
        ArrayList<Sectors> list = null;
        
        sectorsService = new SectorsService();
        
        int page=1,pageSize = 5;  
		int totalpage = sectorsService.getcountSectors();
        if(request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        if(totalpage %  pageSize ==0) {
        	totalpage = totalpage/pageSize;
        }else {
        	totalpage = totalpage/pageSize+1;
        }
       
        List<Sectors> lists=null;
		try {
			lists = sectorsService.querySector(page, pageSize);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}*/
	
	@RequestMapping("/login")
	public String login() {
		return "sectors-login";
	}	
	
	
	@RequestMapping(value = {"/login1"}, method = RequestMethod.POST)
	public String loginpage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
		
		UserAccount user = new UserAccount();
		user.setUserName(userName);
		user.setPassword(password);
		request.setAttribute("user", user);
	   // response.sendRedirect(request.getContextPath() + "/customer-view");
		return "customer-view";	
		//return password;
	}
	
	
	@RequestMapping("/customer-view/{id}")
	public String viewCustomer(@PathVariable String id,HttpServletRequest request) {
		Sectors customer = sectorsService.findById(id);
		request.setAttribute("customer", customer);
		return "customer-view";
	}
	
	/*
	@RequestMapping("/customer-save")
	public String insertCustomer(Model model) {
		model.addAttribute("customer", new Sectors());
		return "customer-save";
	}
	
	@RequestMapping("/customer-view/{id}")
	public String viewCustomer(@PathVariable String id, Model model) {
		Sectors customer = sectorsService.findById(id);
		model.addAttribute("customer", customer);
		return "customer-view";
	}
	
	@RequestMapping(value={"/","/customer-list"})
	public String listCustomer(Model model) {
		model.addAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}
	
	@RequestMapping("/customer-update/{id}")
	public String updateCustomer(@PathVariable String id, Model model) {
		Sectors sectors = sectorsService.findById(id);
		model.addAttribute("sectors", sectors);
		return "customer-update";
	}
	
	@RequestMapping("/updateCustomer")
	public String doUpdateCustomer(@ModelAttribute("Sectors") Sectors sectors, Model model) {
		sectorsService.update(sectors);
		model.addAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}
	
	@RequestMapping("/customerDelete/{id}")
	public String doDeleteCustomer(@PathVariable String id, Model model) {
		sectorsService.delete(id);
		model.addAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}
	
	@RequestMapping("/saveCustomer")
	public String doSaveCustomer(@ModelAttribute("Customer") Sectors customer, Model model) {
		sectorsService.save(customer);
		model.addAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}*/

	@RequestMapping("/customer-save")
	public String insertCustomer(HttpServletRequest request) {
		request.setAttribute("customer", new Sectors());
		return "customer-save";
	}
	
	@RequestMapping("/customer-update/{id}")
	public String updateCustomer(@PathVariable String id, HttpServletRequest request) {
		Sectors sectors = sectorsService.findById(id);
		request.setAttribute("sectors", sectors);
		return "customer-update";
	}
	
	@RequestMapping("/updateCustomer")
	public String doUpdateCustomer(@ModelAttribute("Sectors") Sectors sectors, HttpServletRequest request) {
		sectorsService.update(sectors);
		request.setAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}
	
	@RequestMapping("/customerDelete/{id}")
	public String doDeleteCustomer(@PathVariable String id,Model model) {
		sectorsService.delete(id);
		model.addAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}
	
	@RequestMapping("/saveCustomer")
	public String doSaveCustomer(@ModelAttribute("Customer") Sectors customer, HttpServletRequest request) {
		sectorsService.save(customer);
		request.setAttribute("listCustomer", sectorsService.findAll());
		return "customer-list";
	}
	@RequestMapping("/list-json")
	@ResponseBody
	public List<Sectors> testListJSON() {
		List<Sectors> listUser = new ArrayList<Sectors>();
		listUser = sectorsService.findAll();
		return listUser;
	}
	
	@RequestMapping("/editjson/{id}")
	@ResponseBody
	public Sectors eidtjson(Sectors sector) {
		return sector;                                                          
	}

	@RequestMapping("/list-items")
	@ResponseBody
	public List<Items> listJson_Items(){
		List<Items> listItems = new ArrayList<Items>();
		listItems = sectorsService.findall_items();
		return listItems;
	}
}
