# Backend Microservices Architecture
### Laravel + Spring Boot

Este projeto demonstra uma arquitetura backend moderna baseada em **microserviços**, combinando diferentes tecnologias para maximizar produtividade, escalabilidade e separação de responsabilidades.

A aplicação utiliza:

- Laravel como **Auth Service e API Gateway**
- Java com Spring Boot como **Microservice de regras de negócio**
- Comunicação entre serviços via **REST API**

---

# Arquitetura Geral

A arquitetura segue o padrão **API Gateway + Microservices**.

            +-------------------+
            |      Client       |
            |  Web / Mobile App |
            +---------+---------+
                      |
                      |
                      v
            +-------------------+
            |      Laravel      |
            |  Auth / Gateway   |
            +---------+---------+
                      |
                      |
                      v
            +-------------------+
            |    Spring Boot    |
            | Business Service  |
            +---------+---------+
                      |
                      |
                      v
            +-------------------+
            |      Database     |
            +-------------------+

            
---

# Objetivos da Arquitetura

- Separar autenticação das regras de negócio
- Permitir escalabilidade independente dos serviços
- Facilitar manutenção e evolução do sistema
- Permitir uso de múltiplas tecnologias

---

# Tecnologias Utilizadas

## Gateway / Auth Service

- Laravel
- PHP
- Laravel Sanctum ou JWT
- Laravel HTTP Client

## Business Microservice

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate

## Infraestrutura

- Maven
- Docker (opcional)
- MySQL / PostgreSQL
- REST API

---

# Arquitetura Interna do Microserviço Java

O microserviço foi estruturado utilizando **arquitetura em camadas**, seguindo princípios da **Clean Architecture**.
src/main/java/com/app

├── controller
│
├── service
│
├── repository
│
├── model
│
├── dto
│
└── config

### Controller Layer

Responsável por:

- Expor endpoints REST
- Receber requisições HTTP
- Retornar respostas da API

---

### Service Layer

Responsável por:

- Regras de negócio
- Processamento da aplicação
- Orquestração das operações

---

### Repository Layer

Responsável por:

- Acesso ao banco de dados
- Persistência de entidades
- Queries

---

### Model Layer

Representa:

- Entidades do domínio
- Estrutura das tabelas do banco

---

### DTO Layer

Responsável por:

- Transferência de dados entre camadas
- Evitar exposição direta das entidades

---

# Fluxo de Requisição
Client Request
|
>
Laravel Authentication
|
>
Token Validation
|
>
Laravel chama Spring Boot API
|
>
Spring Boot executa regra de negócio
|
>
Resposta retorna ao Laravel
|
>
Resposta enviada ao cliente


---

# Segurança

A autenticação ocorre no **Laravel**, que atua como serviço centralizado de autenticação.

Possíveis estratégias:

- JWT Token
- Bearer Token
- API Key

O microserviço Java aceita requisições apenas vindas do Gateway.

---

# Endpoints da API

### Listar tarefas

GET /tasks

Resposta:
[
{
"id": 1,
"titulo": "Estudar Spring",
"descricao": "Aprender microserviços"
}
]


---

### Criar tarefa
POST /tasks


Body:


{
"titulo": "Nova tarefa",
"descricao": "Descrição da tarefa"
}


---

# Comunicação entre serviços

Laravel consome a API Spring Boot usando HTTP Client.

Exemplo:

```php
$response = Http::get('http://localhost:8080/tasks');
$tasks = $response->json();

Criar tarefa:
Http::post('http://localhost:8080/tasks', [
    'titulo' => 'Nova tarefa',
    'descricao' => 'Descrição'
]);
Escalabilidade

Esta arquitetura permite:

Escalar serviços independentemente

Substituir tecnologias sem afetar todo o sistema

Criar novos microserviços

Exemplo de expansão:

           +----------------+
           | Notification   |
           | Microservice   |
           +--------+-------+
                    |
                    v

Laravel Gateway -> Spring Services -> Database

Observabilidade (Melhorias Futuras)

Logs estruturados

Monitoramento de serviços

Métricas de performance

Health checks

Ferramentas possíveis:

Prometheus

Grafana

ELK Stack

Containerização (Futuro)

A aplicação pode ser executada via Docker.

Exemplo de estrutura:


docker-compose

- laravel
- spring-service
- database

Roadmap

Melhorias planejadas:

JWT entre serviços

Spring Security

Docker Compose

Testes automatizados

CI/CD

Documentação da API com Swagger

Executando o Projeto
Rodar Laravel

composer install
php artisan serve


Servidor:


http://localhost:8000

Rodar Spring Boot

mvn spring-boot:run


Servidor:


http://localhost:8080

Objetivo do Projeto

Demonstrar habilidades em:

Arquitetura de sistemas

Backend Java com Spring Boot

Integração entre tecnologias

Desenvolvimento de APIs REST

Estruturação de microserviços

Autor

Gustavo Lopes
