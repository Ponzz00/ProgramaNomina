package Nomina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NominaBD {
	
	static final String driver="com.mysql.cj.jdbc.Driver";
	static final String db_url="jdbc:mysql://localhost/nominabd?serverTimezone=UTC";
	static final String user="root";
	static final String pwd="Diego0904";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection com=null;
		Statement stmt= null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		com= DriverManager.getConnection(db_url,user,pwd);
		
		stmt=com.createStatement();
		String sql;
		
		//-----------CONSULTAS MYSQL--------------
		sql="select persona.nombre,persona.apellidos,persona.dni,"
				+ "persona.departamento,persona.numeroSS,empresa.Empresa "
				+ "from persona join empresa on persona.id_empresa= empresa.id_emp;";
		//-----------------------------------------
		
		ResultSet rs=stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			String Nombre=rs.getString(1);
			String Apellidos=rs.getString(2);
			String dni=rs.getString(3);
			String departamento=rs.getString(4);
			String numeroSS=rs.getString(5);
			String nomEmpresa=rs.getString(6);
			
		
			
				System.out.print("-----------------------------------------------------");
				System.out.print("\nNombre: "+Nombre+"\nApellidos: "+Apellidos+"\nDNI: "+ dni+"\nDepartamento: "+departamento
						+"\nNumero de S.S.: "+numeroSS+"\nEmpresa: "+nomEmpresa+"\n");
				System.out.print("-----------------------------------------------------");
		}
		rs.close();
		stmt.close();
		com.close();
		

	}

}
