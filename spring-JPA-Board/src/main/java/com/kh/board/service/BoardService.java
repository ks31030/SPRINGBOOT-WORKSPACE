package com.kh.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.board.repository.BoardRepository;
import com.kh.board.vo.Board;

public class BoardService {
	private final BoardRepository boardRepository;
	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	//게시물 전체 조회
	public List<Board> getAllBoards(){	
		return boardRepository.findAll();
	}
	//게시물 상세 조회
	public Optional<Board> getBoardById(Long id) {
		return boardRepository.findById(id);
	}
	
	
}
