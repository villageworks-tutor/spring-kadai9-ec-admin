package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;


@Controller
public class CustomerAdminController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/admin/customers")
	public String index(Model model) {
		// すべての顧客をデータベースから取得
		List<Customer> customerList = customerRepository.findAll();
		// 取得した顧客リストをスコープに登録
		model.addAttribute("customerList", customerList);
		// 画面遷移
		return "admin/customers";
	}
	
}
