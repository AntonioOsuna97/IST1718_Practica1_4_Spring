package org.ingservicio.IST1718Practica4;


import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//Indica que el bean es un dao
@Repository
public class DAOUsuarios implements DAOUsuariosInterfaz {
	//Añadir libreria spring-jdbc y dependencia junto a la versión
	public JdbcTemplate jdbcTemplate;
	//private DataSource dataSource;
	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
		public List<DTOUsuarios> leeUsuarios(){
			String sql = "select * from usuarios";
			UsuarioMapper mapper = new UsuarioMapper();
			List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql,mapper);
			return usuarios;
		}
		
		public boolean buscaUsuario(String nombre, String password){ 
			String sql = "SELECT * FROM usuarios WHERE Nombre='"+nombre+"' && Password='"+password+"';";
			Object[ ] parametros = {nombre,password}; //Array de objetos
			UsuarioMapper mapper = new UsuarioMapper();
			List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
			if (usuarios.isEmpty()) return false;
			else return true;
			}
		
		//Añadir usuario
		//Preguntar al profesor si añadir objeto usuario o pasar los parametros
		public void addUsuario(String nombre, String password, String email, String dni) {
			String sql="INSERT INTO usuarios (Nombre, Password, Email, DNI)"
					+ " VALUES ('"+nombre+"','"+password+"','"+email+"','"+dni+"');";
			Object[ ] parametros = {nombre,password,email,dni}; //Array de objetos
			this.jdbcTemplate.update(sql, parametros);
		}
}

