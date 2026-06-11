package br.com.provafinal.provaback2.repository;

import br.com.provafinal.provaback2.model.Prova;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    List<Prova> findByTituloContainingIgnoreCase(String titulo);
}

