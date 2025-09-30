package cl.ucn.comercio.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class ProveedorPCFactory {

	
List<Producto> listaProducto;
	
	
	public List<Producto> getPCFactoryCelularAnho(int anho){

        return this.listaProducto.stream().filter(p -> p.getAnho() == anho).collect(Collectors.toList());
    }
	
}
