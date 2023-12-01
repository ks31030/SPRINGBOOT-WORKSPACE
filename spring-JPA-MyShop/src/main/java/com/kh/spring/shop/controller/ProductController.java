package com.kh.spring.shop.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.shop.service.ProductService;
import com.kh.spring.shop.vo.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public String getAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "product_list";
	}
	
	@GetMapping("/details/{id}")
	public String getProductDetails(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product", value));
		return "product_detail";
	}
	
	@GetMapping("/new")
	public String displayProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "prodcut_form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateProduct(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product", value));
		return "product_form";
	}
	
	@GetMapping("/delete/{boardId}")
	public String deleteBoard(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "redirect:/boards";
	}
	
	@GetMapping("/delete/all")
	public String deleteAllProducts() {
		productService.deleteAllProducts();
		return "redirect:/products";
	}
}