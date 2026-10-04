package com.exemplo.fornecedoresservice.controller;

import com.exemplo.fornecedoresservice.client.ProdutoClient;
import com.exemplo.fornecedoresservice.dto.ProdutoDTO;
import com.exemplo.fornecedoresservice.model.Fornecedor;
import com.exemplo.fornecedoresservice.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;
    private final ProdutoClient produtoClient;

    public FornecedorController(FornecedorService fornecedorService, ProdutoClient produtoClient) {
        this.fornecedorService = fornecedorService;
        this.produtoClient = produtoClient;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor criar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvar(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return fornecedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

@GetMapping("/produtos")
public List<ProdutoDTO> listarProdutosDoOutroServico() {
    return produtoClient.listarProdutos();
}
}