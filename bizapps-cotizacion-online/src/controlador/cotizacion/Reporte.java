package controlador.cotizacion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reporte
 */
@WebServlet("/Reporte")
public class Reporte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CCotizacion controlador = new CCotizacion();
		ServletOutputStream out;
		String par1 = request.getParameter("valor");
		String par2 = request.getParameter("valor2");
		String par3 = request.getParameter("valor3");
		String tipo = request.getParameter("valor20");
		byte[] fichero = null;
		switch (par1) {
		case "1":
			fichero = controlador.reporte(par2, par3, tipo);
			break;
		default:
			break;
		}
		if (tipo != null) {
			if (tipo.equals("EXCEL")) {
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"inline; filename=Reporte.xlsx");
			} else {
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition",
						"inline; filename=Reporte.pdf");
			}
		} else {
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition",
					"inline; filename=Reporte.pdf");
		}

		response.setHeader("Cache-Control", "max-age=30");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentLength(fichero.length);
		out = response.getOutputStream();
		out.write(fichero, 0, fichero.length);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
