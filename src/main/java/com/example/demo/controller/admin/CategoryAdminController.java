package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;




@Controller
public class CategoryAdminController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	// カテゴリー一覧画面表示
	@GetMapping("/admin/categories")
	public String index(Model model) {
		// すべてのカテゴリーをデータベースから取得
		List<Category> categoryList = categoryRepository.findAll();
		// 取得したカテゴリーリストをスコープに登録
		model.addAttribute("categoryList", categoryList);
		// 画面遷移
		return "admin/categories";
	}

	// カテゴリー登録画面表示
	@GetMapping("/admin/categories/add")
	public String create() {
		// 画面遷移
		return "admin/addCategory";
	}
	
}
