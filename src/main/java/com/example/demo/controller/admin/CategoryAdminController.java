package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/admin/categories/add")
	public String store(@RequestParam(name = "name", defaultValue = "") String name) {
		// リクエストパラメータをもとに登録するカテゴリーをインスタンス化
		Category category = new Category(name);
		// インスタンス化したカテゴリーを永続化
		categoryRepository.save(category);
		// カテゴリー一覧画面表示にリダイレクト
		return "redirect:/admin/categories";
	}
	
	
}
