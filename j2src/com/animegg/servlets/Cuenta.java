/*
 * Created on 18/09/2023
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
public class Cuenta extends HttpServlet {

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
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String apodo = request.getParameter("apodo") ;
			String fecha = request.getParameter("fecha");
			String genero = request.getParameter("genero");
			String oferta = request.getParameter("oferta");
			ArrayList arrayCuentas = new ArrayList();
			
			if (oferta == null){
				oferta = "No";
			}else{}
			
			try{
				OracleDataSource odsDataSource = new OracleDataSource();//Objeto para la conexion.
				odsDataSource.setURL("jdbc:oracle:thin:ANGEL/admin@localhost:1521:XE");//Establecer canal de comunicacion hacia la BD.
				Connection conOracle = odsDataSource.getConnection(); //Crear conexión para la BD.
				Statement stateDML = conOracle.createStatement();//Objeto para instrucciones DML.
				System.out.println("Agregando Registro");
				strQuerry = "INSERT INTO CUENTA (NOMBRE, APELLIDO, EMAIL, PASSWORD, APODO, FECHA_NACIMIENTO, TELEFONO, GENERO, NOVEDADES) " +
             				"VALUES ('" + nombre + "', '" + apellido + 
									"', '" + email + "', '" + password + 
									"', '" + apodo + "', TO_DATE('" + fecha + "', 'YYYY-MM-DD')," + 
									"'" + telefono +"', '" + genero + "', '" + oferta + "')";
             	
				System.out.println(strQuerry);
				stateDML.executeUpdate(strQuerry);//Ejecutar Querry
				conOracle.commit();//Confirmar cambio en la BD.
				System.out.println("\nAgregado");
				
				//Mostrar registros
				strQuerry = "SELECT NOMBRE, APELLIDO, TELEFONO, EMAIL, PASSWORD, APODO, FECHA_NACIMIENTO, GENERO, NOVEDADES FROM CUENTA";
				ResultSet resultCuenta = stateDML.executeQuery(strQuerry); //Ejecutar querry y retomarla en un ResultSet.

				//Asignar data del ResulSet a un Array
				System.out.println("---------------------------");
				while(resultCuenta.next()){
					arrayCuentas.add(new Object[]{ 
						resultCuenta.getString("NOMBRE"),
						resultCuenta.getString("APELLIDO"),
						resultCuenta.getString("TELEFONO"),
						resultCuenta.getString("EMAIL"),
						resultCuenta.getString("PASSWORD"),
						resultCuenta.getString("APODO"),
						resultCuenta.getString("FECHA_NACIMIENTO"),
						resultCuenta.getString("GENERO"),
						resultCuenta.getString("NOVEDADES")
					});
					//Mostrar en el Log
					System.out.println("Nombre:		" + resultCuenta.getString("NOMBRE"));
					System.out.println("Apellido:		" + resultCuenta.getString("APELLIDO"));
					System.out.println("Celular:		" + resultCuenta.getString("TELEFONO"));
					System.out.println("e-mail:		" + resultCuenta.getString("EMAIL"));
					System.out.println("Clave:		" + resultCuenta.getString("PASSWORD"));
					System.out.println("Apodo:		" + resultCuenta.getString("APODO"));
					System.out.println("Fecha Nacimiento:	" +resultCuenta.getString("FECHA_NACIMIENTO"));
					System.out.println("Genero:		" + resultCuenta.getString("GENERO"));
					System.out.println("Novedades: 		" + resultCuenta.getString("NOVEDADES"));
					System.out.println("---------------------------");
				}
				resultCuenta.close(); //Cerrar objeto ResultSet
				conOracle.close();//Cerrar sesión
			} catch(SQLException err){
				err.printStackTrace();
				System.out.println("Error en en la conexion de la BD");
			}
			response.sendRedirect("index.jsp");
	}
}
