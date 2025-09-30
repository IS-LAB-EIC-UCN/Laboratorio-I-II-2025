package cl.ucn.comercio.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class ProveedorAfel {

	List<Producto> listaProducto;
	
	
	public List<Producto> getAfelCelularTamanho(int tamanho){

        return this.listaProducto.stream().filter(p -> p.getTamanho() == tamanho).collect(Collectors.toList());
    }
	
}
