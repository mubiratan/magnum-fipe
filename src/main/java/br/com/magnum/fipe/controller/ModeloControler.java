package br.com.magnum.fipe.controller;

import br.com.magnum.fipe.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modelos")
public class ModeloControler {
    @Autowired
    private ModeloService service;
    @GetMapping("{tipo}/{marca}")
    public ResponseEntity buscarESalvarModelos(@PathVariable String tipo, @PathVariable String marca) {
        service.buscarESalvarModelos(tipo, marca);
        return ResponseEntity.ok().build();
    }
}
