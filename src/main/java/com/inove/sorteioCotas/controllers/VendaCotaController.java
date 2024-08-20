package com.inove.sorteioCotas.controllers;

import com.inove.sorteioCotas.models.Cotas;
import com.inove.sorteioCotas.models.VendaCota;
import com.inove.sorteioCotas.repository.VendaCotaRepository;
import com.inove.sorteioCotas.service.CotaSorteioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venda-cotas")
public class VendaCotaController {

    private final CotaSorteioService cotaSorteioService;
    private final VendaCotaRepository vendaCotaRepository;

    @Autowired
    public VendaCotaController(CotaSorteioService cotaSorteioService, VendaCotaRepository vendaCotaRepository) {
        this.cotaSorteioService = cotaSorteioService;
        this.vendaCotaRepository = vendaCotaRepository;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<VendaCota>> findAll(Pageable pageable) {
        Page<VendaCota> result = vendaCotaRepository.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<VendaCota> findById(@PathVariable Long id) {
        Optional<VendaCota> vendaCota = vendaCotaRepository.findById(id);
        return vendaCota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VendaCota> create(@RequestBody VendaCota vendaCota) {
        VendaCota savedVendaCota = vendaCotaRepository.save(vendaCota);
        return ResponseEntity.ok(savedVendaCota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaCota> update(@PathVariable Long id, @RequestBody VendaCota vendaCota) {
        if (!vendaCotaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vendaCota.setId(id);
        VendaCota updatedVendaCota = vendaCotaRepository.save(vendaCota);
        return ResponseEntity.ok(updatedVendaCota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!vendaCotaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vendaCotaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/gerarCotas")
    public ResponseEntity<List<Cotas>> gerarCotas(@RequestParam Long userId, @RequestParam int qtde) {
        if (qtde <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Cotas> cotas = cotaSorteioService.gerarCotasClient(userId, qtde);
        return ResponseEntity.ok(cotas);
    }
}
