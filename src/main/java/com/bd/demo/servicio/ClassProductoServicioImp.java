package com.bd.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.demo.modelo.ClassProducto;
import com.bd.demo.repositorio.IProductoRepository;

@Service
public class ClassProductoServicioImp implements IProductoServicio {

	//aplicamos la inyeccion de dependencia..
	@Autowired
	private IProductoRepository prorepo;
	
	
	@Override
	public List<ClassProducto> ListadoProductos() {
		// invocamos el metodo listado
		return (List<ClassProducto>) prorepo.findAll();
	}//fin del metodo listado

	@Override
	public void RegistrarProducto(ClassProducto clproducto) {
		// invocamos el metodo registrar
		prorepo.save(clproducto);
	} //fin del metodo registrar producto..

	@Override
	public ClassProducto BuscarporId(Integer id) {
		// invocamos el metodo buscar
		return prorepo.findById(id).orElse(null);
	}  //fin del metodo buscar producto...

	@Override
	public void EliminarProducto(Integer id) {
		prorepo.deleteById(id);
		
	} //fin del metodo eliminar....

}  //fin de la clase .....
