package ifpe.web3.br.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ifpe.web3.br.model.CategoriaDAO;
import ifpe.web3.br.model.Categorias;
import ifpe.web3.br.model.Denuncia;
import ifpe.web3.br.model.DenunciaDAO;
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
	public String denunciar(Model model, Denuncia denuncia) {
		model.addAttribute("categorias", categoriaDAO.findAll());	
		return "denunciar";
	}		
	
	@PostMapping("/salvarDenuncia")
	public String salvarDenuncia(Denuncia denuncia, HttpSession session) {

		 if (session.getAttribute("tipo") != null && session.getAttribute("tipo").equals("usuario")) {
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			
			Random ale = denuncia.numeroDenuncia();
			denuncia.setProtocolo(ale.nextInt(10000000));
			denuncia.setUsuario(usuario);
			System.out.println(denuncia.getProtocolo());
					
					
					
			denuncia.setUsuario(usuario);
			denunciaDAO.save(denuncia);
		} else {
			denunciaDAO.save(denuncia);
		}
		 
		 return "redirect:/denunciar";
	}
	
	@GetMapping("/denuncias")
	public String denuncias(Model model, Denuncia denuncia, Categorias categoria) {
		model.addAttribute("denuncia", denuncia);
		model.addAttribute("categoria", categoria);
		model.addAttribute("denuncias", this.denunciaDAO.listarDenuncias());
		return "visualizar";
	}
	@GetMapping("/minhasDenuncias")
	public String minhasDenuncias(HttpSession session,Model model, Denuncia denuncia, Categorias categoria) {
	Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("denuncia", denuncia);
		model.addAttribute("categoria", categoria);
		model.addAttribute("denuncias", this.denunciaDAO.listarDenunciasMi(usuario.getId_usuario()));
		return "visualizarMinhas";
	}
	
	@GetMapping("/removerDenuncia")
	public String removerDenuncia(Integer codigo) {
		denunciaDAO.deleteById(codigo);
		return "redirect:/visualizarMinhas";
	}

}
