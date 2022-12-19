package ifpe.web3.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ifpe.web3.br.model.Usuario;
import ifpe.web3.br.model.UsuarioDAO;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {
	
	@Autowired
	public UsuarioDAO usuarioDAO;
	
	@GetMapping("/usuario")
	public String usuario() {
		return "usuario";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}	
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario) {
		usuarioDAO.save(usuario);
		return "redirect:/login";
	}
	
	@RequestMapping("/auth")
	 public String efetuarLogin(Usuario usuario, RedirectAttributes ra, HttpSession session) {
		usuario = this.usuarioDAO.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(usuario != null) {
			session.setAttribute("usuarioLogado", usuario);
			session.setAttribute("tipo", "usuario");
			return "redirect:/denunciar";
		}	else {
			ra.addFlashAttribute("naoAutorizado", "Dados incorretos ou não existe");
			return"redirect:/";
		}		
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
