package com.bd.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bd.demo.modelo.ClassProducto;
import com.bd.demo.servicio.IProductoServicio;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;


@Controller
@RequestMapping("/Vistas")
public class ControllerProducto {

	//inyeccion de dependencia
	@Autowired
	private IProductoServicio proser;
	
	
	//creamos el metodo listado
	@GetMapping("ListadoProducto")
	public String ListadoProducto(Model modelo) {
		List<ClassProducto> listado=proser.ListadoProductos();
		modelo.addAttribute("listado",listado);
		return "/Vistas/ListadoProductos";
	}//fin del metodo listado
	
	
	//creamos el metodo para registrar
	@GetMapping("/RegistrarProducto")
	public String RegistrarProducto(Model modelo) {
		//realizamos las respectiva instancia
		ClassProducto pro=new ClassProducto();
		//enviamos hacia la vista
		modelo.addAttribute("regpro", pro);
		//retoenamos
		return "/Vistas/FrmRegisProducto";
	}//fin del metodod registrar

	
	//realizamos el mapeo con postMapping
	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute ClassProducto pro, Model modelo) {
		proser.RegistrarProducto(pro);
		System.out.println("Dato registrado en la bd");
		//retoenamos
		return "redirect:/Vistas/ListadoProducto";
	}
	
	
	
	//creamos el metodo editar
	@GetMapping("/editarProducto/{id}")
	public String editarP(@PathVariable("id") Integer ipro, Model modelo) {
		ClassProducto pro=proser.BuscarporId(ipro);
		//ENVIAMOS HACIA LA VISTA
		modelo.addAttribute("regproduc", pro);
		return "/Vistas/FrmRegisProducto";
	}//fin del metodo editar
	
	
	
	//creamos el metodo eliminar
	@GetMapping("/EliminarProducto/{id}")
	public String eliminarP(@PathVariable("id") Integer ipro, Model modelo) {
		proser.EliminarProducto(ipro);
		//actualizamos el listado
		List<ClassProducto> listado=proser.ListadoProductos();
		//enviamos a la vista
		modelo.addAttribute("listado", listado);
		//redireccionamos
		return "redirect:/Vistas/ListadoProductos";
	}//fin del metodo eliminar
	

	
	
	
	
}//fin de la clase....
