package ifpe.web3.br.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorias {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	private String[] categoria;
	
	public Integer getId_categoria() {
		return id_categoria;
	}
	
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	public String[] getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String[] categoria) {
		this.categoria = categoria;
	}
	
	

}
