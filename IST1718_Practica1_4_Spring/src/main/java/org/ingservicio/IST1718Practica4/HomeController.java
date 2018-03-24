package org.ingservicio.IST1718Practica4;


import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//Al marcarlo con @Autowired, se inyectará, como una instancia de dao, 
	//un bean de una clase que implemente el interfaz DAOUsuariosInterfaz
	@Autowired
	private DAOUsuariosInterfaz dao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/Servlet1", method = {RequestMethod.GET,RequestMethod.POST})
	public String servlet1 (HttpServletRequest request, Model model) {
		String usuario = request.getParameter("username");
		String pass = request.getParameter("pass");
		//url a asignar dependiendo de si es administrador o no.
		String url="";
		List <DTOUsuarios> lista = dao.leeUsuarios();
		//Posicion para recorrer la lista
		int posicion=0;
		for(posicion=0;posicion<lista.size();posicion++) {
			if(lista.get(posicion).getNombre().equals(usuario) && usuario.equals("Admin")
					&& lista.get(posicion).getPassword().equals(pass)) {
				//En Spring se utiliza model.addAttribute en vez de req.setAttribute para 
				//agregar el atributo proporcionado bajo el nombre proporcionado.
				model.addAttribute("nombre", lista.get(posicion).getNombre());
				model.addAttribute("password", lista.get(posicion).getPassword());
				model.addAttribute("email", lista.get(posicion).getEmail());
				model.addAttribute("dni", lista.get(posicion).getDni());
				url="usuario";
			}else if(lista.get(posicion).getNombre().equals(usuario) && !usuario.equals("Admin")
			&& lista.get(posicion).getPassword().equals(pass))  {
				model.addAttribute("nombre", lista.get(posicion).getNombre());
				model.addAttribute("password", lista.get(posicion).getPassword());
				model.addAttribute("email", lista.get(posicion).getEmail());
				model.addAttribute("dni", lista.get(posicion).getDni());
				url="usuariodatos";
			}
			
		}
		
		
		//Significa que el usuario no existe
		if(!url.equals("usuario") && !url.equals("usuariodatos")) {
			url="registro";
		}
		
		model.addAttribute("lista", lista);

		return url;
	}
	
	
	@RequestMapping(value = "/Servlet2", method = {RequestMethod.GET,RequestMethod.POST})
	public String servlet2 (HttpServletRequest request, Model model) {

		//Parameter(...) es del html
				String usuario = request.getParameter("username");
				//Lo añadimos al model
				model.addAttribute("Nombre", usuario);
				
				String password = request.getParameter("pass");
				//Lo añadimos al model
				model.addAttribute("Password", password);
				
				String email = request.getParameter("email");
				//Lo añadimos al model
				model.addAttribute("Email", email);	
				
				String dni = request.getParameter("dni");
				//Lo añadimos al model
				model.addAttribute("DNI", dni);
				
			
				List <DTOUsuarios> lista = dao.leeUsuarios();
				
				boolean variable=false;
				String url="";
				for(int pos=0;pos<lista.size();pos++) {
					if(lista.get(pos).getDni().equals(dni) && lista.get(pos).getEmail().equals(email) && 
							lista.get(pos).getNombre().equals(usuario)) {
						url="usuarioYaRegistrado";
						variable=true;
					
					}
				}
				if(variable==false) {
					boolean variable2=false;
					for(int pos=0;pos<lista.size();pos++) {
						if(lista.get(pos).getDni().equals(dni)) {
						url="usuarioYaRegistrado";
					variable2=true;
						}
					}
					if(variable2==false) {
						dao.addUsuario(usuario, password, email, dni);
						url="usuarioRegistrado";
					}
				}
				return url;
	}
	
	
}
