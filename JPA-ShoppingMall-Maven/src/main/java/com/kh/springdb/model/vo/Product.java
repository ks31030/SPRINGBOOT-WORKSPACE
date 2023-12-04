package com.kh.springdb.model.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="product")
public class Product {
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="productId_Seq")
	@SequenceGenerator(name = "productId_Seq", sequenceName = "productId_Seq",allocationSize = 1)
	
	private Long id;
	private String product_name;
	private String category;
	private String price;
	private String stock_quantity;
	private String description;

}
/*
vo
Product -> 모델을 만들어줌(테이블 Column).
interface ProductRepository extends JpaRepository
ProductService
Spring Data JPA 자동으로 SQL 생성 기능을 활용해서 구현이 간결해짐.
특별하게 SQL 작성해야 할 때는 직접 구현을 해야 하는 번거로움이 있음.

ProductService
public class ProductServicelmpl implements ProductService
JPA 사용한다 하지만 구현이 필요한 모든 메서드를 직접 작성.
*/
