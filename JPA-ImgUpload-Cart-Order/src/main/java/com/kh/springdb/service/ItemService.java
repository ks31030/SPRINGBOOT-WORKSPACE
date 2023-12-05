package com.kh.springdb.service;

import com.kh.springdb.model.vo.Item;
import com.kh.springdb.repository.ItemRepository;
import java.util.*;
public class ItemService {
	//상품을 추가하고 삭제하고 수정하는 기능.
	private ItemRepository itemRepository;
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	//상품 읽기 find를 사용해서 개별 읽기
	public Item getItemById(Integer id) {
		return itemRepository.findById(id).get();
	}
	//findById 사용해서 Id에 해당하는 값을 가져오고 get을 이용해서 Item 객체를 반환.
	
	//모든 상품 갖고 오기 List
	public List<Item> allItemList(){
		return itemRepository.findAll();
	}
	public void itemDelete(Integer Id) {
		itemRepository.deleteById(Id);
	}
}
