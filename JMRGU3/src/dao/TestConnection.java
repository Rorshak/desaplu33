package dao;

import model.Product;

public class TestConnection {
	public static void main(String[] args) {
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		//productDAOImpl.createProduct(new  Product( 08,"pule", 1, "Vespertino"));
		productDAOImpl.deleteProduct(1);
	}
}
