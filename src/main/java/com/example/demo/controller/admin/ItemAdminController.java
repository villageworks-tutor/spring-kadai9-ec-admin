package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemAdminController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	// 管理用商品一覧画面表示
	@GetMapping("/admin/items")
	public String index(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			Model model) {
		// すべてのカテゴリーをデータベースから取得
		List<Category> categoryList = categoryRepository.findAll();
		// 取得したカテゴリーリストをスコープに登録
		model.addAttribute("categoryList", categoryList);
		// すべての商品をデータベースから取得
		List<Item> itemList = null;
		if (categoryId == null) {
			// カテゴリーIDが送信されない場合：すべての商品の全検索
			itemList = itemRepository.findAll();
		} else {
			// カテゴリーIDが送信される場合：商品のカテゴリー検索
			itemList = itemRepository.findByCategoryId(categoryId);
		}
		// 取得した商品リストをスコープに登録
		model.addAttribute("itemList", itemList);
		// 画面遷移
		return "admin/items";
	}
	
}
