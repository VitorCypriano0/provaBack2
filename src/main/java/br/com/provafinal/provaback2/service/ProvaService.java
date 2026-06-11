package br.com.provafinal.provaback2.service;

import br.com.provafinal.provaback2.model.Prova;
import br.com.provafinal.provaback2.repository.ProvaRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProvaService {

    private final ProvaRepository provaRepository;

    public ProvaService(ProvaRepository provaRepository) {
        this.provaRepository = provaRepository;
    }

    public List<Prova> listar(String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            return provaRepository.findByTituloContainingIgnoreCase(titulo.trim());
        }

        return provaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Prova criar(Prova prova) {
        prova.setId(null);
        return provaRepository.save(prova);
    }

    public Prova atualizar(Prova prova) {
        if (prova.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id e obrigatorio para atualizar");
        }

        Prova provaSalva = buscarPorId(prova.getId());
        provaSalva.setTitulo(prova.getTitulo());
        provaSalva.setMateria(prova.getMateria());
        provaSalva.setData(prova.getData());

        return provaRepository.save(provaSalva);
    }

    public void deletar(Long id) {
        Prova prova = buscarPorId(id);
        provaRepository.delete(prova);
    }

    private Prova buscarPorId(Long id) {
        return provaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prova nao encontrada"));
    }
}

