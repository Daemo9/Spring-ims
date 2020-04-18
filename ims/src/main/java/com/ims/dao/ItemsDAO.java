package com.ims.dao;

import java.util.List;

import com.ims.beans.Category;
import com.ims.beans.Items;

public interface ItemsDAO {
	public List<Category> getCategoryList();
	public List<Items> getAllItems(int pageId, int max);
	public void addItems(Items item);
	public void deleteItems(String id);
	public void editItems(Items item,String id);
	public Items editItemDetails(String id);
	public int getTotalRecords();
}
