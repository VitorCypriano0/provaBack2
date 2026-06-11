# Prova Back 2

CRUD completo de provas usando Spring Boot, JPA e banco H2.

## Requisitos atendidos

- Entidade `Prova` com `id`, `titulo`, `materia` e `data`.
- `titulo` e `materia` obrigatorios.
- Controller base em `/prova`.
- CRUD completo:
  - `GET /prova/listar`
  - `GET /prova/listar?titulo=teste`
  - `POST /prova/criar`
  - `PUT /prova/atualizar`
  - `DELETE /prova/deletar?id=1`
- Conexao com banco de dados H2.

## Como executar

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

A API fica disponivel em:

```text
http://localhost:8080
```

Console do banco H2:

```text
http://localhost:8080/h2-console
```

Dados de acesso ao H2:

```text
JDBC URL: jdbc:h2:file:./data/provas-db
User: sa
Password:
```

## Exemplos

Criar prova:

```bash
curl -X POST http://localhost:8080/prova/criar \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Prova Final","materia":"Programador Web","data":"2026-06-11"}'
```

Atualizar prova:

```bash
curl -X PUT http://localhost:8080/prova/atualizar \
  -H "Content-Type: application/json" \
  -d '{"id":1,"titulo":"Prova Final Atualizada","materia":"Backend","data":"2026-06-11"}'
```

Deletar prova:

```bash
curl -X DELETE "http://localhost:8080/prova/deletar?id=1"
```
