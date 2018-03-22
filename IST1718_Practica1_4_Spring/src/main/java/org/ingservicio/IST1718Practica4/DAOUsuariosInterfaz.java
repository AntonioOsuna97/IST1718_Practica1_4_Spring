package org.ingservicio.IST1718Practica4;

import java.util.List;


public interface DAOUsuariosInterfaz {

	public List<DTOUsuarios> leeUsuarios();
	
	public boolean buscaUsuario(String nombre, String password);

	public void addUsuario(String nombre, String password, String email, String dni);
	
}
