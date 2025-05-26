# Agência de Viagens

API para gerenciamento de destinos turísticos, reservas e avaliações, com autenticação e autorização de usuários.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.8+
- PostgreSQL

## Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL, por exemplo:
   ```sql
   CREATE DATABASE agencia_viagens;
   ```

2. Atualize o arquivo `src/main/resources/application.properties` com os dados do seu banco:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/agencia_viagens
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   spring.jpa.hibernate.ddl-auto=update
   ```

3. (Opcional) Execute o script SQL em `/script/agencia-viagem.sql` para popular o banco com dados iniciais.

## Rodando o Projeto

No terminal, execute:

```bash
mvn spring-boot:run
```
ou
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
[http://localhost:8080](http://localhost:8080)

## Autenticação

- O sistema utiliza autenticação via Spring Security.
- Usuários e perfis (roles) são cadastrados no banco de dados.
- Para acessar os endpoints protegidos, faça login com um usuário cadastrado.

## Exemplos de Endpoints

- **Listar destinos:** `GET /api/destinos`
- **Cadastrar destino (ADMIN):** `POST /api/destinos`
- **Reservar destino:** `POST /api/destinos/{id}/reservar`
- **Avaliar destino:** `PATCH /api/destinos/{id}/avaliacao`
- **Buscar destinos:** `GET /api/destinos/search?nome=Paris`

## Testando a API

Você pode usar ferramentas como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para testar os endpoints.

## Observações

- Certifique-se de que o banco de dados está rodando antes de iniciar a aplicação.
- As senhas dos usuários devem estar criptografadas (BCrypt) no banco.
- Para criar novos usuários/admins, insira diretamente no banco ou implemente um endpoint de cadastro.

---

Qualquer dúvida, abra uma issue!
