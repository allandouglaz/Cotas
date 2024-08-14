package com.inove.sorteioCotas.service;

import com.inove.sorteioCotas.models.Cotas;
import com.inove.sorteioCotas.models.User;
import com.inove.sorteioCotas.repository.CotasRepository;
import com.inove.sorteioCotas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CotaSorteioService {

    @Autowired
    private CotasRepository cotaSorteioRepository;

    @Autowired
    private UserRepository userRepository;

    /*
    public List<Cotas> gerarCotasClient(Long clienteId, int quantidade) {
        Client client = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Random random = new Random();
        List<Cotas> cotas = IntStream.range(0, quantidade)
                .mapToObj(i -> {
                    Cotas cota = new Cotas();
                    cota.setCotas(Long.parseLong(String.valueOf(random.nextInt(99999))));
                    cota.setClient(client);
                    return cota;
                })
                .collect(Collectors.toList());
        return cotaSorteioRepository.saveAll(cotas);
    }
     */

    public List<Cotas> gerarCotasClient(Long userId, int quantidade) {
        User user = userRepository.findById(String.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("Cliente Não encontrado."));

        Random random = new Random();
        List<Cotas> cotas = IntStream.range(0, quantidade)
                .mapToObj(i -> {
                    Cotas cota = new Cotas();
                    cota.setCotas(String.valueOf(Long.parseLong(String.valueOf(random.nextInt(99999)))));
                    return cota;
                })
                .collect(Collectors.toList());
        return cotaSorteioRepository.saveAll(cotas);
    }
}
