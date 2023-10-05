package springHibernate.api.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import springHibernate.api.dto.AtivoRequestDTO;
import springHibernate.api.dto.AtivoResponseDTO;
import springHibernate.api.entities.Ativo;
import springHibernate.api.entities.DetalheDoAtivo;
import springHibernate.api.messages.DetalheDoAtivoNaoEncontradoException;
import springHibernate.api.repository.AtivoRepository;
import springHibernate.api.repository.DetalheDoAtivoRepository;

import java.util.Optional;

@Service
public class AtivoService {
    private final AtivoRepository ativoRepository;
    private final DetalheDoAtivoRepository detalheDoAtivoRepository;

    @Autowired
    public AtivoService(AtivoRepository ativoRepository, DetalheDoAtivoRepository detalheDoAtivoRepository) {
        this.ativoRepository = ativoRepository;
        this.detalheDoAtivoRepository = detalheDoAtivoRepository;
    }

    public AtivoResponseDTO salvarAtivo(AtivoRequestDTO ativoRequestDTO) throws DetalheDoAtivoNaoEncontradoException {
        DetalheDoAtivo detalhe = new DetalheDoAtivo();
        detalhe.setTipo(ativoRequestDTO.getCategoria());
        detalhe.setCategoria(ativoRequestDTO.getTipo());
        detalhe.setSubtipo(ativoRequestDTO.getSubtipo());

        // Consulta o detalhe no banco de dados usando os três atributos como parâmetros
        Optional<DetalheDoAtivo> detalheOptional = detalheDoAtivoRepository
                .findByCategoriaAndTipoAndSubtipo(detalhe.getCategoria(), detalhe.getTipo(), detalhe.getSubtipo());

        if (detalheOptional.isPresent()) {
            detalhe = detalheOptional.get();
        } else {
            // Lida com o caso em que o detalhe não é encontrado
            throw new DetalheDoAtivoNaoEncontradoException("Detalhe do ativo não encontrado");
        }

        Ativo ativo = new Ativo();
        ativo.setNome(ativoRequestDTO.getNome());
        ativo.setUrl(ativoRequestDTO.getUrl());

        Ativo novoAtivo = ativoRepository.save(ativo);
        return new AtivoResponseDTO(novoAtivo.getId());
    }
}