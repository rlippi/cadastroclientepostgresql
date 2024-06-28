package br.com.exemplo.cadastroclientepostgresql.model;

import jakarta.persistence.*;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.GenericGenerator;

//import java.util.Objects;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
//@Getter
//@Setter
@Entity
@Table(name = "clientes")  // Define o nome da tabela no banco de dados
@Schema(description = "Entidade Cliente representando um cliente no sistema")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "ID único do cliente", example = "123e4567-e89b-12d3-a456-426614174000")
    //@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    @Schema(description = "Nome do cliente", example = "João da Silva")
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    @Schema(description = "E-mail do cliente", example = "joao.silva@example.com")
    private String email;

    @Column(name = "telefone", nullable = false)
    @Schema(description = "Telefone do cliente", example = "+5511999999999")
    private String telefone;

    @Column(name = "rua", nullable = false)
    @Schema(description = "Rua onde o cliente reside", example = "Rua Exemplo")
    private String rua;

    @Column(name = "numero", nullable = false)
    @Schema(description = "Número da residência do cliente", example = "123")
    private int numero;

    @Column(name = "cidade", nullable = false)
    @Schema(description = "Cidade onde o cliente reside", example = "São Paulo")
    private String cidade;

    @Column(name = "estado", nullable = false)
    @Schema(description = "Estado onde o cliente reside", example = "SP")
    private String estado;

    @Column(name = "cpf", nullable = false, unique = true)
    @Schema(description = "CPF do cliente (sem pontos ou traços)", example = "12345678901")
    private String cpf;

    @Column(name = "senha", nullable = false)
    @Schema(description = "Senha do cliente", example = "senha123")
    private String senha;

/*
    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // equals, hashCode, and toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(email, cliente.email) &&
                Objects.equals(telefone, cliente.telefone) &&
                Objects.equals(rua, cliente.rua) &&
                Objects.equals(numero, cliente.numero) &&
                Objects.equals(cidade, cliente.cidade) &&
                Objects.equals(estado, cliente.estado) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(senha, cliente.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, rua, numero, cidade, estado, cpf, senha);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
*/
}

