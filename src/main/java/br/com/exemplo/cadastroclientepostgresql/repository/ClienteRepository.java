package br.com.exemplo.cadastroclientepostgresql.repository;

import br.com.exemplo.cadastroclientepostgresql.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    // Métodos de consulta adicionais podem ser definidos aqui, se necessário
}

