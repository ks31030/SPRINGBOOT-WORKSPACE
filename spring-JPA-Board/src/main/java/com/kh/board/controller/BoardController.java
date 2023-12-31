package com.kh.board.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.board.service.BoardService;
import com.kh.board.vo.Board;

@Controller
@RequestMapping("/boards")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping
	public String getAllBoards(Model model) {
		model.addAttribute("boards", boardService.getAllBoards());
		return "boardList";
	}
	
	//게시물 상세보기 컨트롤러
	@GetMapping("/details/{boardId}")
	public String getBoardDetails(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "boardDetail";
	}
	
	//insert Get Post Mapping
	@GetMapping("/new")
	public String displayBoardForm(Model model) {
		model.addAttribute("board", new Board());
		return "boardForm";
	}
	
	@PostMapping("/save")
	public String saveBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/boards";
	}
	
	@GetMapping("/update/{boardId}")
	public String getUpdateBoard(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "boardForm";
	}
	
	//삭제하기
	@GetMapping("/delete/{boardId}")
	public String deleteBoard(@PathVariable Long boardId) {
		boardService.deleteBoard(boardId);
		return "redirect:/boards";
	}
	
	//모두 삭제하기
	@GetMapping("/delete/all") //getAllBoards가 기본 경로라서 모두 삭제하는 메서드에도 경로를 따로 지정해주지 않으면 경로가 중복되어 제대로 실행되지 않음.
	public String deleteAllBoards() {
		boardService.deleteAllBoards();
		return "redirect:/boards";
	}
}