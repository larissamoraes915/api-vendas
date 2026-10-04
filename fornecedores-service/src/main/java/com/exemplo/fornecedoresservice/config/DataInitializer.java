package com.exemplo.fornecedoresservice.config;

import com.exemplo.fornecedoresservice.model.Fornecedor;
import com.exemplo.fornecedoresservice.repository.FornecedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final FornecedorRepository fornecedorRepository;

    public DataInitializer(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public void run(String... args) {
        fornecedorRepository.save(new Fornecedor("Distribuidora Alvorada", "contato@alvorada.com"));
        fornecedorRepository.save(new Fornecedor("Tech Peças Brasil", "vendas@techpecas.com"));
        fornecedorRepository.save(new Fornecedor("Logística Global Express", "comercial@globalexpress.com"));
        fornecedorRepository.save(new Fornecedor("Papelaria Central Atacado", "atendimento@papelariacentral.com"));
        fornecedorRepository.save(new Fornecedor("Insumos Industriais Norte", "norte@insumosindustriais.com"));
    }
}