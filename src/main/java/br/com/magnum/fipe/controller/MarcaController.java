package br.com.magnum.fipe.controller;

import br.com.magnum.fipe.dto.AtualizacaoModeloDto;
import br.com.magnum.fipe.dto.MarcaDto;
import br.com.magnum.fipe.dto.ModeloDto;
import br.com.magnum.fipe.excpetion.ValidacaoException;
import br.com.magnum.fipe.repository.ModeloRepository;
import br.com.magnum.fipe.service.MarcaService;
import br.com.magnum.fipe.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService service;
    @Autowired
    private ModeloService modeloService;
    @GetMapping("marcas-fipe")
    public ResponseEntity buscarMarcasFipe() {
        try {
            service.buscarMarcasFipe();
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<MarcaDto>> listar() {
        try {
            List<MarcaDto> marcas = service.listar();
            return ResponseEntity.ok(marcas);
        } catch (ValidacaoException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("listar-modelos-observacoes/{marca}")
    public ResponseEntity<List<ModeloDto>> listarModeloEObservacoes(@PathVariable String marca) {
        try {
            List<ModeloDto> modelos = modeloService.listarModeloEObservacoes(marca);
            return ResponseEntity.ok(modelos);
        } catch (ValidacaoException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizacaoModeloDto dto) {
        try {
            modeloService.atualizar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
