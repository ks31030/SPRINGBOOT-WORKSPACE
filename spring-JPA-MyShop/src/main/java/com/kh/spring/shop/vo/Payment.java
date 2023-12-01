package com.kh.spring.shop.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="payments")
@Getter @Setter
public class Payment {
	//데이터베이스에 주문 정보를 저장하기 위한 클래스.
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paymentId_Seq")
	@SequenceGenerator(name="paymentId_Seq", sequenceName="paymentId_Seq", allocationSize=1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	private int paymentStatus;
}