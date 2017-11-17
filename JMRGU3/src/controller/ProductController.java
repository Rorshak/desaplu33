package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;


/**
 * Servlet implementation class StudentController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Product product;
	private List<Product> products;
	private ProductDAO productDAO;
	private List<String> ids = new ArrayList<String>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
      product = new Product();
      products = new ArrayList<Product>();
      productDAO = new ProductDAOImpl();
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_save") != null) {
			product.setPrecio(Float.parseFloat(request.getParameter("precio")));
			product.setDescripcion(request.getParameter("descripcion"));
			product.setExistencia(Integer.parseInt(request.getParameter("existencia")));
			product.setProveedor(request.getParameter("proveedor"));
			
			System.out.println("save");
			if (product.getId()==0) {
				System.out.println("save");
				productDAO.createProduct(product);
			} else {
				System.out.println("save");
				productDAO.updateProduct(product);
			}
			products = productDAO.readAllProducts();
			request.setAttribute("products", products);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		}else if(request.getParameter("btn_new")!=null) {
			product = new Product();
			request.getRequestDispatcher("product_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				product = productDAO.readProduct(id);	
			}catch (IndexOutOfBoundsException e) {
				product = new Product();
			}
		 request.setAttribute("product", product);
		 request.getRequestDispatcher("product_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				productDAO.deleteProduct(id);
				products = productDAO.readAllProducts();
			}catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("products", products);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		}else {
			products = productDAO.readAllProducts();
			request.setAttribute("students", products);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
