package com.bd.demo.servicio;

import java.util.List;

import com.bd.demo.modelo.ClassProducto;

public interface IProductoServicio {
	//declaramos los metodos...
	public List<ClassProducto> ListadoProductos();
	public void RegistrarProducto(ClassProducto clproducto);
	public ClassProducto BuscarporId(Integer id);
	public void EliminarProducto(Integer id);
	

}//fin de la interface...
