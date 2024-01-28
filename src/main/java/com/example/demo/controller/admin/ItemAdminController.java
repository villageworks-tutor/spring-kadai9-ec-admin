package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// 商品登録画面表示
	@GetMapping("/admin/add")
	public String create(Model model) {
		// カテゴリーリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		// 取得したカテゴリーリストをスコープに登録
		model.addAttribute("categoryList", categoryList);
		// 画面遷移
		return "admin/addItem";
	}
	
	// 商品登録処理
	@PostMapping("/admin/add")
	public String store(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price) {
		// リクエストパラメータをもとに登録する商品をインスタンス化
		Item item = new Item(categoryId, name, price);
		// 商品のインスタンスを永続化
		itemRepository.save(item);
		// 商品一覧画面表示にリダイレクト
		return "redirect:/admin/items";
	}
	
	// 商品更新画面表示
	@GetMapping("/admin/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {
		// カテゴリーリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		// 取得したカテゴリーリストをスコープに登録
		model.addAttribute("categoryList", categoryList);
		// 更新対象の商品をデータベースから取得
		Item item = itemRepository.findById(id).get();
		// 取得した商品をスコープに登録
		model.addAttribute("item", item);
		// 画面遷移
		return "admin/editItem";
	}
	
	// 商品更新処理
	@PostMapping("/admin/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price) {
		// 更新対象の商品をインスタンス化
		Item item = new Item(id, categoryId, name, price);
		// 更新対象の商品インスタンスを永続化
		itemRepository.save(item);
		// 商品一覧画面表示にリダイレクト
		return "redirect:/admin/items";
	}
	
	@PostMapping("/admin/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {
		// パスパラメータで指定された商品を削除
		itemRepository.deleteById(id);
		// 商品一覧画面表示にリダイレクト
		return "redirect:/admin/items";
	}
	
	
}
