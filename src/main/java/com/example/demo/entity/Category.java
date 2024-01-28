package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	/**
	 * デフォルトコンストラクタ
	 */
	public Category() {}
	
	/**
	 * コンストラクタ
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
	}
	
	/**
	 * コンストラクタ
	 * @param id
	 * @param name
	 */
	public Category(Integer id, String name) {
		this(name);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
