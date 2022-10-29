package br.com.uniamerica.transportadora.controller;
import br.com.uniamerica.transportadora.Entity.*;
import br.com.uniamerica.transportadora.repository.FreteRepository;
import br.com.uniamerica.transportadora.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping
public class FreteController {

    @Autowired
    private FreteRepository freteRepository;
    @Autowired
    private FreteService freteService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Produto produto, Cidade cidadeOrigem, Cidade cidadeDestino, Usuario motorista, Caminhao caminhao,
                                       StatusFrete statusfrete, Integer quilometragemIni, Integer quilometragemFim, BigDecimal totalBrutoRecebidoNota, BigDecimal totalLiquidoRecebido,
                                       BigDecimal pesoInicial, BigDecimal pesoFinal, BigDecimal pesoFinalTransportadora, BigDecimal precoTonelada, String observacao){
        this.freteRepository.save(produto);
        this.freteRepository.save(cidadeDestino);
        this.freteRepository.save(cidadeOrigem);
        this.freteRepository.save(motorista);
        this.freteRepository.save(caminhao);
        this.freteRepository.save(statusfrete);
        this.freteRepository.save(quilometragemIni);
        this.freteRepository.save(quilometragemFim);
        this.freteRepository.save(totalBrutoRecebidoNota);
        this.freteRepository.save(observacao);
        this.freteRepository.save(totalLiquidoRecebido);
        this.freteRepository.save(pesoFinal);
        this.freteRepository.save(pesoFinalTransportadora);
        this.freteRepository.save(pesoInicial);
        this.freteRepository.save(precoTonelada);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PostMapping("/SetCarga")
    public ResponseEntity<?> setCarga
            (@RequestBody final StatusFrete statusFrete
    ){
        this.freteRepository.save(statusFrete);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }
}
