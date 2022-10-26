package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void atualizar(final Long id, final Produto nome){
        if(id.equals(nome.getId()) && !this.produtoRepository.findById(id).isEmpty()){
            this.produtoRepository.save(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Produto nome){
        if (id.equals(nome.getId()) && !this.produtoRepository.findById(id).isEmpty()){
            this.produtoRepository.delete(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}
