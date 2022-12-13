package ifpe.web3.br.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DenunciaDAO extends JpaRepository<Denuncia, Integer> {
	
	@Query("SELECT d FROM Denuncia d")
	public List<Denuncia> listarDenuncias();

}
