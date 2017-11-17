package dao;

import java.util.List;

import model.Product;

public interface ProductDAO {
	void createProduct(Product product);
	Product readProduct(int id);
	List<Product> readAllProducts();
	void updateProduct(Product product);
	void deleteProduct(int id);
	
}
