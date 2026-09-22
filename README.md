# Workshop Spring Boot JPA

Projeto de **estudo de Java e Spring Boot**, baseado no curso **Java COMPLETO** do [Nélio Alves](https://www.udemy.com/course/java-curso-completo/).

O objetivo é praticar desde a construção de uma API REST até sua execução em um ambiente de produção.

## Sobre o projeto

API REST desenvolvida com:

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- H2
- PostgreSQL
- Docker
- Render

A aplicação possui entidades como `User`, `Order`, `Product`, `Category` e seus relacionamentos, além de CRUDs e tratamento de exceções.

## Arquitetura

O projeto segue uma arquitetura em camadas:

```text
HTTP
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
JPA / Hibernate
 ↓
Database
```

- **Controller:** endpoints HTTP.
- **Service:** regras e lógica da aplicação.
- **Repository:** acesso aos dados através do Spring Data JPA.
- **JPA/Hibernate:** mapeamento entre objetos Java e tabelas do banco.

## Bancos de dados

### H2

Foi utilizado inicialmente para desenvolvimento por ser simples e não exigir um servidor de banco separado.

```text
Spring Boot → JPA → H2
```

Quando utilizado em memória, os dados são temporários. Por isso, ele não é adequado para armazenar os dados de produção.

### PostgreSQL

Depois do deploy, o projeto foi migrado para PostgreSQL para ter **persistência real dos dados**.

```text
Spring Boot → JPA/Hibernate → PostgreSQL
```

O PostgreSQL de produção é gerenciado pelo **Render**.

As informações de conexão são fornecidas através de variáveis de ambiente, mantendo credenciais fora do código.

## Docker

O Docker foi utilizado para empacotar a aplicação em um container e tornar o ambiente de execução mais previsível.

```text
Código
 ↓
Dockerfile
 ↓
Docker Image
 ↓
Container
 ↓
Spring Boot
```

Durante o deploy houve um problema com o `mvnw`: o arquivo existia, mas não possuía permissão de execução no Linux. Foi corrigido com:

```bash
git update-index --chmod=+x mvnw
```

## Deploy

A aplicação foi publicada no Render:

```text
GitHub
   ↓
Render Web Service
   ↓
Docker
   ↓
Spring Boot
   ↓
Render PostgreSQL
```

API:

https://workshop-springboot-jpa-t3zq.onrender.com/users

## Desenvolvimento x Produção

A ideia é manter ambientes separados:

```text
LOCAL
Spring Boot → H2

PRODUÇÃO
Spring Boot → PostgreSQL (Render)
```

No futuro, o projeto pode evoluir para utilizar **PostgreSQL local via Docker**, aproximando ainda mais o ambiente de desenvolvimento do ambiente de produção.

## O que este projeto permitiu estudar

- Orientação a objetos com Java
- Spring Boot e injeção de dependência
- APIs REST
- JPA e Hibernate
- Relacionamentos entre entidades
- Spring Data JPA
- Tratamento de exceções
- Maven
- Docker
- Variáveis de ambiente
- PostgreSQL
- Deploy e infraestrutura básica

## Referências

- **Curso:** [Java COMPLETO — Nelio Alves](https://www.udemy.com/course/java-curso-completo/)
- **Repositório:** https://github.com/Vizoni/workshop-springboot-jpa
- [Spring Boot — SQL Databases](https://docs.spring.io/spring-boot/reference/data/sql.html)
- [Render — PostgreSQL](https://render.com/docs/postgresql-creating-connecting)

> **Nota:** este é um projeto de estudo. As escolhas de arquitetura e infraestrutura têm como principal objetivo aprender e experimentar conceitos de backend, e não representar uma arquitetura de produção completa.
