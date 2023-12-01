package com.kh.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.cafe.repository.CafeRepository;
import com.kh.cafe.vo.Cafe;

@Service
public class CafeService {
	
	private CafeRepository cafeRepository;
	
	@Autowired
	public CafeService(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}
	//전체조회
	public List<Cafe> getAllCafes(){
		return cafeRepository.findAll();
	}
	//상세조회
	public Optional<Cafe> getCafeById(Long id) {
		return cafeRepository.findById(id);
	}
	//추가하기
	public Cafe saveCafe(Cafe cafe) {
		return cafeRepository.save(cafe);
	}
	//삭제하기
	public void deleteCafeById(Long id) {
		cafeRepository.deleteById(id);
	}
	//검색하기
	public List<Cafe> findCafes(String keyword) {
		//return cafeRepository.findCafe(keyword);
		return cafeRepository.findByNameContaining(keyword);
	}
	//repository에 작성한 지역count를 가져 와서 이용할 수 있는 메서드 추가.
	public int countCafesByLocation(String location) {
		return cafeRepository.countByLocation(location);
	}
	//카페 존재여부 확인
	public boolean existsCafeByName(String name) {
		return cafeRepository.existsByName(name);
	}
}