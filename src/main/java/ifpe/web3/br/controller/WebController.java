package ifpe.web3.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ifpe.web3.br.model.CategoriaDAO;
import ifpe.web3.br.model.Categorias;
import ifpe.web3.br.model.Denuncia;
import ifpe.web3.br.model.DenunciaDAO;
import ifpe.web3.br.model.Endereco;
import ifpe.web3.br.model.EnderecoDAO;
import ifpe.web3.br.model.Usuario;
import ifpe.web3.br.model.UsuarioDAO;

@Controller
public class WebController {
	
	@Autowired
	public DenunciaDAO denunciaDAO;
	
	@Autowired
	public EnderecoDAO enderecoDAO;
	
	@Autowired 
	public CategoriaDAO categoriaDAO;

	@Autowired
	public UsuarioDAO usuarioDAO;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/denunciar")
	public String denunciar() {
		return "denunciar";
	}
		
	@PostMapping("/salvarDenuncia")
	public String salvarDenuncia(Endereco endereco, Denuncia denuncia, Categorias categoria) {
		categoriaDAO.save(categoria);
		enderecoDAO.save(endereco);
		denunciaDAO.save(denuncia);
		return "index";
	}
	
	@GetMapping("/denuncias")
	public String denuncias(Model model) {
		model.addAttribute("denuncias", denunciaDAO.listarDenuncias());
		return "visualizar";
	}
	
	@GetMapping("/usuario")
	public String usuario() {
		return "usuario";
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario) {
		usuarioDAO.save(usuario);
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@PostMapping("/efetuarLogin")
	 public String efetuarLogin( String email, String senha) {
		
	Usuario usuario = this.usuarioDAO.findByEmailAndSenha(email, senha);
	System.out.println();
		if(usuario != null) {
			return"redirect:/";
			
		}else {
			return"redirect:/login";
		}
	}
	
	
}
