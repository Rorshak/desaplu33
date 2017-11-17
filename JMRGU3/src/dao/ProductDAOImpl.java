/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;


/**
 * @author Chema
 *
 */
public class ProductDAOImpl implements ProductDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	public ProductDAOImpl() {
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprod", "postgres", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createProduct(Product product) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("INSERT INTO products (precio,descripcion,existencia,proveedor) values(?,?,?,?);");
				prepareStatement.setFloat(1, product.getPrecio());
				prepareStatement.setString(2, product.getDescripcion());
				prepareStatement.setInt(3, product.getExistencia());
				prepareStatement.setString(4, product.getProveedor());
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Product readProduct(int id) {
		Product product = null;
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM products WHERE id=?;");
				prepareStatement.setInt(1, id);
				resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					product = new Product(resultSet.getInt(1), resultSet.getFloat(2), resultSet.getString(3),
							 resultSet.getInt(4),resultSet.getString(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return product;
	}

	@Override
	public List<Product> readAllProducts() {
		List<Product> products = new ArrayList<Product>();
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM products;");
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Product product = new Product(resultSet.getInt(1), resultSet.getFloat(2), resultSet.getString(3),
							 resultSet.getInt(4),resultSet.getString(5));
					products.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public void updateProduct(Product product) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("UPDATE products  SET precio = ?, descripcion=?, existencia=?," + " proveedor=?  WHERE id=?;");
				prepareStatement.setFloat(1, product.getPrecio());
				prepareStatement.setString(2, product.getDescripcion());
				prepareStatement.setInt(3, product.getExistencia());
				prepareStatement.setString(4, product.getProveedor());
				prepareStatement.setInt(5, product.getId());
				prepareStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteProduct(int id) {
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("DELETE FROM products  WHERE id=?;");
				prepareStatement.setInt(1, id);
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	

}
