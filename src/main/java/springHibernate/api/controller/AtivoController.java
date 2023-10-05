package springHibernate.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springHibernate.api.dto.AtivoRequestDTO;
import springHibernate.api.dto.AtivoResponseDTO;
import springHibernate.api.entities.Ativo;
import springHibernate.api.messages.DetalheDoAtivoNaoEncontradoException;
import springHibernate.api.service.AtivoService;


@RestController
@RequestMapping("/ativos")
@Api(tags = "Ativos", description = "Operações relacionadas a Ativos")
public class AtivoController {
    private final AtivoService ativoService;

    @Autowired
    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo Ativo")
    public ResponseEntity<AtivoResponseDTO> criarAtivo(@Valid @RequestBody AtivoRequestDTO ativoRequestDTO) throws DetalheDoAtivoNaoEncontradoException {
        AtivoResponseDTO novoAtivo = ativoService.salvarAtivo(ativoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAtivo);
    }
}

