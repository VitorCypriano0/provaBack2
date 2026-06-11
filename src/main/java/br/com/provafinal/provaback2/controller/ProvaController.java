package br.com.provafinal.provaback2.controller;

import br.com.provafinal.provaback2.model.Prova;
import br.com.provafinal.provaback2.service.ProvaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prova")
@CrossOrigin(origins = "*")
public class ProvaController {

    private final ProvaService provaService;

    public ProvaController(ProvaService provaService) {
        this.provaService = provaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Prova>> listar(@RequestParam(required = false) String titulo) {
        return ResponseEntity.ok(provaService.listar(titulo));
    }

    @PostMapping("/criar")
    public ResponseEntity<Prova> criar(@Valid @RequestBody Prova prova) {
        return ResponseEntity.status(HttpStatus.CREATED).body(provaService.criar(prova));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Prova> atualizar(@Valid @RequestBody Prova prova) {
        return ResponseEntity.ok(provaService.atualizar(prova));
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletar(@RequestParam Long id) {
        provaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

