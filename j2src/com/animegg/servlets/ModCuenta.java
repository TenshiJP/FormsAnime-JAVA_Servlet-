/*
 * Created on 9/10/2023
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.animegg.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

/**
 * @author Ochoa
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ModCuenta extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
			doPost(request, response);
	}
	
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
			System.out.println("ModCuenta");
			//Variables
			String strQuerry = "";
			String [] valores = new String[9];
			ArrayList condiciones = new ArrayList();
			ArrayList arrayCuentas = new ArrayList();
			
			//Validaciones de asignacion
			if ((request.getParameter("cod").length() > 0) && (!request.getParameter("cod").toString().trim().equals(""))){
				valores[0] = request.getParameter("cod");
			} else {
				valores[0] = "";	
			}
			if ((request.getParameter("nombre").length() > 0) && (!request.getParameter("nombre").toString().trim().equals(""))){
				valores[1] = request.getParameter("nombre");
			} else {
				valores[1] = "";	
			}
			if ((request.getParameter("apellido").length() > 0) && (!request.getParameter("apellido").toString().trim().equals(""))){
				valores[2] = request.getParameter("apellido");
			} else {
				valores[2] = "";
			}
			if ((request.getParameter("apodo").length() > 0) && (!request.getParameter("apodo").toString().trim().equals(""))){
				valores[3] = request.getParameter("apodo");
			} else {
				valores[3] = "";
			}
			if ((request.getParameter("fecha").length() > 0) && (!request.getParameter("fecha").toString().trim().equals(""))){
				valores[4] = request.getParameter("fecha");
			} else {
				valores[4] = "";	
			}
			if ((request.getParameter("genero").length() > 0) && (!request.getParameter("genero").toString().trim().equals(""))){
				valores[5] = request.getParameter("genero");
			} else {
				valores[5] = "";	
			}
			if ((request.getParameter("telefono").length() > 0) && (!request.getParameter("telefono").toString().trim().equals(""))){
				valores[6] = request.getParameter("telefono");
			} else {
				valores[6] = "";
			}
			if ((request.getParameter("email").length() > 0) && (!request.getParameter("email").toString().trim().equals(""))){
				valores[7] = request.getParameter("email");
			} else {
				valores[7] = "";
			}
			if ((request.getParameter("oferta").length() > 0) && (!request.getParameter("oferta").toString().trim().equals(""))){
				valores[8] = request.getParameter("oferta");
			} else {
				valores[8] = "";
			}
			
			try{
				OracleDataSource odsDataSource = new OracleDataSource();//Objeto para la conexion.
				odsDataSource.setURL("jdbc:oracle:thin:ANGEL/admin@localhost:1521:XE");//Establecer canal de comunicacion hacia la BD.
				Connection conOracle = odsDataSource.getConnection(); //Crear conexión para la BD.
				Statement stateDML = conOracle.createStatement();//Objeto para instrucciones DML.
				
				//SQL UPDATE
				if((request.getParameter("Actualizar") != null) && (request.getParameter("Actualizar").toString().trim().equals("SI"))){
					System.out.println("Actualizar Usuario: ");
					strQuerry = "UPDATE CUENTA SET NOMBRE = '" + valores[1] + "', " +
						"APELLIDO = '" + valores[2] + "', " +
						"APODO = '" + valores[3] + "', " +
						"FECHA_NACIMIENTO = TO_DATE('" + valores[4] + "', 'YYYY-MM-DD')," +
						"GENERO = '" + valores[5] + "', " +
						"TELEFONO = '" + valores[6] + "', " +
						"EMAIL = '" + valores[7] + "', " +
						"NOVEDADES = '" + valores[8] + "' WHERE ID = " + valores[0];
					System.out.println("Consultada a ejecutar: " + strQuerry);
					
					if(!valores[0].equals("0")){
						stateDML.executeUpdate(strQuerry);
						conOracle.commit();//Confirmar cambio en la BD.
					}else{}
				}else {/*FIN UPDATE*/}
				
				//SQL DELETE
				if((request.getParameter("Eliminar") != null) && (request.getParameter("Eliminar").toString().trim().equals("SI"))){
					System.out.println("Eliminar Usuario: ");
					strQuerry = "DELETE FROM CUENTA WHERE ID = " + valores[0];
					System.out.println("Consultada a ejecutar: " + strQuerry);
					if(!valores[0].equals("0")){
						stateDML.executeUpdate(strQuerry);
						conOracle.commit();//Confirmar cambio en la BD.
					}else{}
				}else{/*FIN DELETE*/}
						  
				conOracle.close();//Cerrar sesión
			} catch(SQLException err){
				err.printStackTrace();
				System.out.println("Error en en la conexion de la BD");
			}
			response.sendRedirect("consulta_usuario.jsp");
	}
}
