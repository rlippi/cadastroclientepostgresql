# Cadastro de Clientes com Spring Boot e PostgreSQL

Este é um projeto de exemplo para um sistema de cadastro de clientes utilizando Spring Boot e PostgreSQL. O sistema permite a criação, leitura, atualização e remoção de clientes. A documentação da API é gerada automaticamente com Swagger.

## **Sumário**

- [Requisitos](#requisitos)
- [Configuração do Banco de Dados](#configuração-do-banco-de-dados)
- [Configuração do Projeto](#configuração-do-projeto)
- [Como Executar](#como-executar)
- [Funcionalidades](#funcionalidades)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Documentação da API](#documentação-da-api)
- [Contribuição](#contribuição)

## **Requisitos**

- Java 11+
- Maven 3.6+
- PostgreSQL 12+

## **Configuração do Banco de Dados**

1. **Instale o PostgreSQL** se ainda não estiver instalado.

2. **Crie o Banco de Dados**:
   - Utilize um cliente SQL ou a linha de comando para criar o banco de dados:
     ```sql
     CREATE DATABASE JavaTestCadastroCliente;
     ```

3. **Crie um Usuário e Conceda Permissões** (opcional):
   ```sql
   CREATE USER seu-usuario WITH PASSWORD 'sua-senha';
   GRANT ALL PRIVILEGES ON DATABASE JavaTestCadastroCliente TO seu-usuario;

4.**Crie a tabela Clientes:**
```sql
CREATE TABLE clientes (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(20),
    rua VARCHAR(255),
    numero INTEGER,
    cidade VARCHAR(255),
    estado VARCHAR(2),
    cpf VARCHAR(11),
    senha VARCHAR(255)
);
```
5. **Configure o application.properties com as credenciais do banco de dados.**



# Configuração do Projeto

1. **Clone o Repositório:**

git clone https://github.com/seu-usuario/cadastroclientepostgresql.git
cd cadastroclientepostgresql

2. **Atualize as Dependências:**

Abra o pom.xml e verifique se as seguintes dependências estão presentes

<dependencies>
    <!-- Dependências do Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- Driver PostgreSQL -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    <!-- Lombok -->
    </dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
     <!-- Java Test -->
    </dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <!-- Swagger - SpringDoc OpenAPI -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.2.0</version>
    </dependency>
</dependencies>
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>

3. **Configure as Propriedades da Aplicação:**

No arquivo src/main/resources/application.properties, configure as seguintes propriedades:

spring.datasource.url=jdbc:postgresql://localhost:5432/JavaTestCadastroCliente
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html


# Como Executar

1. **Compile o Projeto:**
mvn clean package

2. **Execute a aplicação:**
java -jar target/cadastroclientepostgresql-0.0.1-SNAPSHOT.jar

Certifique-se de que o PostgreSQL esteja rodando antes de iniciar o aplicativo.

3. **Execute a aplicação:**
Abra o navegador e acesse http://localhost:8080/swagger-ui.html para visualizar e interagir com a documentação da API.


# Funcionalidades

**CRUD de Clientes:**
- Criar: Adicione novos clientes.
- Ler: Consulte clientes pelo ID ou liste todos os clientes.
- Atualizar: Atualize os dados de clientes existentes.
- Deletar: Remova clientes do banco de dados.


# Estrutura do projeto

**Pacote br.com.exemplo.cadastroclientepostgresql**

- Cliente.java: Entidade JPA que representa um cliente.
- ClienteRepository.java: Interface JPA para operações de banco de dados.
- ClienteService.java: Serviço que implementa a lógica de negócios.
- ClienteController.java: Controlador que gerencia os endpoints da API.

**Exemplo de Classe Cliente.java:**

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String email;
    private String telefone;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cpf;
    private String senha;

    // Getters e Setters
}

# Documentação API

A documentação da API é gerada automaticamente pelo Swagger e pode ser acessada em http://localhost:8080/swagger-ui.html. Utilize esta interface para testar os endpoints e entender como interagir com a API.

**Anotações Swagger**
@Operation: Descreve a operação do endpoint.
@ApiResponses: Define as respostas possíveis.
@Parameter: Descreve os parâmetros de entrada.

# Contribuição
**Contribuições são bem-vindas! Por favor, faça um fork do repositório e envie um pull request com suas melhorias.**

# Fim :)

