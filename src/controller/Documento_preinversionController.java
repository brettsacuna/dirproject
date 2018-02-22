package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Documento_preinversionDao;
import entity.Documento_preinversion;


@WebServlet("/Documento_preinversionController")
public class Documento_preinversionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Documento_preinversion documento_preinversion;
	Documento_preinversionDao documento_preinversionDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Documento_preinversionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_documento_preinversion")) {

			documento_preinversion = new Documento_preinversion();

			documento_preinversion.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));

			try {

				documento_preinversionDao = new Documento_preinversionDao();

				List<Documento_preinversion> documentos = documento_preinversionDao.Filtrar(documento_preinversion);

				String json = new Gson().toJson(documentos);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			documento_preinversion = new Documento_preinversion();

			documento_preinversion.setId_documento_preinversion(Integer.parseInt(request.getParameter("id_documento_preinversion")));

			try {

				documento_preinversionDao = new Documento_preinversionDao();

				documento_preinversion = documento_preinversionDao.Buscar(documento_preinversion);

				String json = new Gson().toJson(documento_preinversion);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			documento_preinversion = new Documento_preinversion();
						
			if (!(request.getParameter("id_documento_preinversion").equals(""))) {

				documento_preinversion.setId_documento_preinversion(Integer.parseInt(request.getParameter("id_documento_preinversion")));
			}
			
			if (!(request.getParameter("id_proyecto").equals(""))) {

				documento_preinversion.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
			}
			
			if (!(request.getParameter("id_tipo_documento_preinversion").equals(""))) {

				documento_preinversion.setId_tipo_documento_preinversion(Integer.parseInt(request.getParameter("id_tipo_documento_preinversion")));
			}
			
			documento_preinversion.setTipo_documento_preinversion(request.getParameter("tipo_documento_preinversion"));
			documento_preinversion.setDocumento_preinversion(request.getParameter("documento_preinversion"));
													
			documento_preinversion.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				documento_preinversionDao = new Documento_preinversionDao();

				if (operacion.equals("registrar")) {

					documento_preinversionDao.Grabar(documento_preinversion);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					documento_preinversionDao.Modificar(documento_preinversion);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			documento_preinversion = new Documento_preinversion();

			documento_preinversion.setId_documento_preinversion(Integer.parseInt(request.getParameter("id_documento_preinversion")));
			
			try {
				documento_preinversionDao = new Documento_preinversionDao();
				
				documento_preinversionDao.Eliminar(documento_preinversion);
				
				out.println(1);
				
			} catch (Exception e) {
				
				out.println(0);
				
				e.printStackTrace();
			}
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
