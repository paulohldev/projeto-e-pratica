package ifpe.web3.br.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Denuncia {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_denuncia;
	
	private String assunto;
	private String ponto_ref;
	private String descricao;
	private Integer contador;
//	private Status status;
	@Lob
	private byte[] anexos;
	@ManyToOne
	private Usuario fk_usuario;
	@ManyToOne
	private Categorias fk_categoria;
	
	public Integer getId_denuncia() {
		return id_denuncia;
	}
	public void setId_denuncia(Integer id_denuncia) {
		this.id_denuncia = id_denuncia;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getPonto_ref() {
		return ponto_ref;
	}
	public void setPonto_ref(String ponto_ref) {
		this.ponto_ref = ponto_ref;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public byte[] getAnexo() {
		return anexos;
	}
	public void setAnexos(byte[] anexos) {
		this.anexos = anexos;
	}
	public Usuario getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(Usuario fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
	public byte[] getAnexos() {
		return anexos;
	}
	public Categorias getFk_categoria() {
		return fk_categoria;
	}
	public void setFk_categoria(Categorias fk_categoria) {
		this.fk_categoria = fk_categoria;
	}
	
	
	
}
