package com.br.portifolio.controller;
import com.br.portifolio.entity.Membro;
import com.br.portifolio.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;

public class MembroController {

    @Autowired
    MembroService membroService;
    @GetMapping("/{idMembro}")
    public ResponseEntity<Membro> findById(@PathVariable("idMembro") Long idMembro) {
        return ResponseEntity.ok().body(this.membroService.findById(idMembro));
    }

    @GetMapping
    public ResponseEntity<Page<Membro>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.membroService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Membro membro) {
        try {
            this.membroService.insert(membro);
            return ResponseEntity.ok().body("sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idMembro}")
    public ResponseEntity<?> update(@PathVariable Long idMembro, @RequestBody Membro membro) {
        try {
            this.membroService.update(idMembro, membro);
            return ResponseEntity.ok().body("sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }





}
