package org.ingservicio.IST1718Practica4;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;




public class UsuarioMapper implements RowMapper <DTOUsuarios>{
public DTOUsuarios mapRow(ResultSet rs, int rowNum) throws SQLException{
DTOUsuarios usuario = new DTOUsuarios();
usuario.setNombre(rs.getString("Nombre"));
usuario.setPassword(rs.getString("Password"));
usuario.setEmail(rs.getString("Email"));
usuario.setDni(rs.getString("DNI"));
return usuario;
}
}