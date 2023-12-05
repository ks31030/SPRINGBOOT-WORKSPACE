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
Table : 테이블 이름을 지정.
@Id : 해당 필드가 엔터티의 PK임을 나타냄.
@Column : 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있음.
	nullable : 해당 컬럼이 null값을 허용하는지 여부를 나타냄.
vo
Product -> 모델을 만들어줌(테이블 Column).
interface ProductRepository extends JpaRepository
ProductService
Spring Data JPA 자동으로 SQL 생성 기능을 활용해서 구현이 간결해짐.
특별하게 SQL 작성해야 할 때는 직접 구현을 해야 하는 번거로움이 있음.

ProductService
public class ProductServicelmpl implements ProductService
JPA 사용한다 하지만 구현이 필요한 모든 메서드를 직접 작성.

Lombok
	@Builder : 객체를 생성할 때 매개변수의 순서나 갯수에 상관없이
		보기 편하게 객체를 생성할 수 있도록 도와주는 메서드.
	@All Args Consructor : 모든 필드에 생성자를 생성해줌.
		객체를 생성할 때 모든 필드를 포함하는 생성자를 쉽게 만들 수 있음.
		예제코드 :
		@AllArgsConstructor
			public class Student {
				private String name; //new Student("학생명", 3);
				private int grade;
			}
			
	@No Args Constructor
		매개변수가 없는 기본 생성자를 생성해줌.
		예제코드 : 
		@NoArgsConstructor
			public class School {
								//new School()
			}

JPA 어노테이션
	@Prepersist 엔터티가 데이터베이스에 저장되기 전에 호출되는 메서드를 지정.
		엔터티에 필요한 사전 처리 작업을 수행하는 데 많이 사용.
		예제코드 : 
		@Entity
		public class TestEntity {
			@Id
			private Long id;
			private String name;
			@DateTimeFormat(pattern="yyyy-mm-dd")
			private Date createDate;
					//now라는 메서드를 활용해서 현재시간 기입.
			@Prepersist
			private void preWork() {
				//저장 전 수행할 작업을 작성.
				//생성일자 설정, 특정 필드 초기화.
			}
			@Prepersist
			private void createDate() {
				this.createDate = LocalDate.now();
			}
		}
*/
