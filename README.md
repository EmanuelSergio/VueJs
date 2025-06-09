# 📝 Todo List Application

Um aplicativo full-stack de lista de tarefas, com frontend em Vue.js e backend em Spring Boot, projetado para ajudar você a gerenciar suas tarefas diárias de forma simples e eficiente.
---

## 📋 Índice

* [Visão Geral](#-visão-geral)
* [Tecnologias](#-tecnologias)
* [Arquitetura](#-arquitetura)
* [Como Instalar](#-como-instalar)
* [Como Usar](#-como-usar)
* [Funcionalidades](#-funcionalidades)
* [API Endpoints](#-api-endpoints)
* [Estrutura do Banco de Dados](#️-estrutura-do-banco-de-dados)
* [Screenshots](#-screenshots)
* [Contribuição](#-contribuição)
* [Licença](#-licença)
* [Contato](#-contato)

---

## 🔍 Visão Geral

Este projeto é uma aplicação de gerenciamento de tarefas que permite aos usuários criar, listar, editar e excluir tarefas. A interface foi desenvolvida com **Vue.js + Vuetify**, enquanto o backend utiliza **Spring Boot** e **PostgreSQL**, com versionamento de banco de dados via Flyway.

---

## 💻 Tecnologias

### Frontend

* [Vue.js 3](https://vuejs.org/)
* [TypeScript](https://www.typescriptlang.org/)
* [Vuetify 3](https://vuetifyjs.com/)
* [Vue Router](https://router.vuejs.org/)
* [Vite](https://vitejs.dev/)
* [SCSS](https://sass-lang.com/)

### Backend

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [PostgreSQL](https://www.postgresql.org/)
* [Flyway](https://flywaydb.org/)
* [Lombok](https://projectlombok.org/)
* [ModelMapper](http://modelmapper.org/)
* [SpringDoc OpenAPI](https://springdoc.org/)

---

## 🏗️ Arquitetura

### Frontend (Vue.js)

```
vue-project/
├── src/
│   ├── assets/         # Imagens e estilos
│   ├── components/     # Componentes reutilizáveis
│   ├── views/          # Páginas da aplicação
│   ├── router/         # Configurações de rotas
│   ├── App.vue         # Componente raiz
│   └── main.ts         # Ponto de entrada
├── public/
└── vite.config.ts
```

### Backend (Spring Boot)

```
Backend/demo/
├── src/main/java/com/todo/demo/
│   ├── controller/     # Endpoints REST
│   ├── config/         # Configurações
│   ├── dto/            # DTOs (Data Transfer Objects)
│   ├── entities/       # Entidades JPA
│   ├── repositories/   # Repositórios de dados
│   ├── services/       # Regras de negócio
│   └── DemoApplication.java
├── resources/
│   ├── db/migration/   # Scripts do Flyway
│   └── application.properties
├── test/               # Testes
└── pom.xml
```

---

## ⚙️ Como Instalar

### Pré-requisitos

* JDK 21
* Node.js
* PostgreSQL (local ou via Docker)
* Docker (opcional)

### Backend

```bash
git clone https://github.com/EmanuelSergio/VueJs.git
cd todo-list-app/Backend/demo
docker-compose up -d  # ou configure seu PostgreSQL manualmente
./mvnw spring-boot:run  # ou mvnw.cmd no Windows
```

### Frontend

```bash
cd ../vue-project
npm install
npm run dev
```

---

## 🚀 Como Usar

* Acesse o frontend: [http://localhost:5173](http://localhost:5173)
* Backend API: [http://localhost:8080](http://localhost:8080)
* Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## ✨ Funcionalidades

* 🔒 Autenticação de usuários (em desenvolvimento)
* ✅ CRUD de Tarefas:

  * Criar
  * Visualizar
  * Atualizar
  * Concluir
  * Deletar
* 📅 Visualização diária de tarefas
* 🎨 Interface intuitiva com Vuetify
* 📱 Layout responsivo
* 🧭 Navegação com menu lateral

---

## 🔌 API Endpoints

### Usuários (`/person`)

* `GET /all` - Lista todos
* `GET /{id}` - Detalhes de um usuário
* `POST /` - Cria usuário
* `PATCH /{id}` - Atualiza usuário
* `DELETE /{id}` - Deleta usuário

### Tarefas (`/task`)

* `GET /{personId}/all` - Todas as tarefas do usuário
* `GET /{personId}/{id}` - Detalhe da tarefa
* `POST /{personId}` - Nova tarefa
* `PATCH /{personId}/{id}` - Editar tarefa
* `PUT /start/{personId}/{id}` - Iniciar tarefa
* `PUT /finish/{personId}/{id}` - Finalizar tarefa
* `DELETE /{personId}/{id}` - Remover tarefa

### Visualizações

* `GET /view/all` - Todas as tarefas com dados do usuário

---

## 🗄️ Estrutura do Banco de Dados

### `tb_person`

| Campo       | Tipo      |
| ----------- | --------- |
| id          | INT (PK)  |
| name        | VARCHAR   |
| email       | VARCHAR   |
| password    | VARCHAR   |
| date\_birth | TIMESTAMP |

### `tb_task`

| Campo          | Tipo      |
| -------------- | --------- |
| id             | INT (PK)  |
| title          | VARCHAR   |
| description    | VARCHAR   |
| status         | BOOLEAN   |
| started\_date  | TIMESTAMP |
| finished\_date | TIMESTAMP |
| person\_id     | INT (FK)  |

---

## 👨‍💻 Contribuição

1. Fork este repositório
2. Crie uma branch com sua feature: `git checkout -b feature/sua-feature`
3. Commit suas alterações: `git commit -m 'Adiciona nova funcionalidade'`
4. Push: `git push origin feature/sua-feature`
5. Abra um Pull Request

