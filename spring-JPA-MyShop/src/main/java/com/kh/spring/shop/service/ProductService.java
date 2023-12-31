package com.kh.spring.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.shop.repository.ProductRepository;
import com.kh.spring.shop.vo.Product;


@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	//상품 전체 조회
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	//상품 상세 조회
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}
	//상품 추가하기
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	//상품 삭제하기
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	//상품 모두 삭제하기
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}
}