package com.ims.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.Category;
import com.ims.beans.Items;
import com.ims.dao.ItemsDAO;

@Service("itemsService")
public class ItemsService {
	@Autowired
	private ItemsDAO itemsDAO;

	public ItemsDAO getItemsDAO() {
		return itemsDAO;
	}

	public void setItemsDAO(ItemsDAO itemsDAO) {
		this.itemsDAO = itemsDAO;
	}
	public List<Category> getCategory(){
		return itemsDAO.getCategoryList();
	}
	
	public List<Items> getItems(int pageId, int max){
		return itemsDAO.getAllItems(pageId, max);
	}
	public void addItems(Items item) {
		itemsDAO.addItems(item);
	}
	public void deleteItems( String id) {
		itemsDAO.deleteItems(id);
	}
	public void updateItems(Items item, String id) {
		itemsDAO.editItems(item,id);
	}
	public Items editItemDetails(String id) {
		return itemsDAO.editItemDetails(id);
	}
	public int getTotalRecords() {
		return itemsDAO.getTotalRecords();	
	}
}
