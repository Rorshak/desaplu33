package report;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class ProductReport
 */
@WebServlet("/ProductReport")
public class ProductReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAOImpl dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductReport() {
        super();
        dao = new ProductDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\Home\\eclipse-workspace\\ProjectProd\\src\\report\\product_reportss.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			Map<String, Object> data = new HashMap<String, Object>();
			// data.put("Image",this.getServletContext().getRealPath("/")+"images/helloWordl.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnection());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush(); //Escribe los datos
			response.getOutputStream().close();	//Cierra los datos
		}catch (Exception e) {
			e.printStackTrace();
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
