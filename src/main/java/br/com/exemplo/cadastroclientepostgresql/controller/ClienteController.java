package br.com.exemplo.cadastroclientepostgresql.controller;

import br.com.exemplo.cadastroclientepostgresql.model.Cliente;
import br.com.exemplo.cadastroclientepostgresql.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Endpoints para gerenciamento de clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    
    //CRIAR CLIENTE
    @Operation(summary = "Criar um novo cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
       
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(
    		@Parameter(description = "Detalhes do novo cliente", required = true) //swagger
    		@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

        
    //LISTAR CLIENTES
    @Operation(summary = "Listar todos os clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso")
    })
    
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
    
    
    //OBTER CLIENTE POR ID
    @Operation(summary = "Obter um cliente por ID")
    @ApiResponses(value = {
    	@ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
        @ApiResponse(responseCode = "200", description = "Cliente retornado com sucesso")
        
    })
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterClientePorId(
    		@Parameter(description = "ID do cliente a ser obtido", required = true) //swagger
    		@PathVariable UUID id) {
        Cliente cliente = clienteService.obterClientePorId(id).orElse(null);
        return cliente != null ? new ResponseEntity<>(cliente, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    //ATUALIZAR CLIENTE
    @Operation(summary = "Atualizar um cliente existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(
    		@Parameter(description = "ID do cliente que será atualizado", required = true)
    		@PathVariable UUID id,
    		@Parameter(description = "Detalhes atualizados do cliente", required = true)
    		@RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.atualizarCliente(id, clienteAtualizado);
        return cliente != null ? new ResponseEntity<>(cliente, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    
    //DELETAR CLIENTE
    @Operation(summary = "Deletar um cliente por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(
    		@Parameter(description = "ID do cliente a ser deletado", required = true)
    		@PathVariable UUID id) {
        boolean deletado = clienteService.deletarCliente(id);
        return deletado ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

