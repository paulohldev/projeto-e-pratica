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
import jakarta.servlet.http.HttpSession;

@Controller
public class DenunciaController {
	
	@Autowired
	public DenunciaDAO denunciaDAO;	
	
	@Autowired
	public EnderecoDAO enderecoDAO;
	
	@Autowired 
	public CategoriaDAO categoriaDAO;
	
	@Autowired
	public UsuarioDAO usuarioDAO;
	
	@GetMapping("/denunciar")
	public String denunciar(Denuncia denuncia, Model model) {
		model.addAttribute("categorias", categoriaDAO.findAll());	
		return "denunciar";
	}		
	
	@PostMapping("/salvarDenuncia")
	public String salvarDenuncia(Denuncia denuncia, HttpSession session) {
		
//		if(session.getAttribute("tipo").equals("usuario")) {
//			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
//			denuncia.setUsuario(usuario);
//		}
//		session.get	
		
		denunciaDAO.save(denuncia);
		return "redirect:/denunciar";
	}
	
	@GetMapping("/denuncias")
	public String denuncias(Model model, Denuncia denuncia, Categorias categoria) {
		model.addAttribute("denuncia", denuncia);
		model.addAttribute("categoria", categoria);
		model.addAttribute("denuncias", this.denunciaDAO.listarDenuncias());
		return "visualizar";
	}

}
