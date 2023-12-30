/*
 * Created on 2/10/2023
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.animegg.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * @author Angel Jacinto
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConsultaCuenta extends HttpServlet {

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
			//Variables
			String strQuerry = "";
			String [] valores = new String[3];
			ArrayList condiciones = new ArrayList();
			ArrayList arrayCuentas = new ArrayList();
			
			//Validaciones de asignacion
			if ((request.getParameter("nombre").length() > 0) && (!request.getParameter("nombre").toString().trim().equals(""))){
				valores[0] = request.getParameter("nombre");
			} else {
				valores[0] = "";	
			}
			if ((request.getParameter("apellido").length() > 0) && (!request.getParameter("apellido").toString().trim().equals(""))){
				valores[1] = request.getParameter("apellido");
			} else {
				valores[1] = "";
			}
			if ((request.getParameter("apodo").length() > 0) && (!request.getParameter("apodo").toString().trim().equals(""))){
				valores[2] = request.getParameter("apodo");
			} else {
				valores[2] = "";
			}
			
			try{
				OracleDataSource odsDataSource = new OracleDataSource();//Objeto para la conexion.
				odsDataSource.setURL("jdbc:oracle:thin:ANGEL/admin@localhost:1521:XE");//Establecer canal de comunicacion hacia la BD.
				Connection conOracle = odsDataSource.getConnection(); //Crear conexión para la BD.
				Statement stateDML = conOracle.createStatement();//Objeto para instrucciones DML.
				
				//SQL SELECT
				if(request.getParameter("Buscar") != null){
					System.out.println("Busqueda del Registro");
					//Combinaciones de condiciones
					if (valores[0] != null && valores[0].length() > 0) {
						condiciones.add("UPPER(NOMBRE) = UPPER('" + valores[0] + "')");
					}
					if (valores[1] != null && valores[1].length() > 0) {
						condiciones.add("UPPER(APELLIDO) = UPPER('" + valores[1] + "')");
					}
					if (valores[2] != null && valores[2].length() > 0) {
						condiciones.add("UPPER(APODO) = UPPER('" + valores[2] + "')");
					}
							
					//Construir consulta SQL
					strQuerry = "SELECT ID, NOMBRE, APELLIDO, TELEFONO, EMAIL, APODO, FECHA_NACIMIENTO, GENERO, NOVEDADES FROM CUENTA";
					if (!condiciones.isEmpty()) {
						strQuerry += " WHERE ";
						for (int i = 0; i < condiciones.size(); i++) {
							if (i > 0) {
								strQuerry += " AND ";
							}else{}
							strQuerry += condiciones.get(i);
						}
					}
					System.out.println("Querry a ejecutar: " + strQuerry);
					//Mostrar registros
					ResultSet resultCuenta = stateDML.executeQuery(strQuerry); //Ejecutar querry y retomarla en un ResultSet.
					//Asignar data del ResulSet a un Array
					System.out.println("---------------------------");
					while(resultCuenta.next()){
						arrayCuentas.add(new Object[]{ 
							resultCuenta.getString("ID"),
							resultCuenta.getString("NOMBRE"),
							resultCuenta.getString("APELLIDO"),
							resultCuenta.getString("TELEFONO"),
							resultCuenta.getString("EMAIL"),
							resultCuenta.getString("APODO"),
							resultCuenta.getString("FECHA_NACIMIENTO"),
							resultCuenta.getString("GENERO"),
							resultCuenta.getString("NOVEDADES")
						});
						//Mostrar en el Log
						System.out.println("ID:			" + resultCuenta.getString("ID"));
						System.out.println("Nombre:		" + resultCuenta.getString("NOMBRE"));
						System.out.println("Apellido:		" + resultCuenta.getString("APELLIDO"));
						System.out.println("Celular:		" + resultCuenta.getString("TELEFONO"));
						System.out.println("e-mail:		" + resultCuenta.getString("EMAIL"));
						System.out.println("Apodo:		" + resultCuenta.getString("APODO"));
						System.out.println("Fecha Nacimiento:	" +resultCuenta.getString("FECHA_NACIMIENTO"));
						System.out.println("Genero:		" + resultCuenta.getString("GENERO"));
						System.out.println("Novedades: 		" + resultCuenta.getString("NOVEDADES"));
						System.out.println("---------------------------");
					}
					resultCuenta.close(); //Cerrar objeto ResultSet
					request.getSession().setAttribute("catUsuarios", arrayCuentas);
				} else {/*SQL SELECT*/}
				
				conOracle.close();//Cerrar sesión
			} catch(SQLException err){
				err.printStackTrace();
				System.out.println("Error en en la conexion de la BD");
			}
			
			response.sendRedirect("usuarios.jsp");
	}
}
