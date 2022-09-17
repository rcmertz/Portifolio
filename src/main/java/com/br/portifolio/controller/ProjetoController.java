package com.br.portifolio.controller;
import com.br.portifolio.entity.Projeto;
import com.br.portifolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;

    @Controller
    @CrossOrigin
    @RequestMapping("/api/projetos")
    public class ProjetoController {

        @Autowired
        ProjetoService projetoService;
        @GetMapping("/{idProjeto}")
        public ResponseEntity<Projeto> findById(@PathVariable("idProjeto") Long idProjeto) {
            return ResponseEntity.ok().body(this.projetoService.findById(idProjeto));
        }

        @GetMapping
        public ResponseEntity<Page<Projeto>> listByAllPage(Pageable pageable) {
            return ResponseEntity.ok().body(this.projetoService.listAll(pageable));
        }

        @PostMapping
        public ResponseEntity<?> insert(@RequestBody Projeto projeto) {
            try {
                this.projetoService.insert(projeto);
                return ResponseEntity.ok().body("Projeto cadastrado com sucesso.");
            }catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PutMapping("/{idProjeto}")
        public ResponseEntity<?> update(@PathVariable Long idProjeto, @RequestBody Projeto projeto) {
            try {
                this.projetoService.update(idProjeto, projeto);
                return ResponseEntity.ok().body("Projeto atualizado com sucesso.");
            }catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }
