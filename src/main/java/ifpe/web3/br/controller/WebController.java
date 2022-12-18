package ifpe.web3.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ifpe.web3.br.model.CategoriaDAO;
import ifpe.web3.br.model.Categorias;
import ifpe.web3.br.model.Denuncia;
import ifpe.web3.br.model.DenunciaDAO;
import ifpe.web3.br.model.Endereco;
import ifpe.web3.br.model.EnderecoDAO;
import ifpe.web3.br.model.Usuario;
import ifpe.web3.br.model.UsuarioDAO;
import jakarta.servlet.http.HttpSession;

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
		return "denunciar";
	}
	
	@GetMapping("/denuncias")
	public String denuncias(Model model) {
		model.addAttribute("denuncias", this.denunciaDAO.listarDenuncias());
		return "visualizar";
	}
	
	@GetMapping("/usuario")
	public String usuario() {
		return "usuario";
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario) {
		usuarioDAO.save(usuario);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Usuario usuario) {		
		return "login";
	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@PostMapping("/auth")
	 public String efetuarLogin(Usuario usuario, RedirectAttributes ra, HttpSession session) {
		
		usuario = this.usuarioDAO.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(usuario != null) {
			session.setMaxInactiveInterval(-1);
			session.setAttribute("usuarioLogado", usuario);
			ra.addFlashAttribute("sessionUser", usuario);
			return "redirect:/";
		}	else {
			ra.addFlashAttribute("naoAutorizado", "Dados incorretos ou não existe");
			return"redirect:/login";
		}	
		
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
