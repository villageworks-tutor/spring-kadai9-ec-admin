package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;



@Controller
public class CustomerAdminController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	// 顧客一覧画面表示
	@GetMapping("/admin/customers")
	public String index(Model model) {
		// すべての顧客をデータベースから取得
		List<Customer> customerList = customerRepository.findAll();
		// 取得した顧客リストをスコープに登録
		model.addAttribute("customerList", customerList);
		// 画面遷移
		return "admin/customers";
	}
	
	@GetMapping("/admin/customers/{id}/orders")
	public String show(
			@PathVariable("id") Integer id,
			Model model) {
		// パスパラメータをもとに顧客インスタンスをデータベースから取得
		Customer customer = customerRepository.findById(id).get();
		// 取得した顧客インスタンスをスコープに登録
		model.addAttribute("customer", customer);
		// 顧客インスタンスをもとに注文インスタンスをデータベースから取得
		List<Order> orderList = orderRepository.findByCustomerId(id);
		// 取得した注文インスタンスをスコープに登録
		model.addAttribute("orderList", orderList);
		// 取得した注文リストをもとに注文明細インスタンスをデータベースから取得
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		for (Order order : orderList) {
			List<OrderDetail> details = orderDetailRepository.findByOrderId(order.getId());
			for (OrderDetail detail : details) {
				detailList.add(detail);
			}
		}
		// 取得した注文明細をスコープに登録
		model.addAttribute("detailList", detailList);
		// 画面遷移
		return "admin/orders";
	}
	
	
}
