package cl.ucn.comercio.adapter;

import java.util.List;

import cl.ucn.comercio.modelo.Producto;

public interface Adaptador {

	List<Producto> getCelulares(String marca, int anho, int pulgadas);
}
