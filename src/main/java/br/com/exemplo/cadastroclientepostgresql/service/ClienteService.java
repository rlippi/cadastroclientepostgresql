package br.com.exemplo.cadastroclientepostgresql.service;

import br.com.exemplo.cadastroclientepostgresql.model.Cliente;
import br.com.exemplo.cadastroclientepostgresql.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Método para obter um cliente por ID
    public Optional<Cliente> obterClientePorId(UUID id) {
        return clienteRepository.findById(id);
    }

    // Método para salvar um novo cliente
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para atualizar um cliente existente
    public Cliente atualizarCliente(UUID id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setRua(clienteAtualizado.getRua());
            cliente.setNumero(clienteAtualizado.getNumero());
            cliente.setCidade(clienteAtualizado.getCidade());
            cliente.setEstado(clienteAtualizado.getEstado());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setSenha(clienteAtualizado.getSenha());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
    }

    // Método para deletar um cliente por ID
    public boolean deletarCliente(UUID id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

