package com.bd.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.bd.demo.modelo.ClassProducto;

public interface IProductoRepository  extends CrudRepository<ClassProducto,Integer>{

}//fin de la interface...
