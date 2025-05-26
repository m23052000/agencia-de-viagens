package service;

import model.Destino;
import repository.DestinoRepository;
import service.base.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinoService extends AbstractBaseService<Destino> {

    @Autowired
    private DestinoRepository destinoRepository;

    public void avaliarDestino(Integer id, int nota) {
        Optional<Destino> destino = destinoRepository.buscarPorId(id);
        destino.ifPresent(d -> {
            double novaMedia = ((d.getMediaAvaliacoes() * d.getQuantidadeAvaliacoes()) + nota) / (d.getQuantidadeAvaliacoes() + 1);
            d.setQuantidadeAvaliacoes(d.getQuantidadeAvaliacoes() + 1);
            d.setMediaAvaliacoes(novaMedia);
            destinoRepository.salvar(d);
        });
    }

    public List<Destino> pesquisarDestinos(String nome, String localizacao) {
        return destinoRepository.pesquisarPorNomeOuLocalizacao(nome, localizacao);
    }

    public boolean reservarDestino(Integer id) {
        Optional<Destino> destino = destinoRepository.buscarPorId(id);
        if (destino.isPresent()) {
            // Aqui você poderia adicionar lógica de reserva, como verificar disponibilidade
            return true;
        }
        return false;
    }
}
