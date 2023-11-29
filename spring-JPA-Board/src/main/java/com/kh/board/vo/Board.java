package com.kh.board.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="Board")
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="board_id_sequence")
	@SequenceGenerator(name="board_id_sequence", sequenceName="board_id_sequence", allocationSize=1)
	@Column(name="board_id")
	private Long boardId;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="author")
	private String author;
}
