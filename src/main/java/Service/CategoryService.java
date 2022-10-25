package Service;

import java.io.File;
import java.util.List;

import DAO.CategoryDAO;
import Interface.ICategoryDAO;
import model.Category;
import util.Constant;

public class CategoryService implements ICategoryDAO {

	ICategoryDAO categoryDAO = new CategoryDAO();

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.insert(category);
	}

	@Override
	public void edit(Category newCategory) {
		// TODO Auto-generated method stub
		Category oldCategory = categoryDAO.get(newCategory.getCateid());
		oldCategory.setCatename(newCategory.getCatename());
		if (newCategory.getIcon() != null) {
			String fileName = oldCategory.getIcon();
			File file = new File(Constant.DIR + "/category" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setIcon(newCategory.getIcon());
		}
		categoryDAO.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryDAO.delete(id);
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.get(id);
	}

	@Override
	public Category get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDAO.getAll();
	}

	@Override
	public List<Category> search(String keyword) {
		// TODO Auto-generated method stub
		return categoryDAO.search(keyword);
	}

}
