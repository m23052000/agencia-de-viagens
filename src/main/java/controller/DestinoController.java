package controller;

import model.Destino;
import org.springframework.security.access.prepost.PreAuthorize;
import service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Destino> cadastrarDestino(@RequestBody Destino destino) {
        destinoService.salvar(destino);
        return ResponseEntity.ok(destino);
    }

    @GetMapping
    public List<Destino> listarDestinos() {
        return destinoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarDestinoPorId(@PathVariable Integer id) {
        Optional<Destino> destino = destinoService.buscarPorId(id);
        return destino.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Destino> pesquisarDestinos(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String localizacao) {
        return destinoService.pesquisarDestinos(nome, localizacao);
    }

    @PostMapping("/{id}/reservar")
    public ResponseEntity<String> reservarDestino(@PathVariable Integer id) {
        boolean reservado = destinoService.reservarDestino(id);
        if (reservado) {
            return ResponseEntity.ok("Reserva para o destino" + id + " realizada com sucesso.");
        }
        return ResponseEntity.status(400).body("Destino" + id + " não encontrado ou não disponível para reserva.");
    }

    @PatchMapping("/{id}/avaliacao")
    public ResponseEntity<Void> avaliarDestino(@PathVariable Integer id, @RequestParam int nota) {
        destinoService.avaliarDestino(id, nota);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> excluirDestino(@PathVariable Integer id) {
        Optional<Destino> destino = destinoService.buscarPorId(id);
        if (destino.isPresent()) {
            destinoService.excluir(destino.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}