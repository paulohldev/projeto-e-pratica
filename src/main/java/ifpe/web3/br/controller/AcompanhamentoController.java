package ifpe.web3.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class AcompanhamentoController {

	@GetMapping("/acom")
	
	public String acom() {
		
		return "acompanhamento";
		
	}
	
	
	
		
		@GetMapping("/protocolo")
		
		public String protocolo() {
			
			return "protocolo";
			
		}
		
		
@GetMapping("/novaBusca")
		
		public String novaBusca() {
			
			return "acompanhamento";
			
		}
	
	
	
	
}
