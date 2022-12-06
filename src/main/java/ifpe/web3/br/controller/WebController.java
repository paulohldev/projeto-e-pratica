package ifpe.web3.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ifpe.web3.br.model.Denuncia;
import ifpe.web3.br.model.DenunciaDAO;
import ifpe.web3.br.model.Endereco;
import ifpe.web3.br.model.EnderecoDAO;

@Controller
public class WebController {
	
	@Autowired
	public DenunciaDAO denunciaDAO;
	
	@Autowired
	public EnderecoDAO enderecoDAO;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/denunciar")
	public String denunciar() {
		return "denunciar";
	}
	
	@PostMapping("/salvarDenuncia")
	public String salvarDenuncia(Endereco endereco, Denuncia denuncia) {
		enderecoDAO.save(endereco);
		denunciaDAO.save(denuncia);
		return "index";
	}

	@GetMapping("/denuncias")
	public String denuncias() {
		return "visualizar";
	}
	
	@GetMapping("/usuario")
	public String usuario() {
		return "usuario";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
}
