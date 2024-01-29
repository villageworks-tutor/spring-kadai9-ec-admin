package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AccountAdminController {
	
	// ログイン画面表示
	@GetMapping("/admin/login")
	public String index() {
		// 画面遷移
		return "admin/login";
	}
	
	@PostMapping("/admin/login")
	public String login(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {
		// ログイン認証
		if (!("admin".equals(name) && "himitu".equals(password))) {
			model.addAttribute("error", "ユーザ名とパスワードが一致しませんできた。");
			return "/admin/login";
		}
		// 商品一覧表示にリダイレクト
		return "redirect:/admin/items";
	}
	
	
}
