package integracao.bancodedados.contatos;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	//procurar
	Contato findFirstByNome(String nome);
	//procurar por nome, igno
	List<Contato> findAllByNomeIgnoreCaseContaining(String nome);
	
	//ordem alfabética
	@Query(value = "select c from  Contato c")
	List<Contato> buscaTodosContatosComOrdenacao(Sort sort);
	
	//ordem alfabética
	@Query(value = "select D from  Contato D")
	List<Contato> buscaTodosContatosComOrdenacao2(Sort sort);
	
	//ordem alfabética
	@Query(value = "select c from  Contato c order by nome")
	Stream<Contato> buscaTodosContatos();
}