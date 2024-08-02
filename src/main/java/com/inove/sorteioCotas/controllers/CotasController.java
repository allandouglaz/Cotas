package com.inove.sorteioCotas.controllers;


import com.inove.sorteioCotas.models.Cotas;
import com.inove.sorteioCotas.models.User;
import com.inove.sorteioCotas.repository.CotasRepository;
import com.inove.sorteioCotas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cotas")
public class CotasController {

            @Autowired
            private CotasRepository cotasRepository;

            @Autowired
            private UserRepository userRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public Page<Cotas> findAll(Pageable pageable) {
        return cotasRepository.findAll(pageable);
    }




}
