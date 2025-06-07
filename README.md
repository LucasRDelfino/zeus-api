# ⚡ Plataforma Zeus

A **Plataforma Zeus** oferece uma solução completa para monitoramento de **informações climáticas** e **probabilidade de queda de energia elétrica**, com foco em prevenção e tomada de decisão frente a eventos climáticos extremos.

---

## 🌐 Funcionalidades da Plataforma

### 📡 Informações Climáticas
- Consulta de dados meteorológicos em tempo real por cidade.
- Variáveis coletadas:
  - Velocidade do vento (km/h)
  - Rajadas de vento (km/h)
  - Volume de chuva (mm)
  - Cobertura de nuvens (%)
  - Umidade relativa do ar (%)
  - Descrição geral do clima

### ⚠️ Probabilidade de Queda de Energia
- Cálculo automático da **probabilidade de queda de energia** com base nos dados climáticos.
- Algoritmo que simula uma IA preditiva, ponderando fatores como vento, chuva e cobertura de nuvens.
- Retorno do risco em percentual (0% a 100%).

---

## 🔧 Funcionalidades da API (Java - Spring Boot)

- **Autenticação**
  - `POST /login`: login de usuários

- **Usuários**
  - `POST /usuarios`: cadastro de usuário
  - `GET /usuarios`: listar todos os usuários
  - `GET /usuarios/{id}`: buscar usuário por ID
  - `PUT /usuarios/{id}`: atualizar dados do usuário
  - `DELETE /usuarios/{id}`: excluir usuário

- **Serviço Climático**
  - `GET /clima?cidade=nome`: retorna dados climáticos da cidade informada

- **Cálculo de Risco**
  - `GET /risco?cidade=nome`: retorna a probabilidade de queda de energia com base na cidade

---

## 💻 Telas da Aplicação Web (React)

### 🔐 Tela de Cadastro/Login
- Formulário de criação de conta
- Login com autenticação integrada à API
- Armazenamento da cidade de interesse

### 🌤️ Tela de Clima
- Exibe as informações meteorológicas atuais da cidade do usuário
- Interface clara e responsiva

### ⚡ Tela de Probabilidade de Queda
- Mostra o percentual de risco calculado
- Cores e ícones indicam o nível de perigo (baixo, moderado, alto)
- Atualização em tempo real com base nos dados da API

---

## 🚀 Tecnologias Utilizadas

- **Backend**: Java 17, Spring Boot, Spring WebFlux, JPA, PostgreSQL
- **Frontend**: React Native
- **APIs externas**: OpenWeatherMap
- **Extras**: módulos em Python e Arduino (para sensores e análises locais)

---

## Integrantes
Lucas Rodrigues Delfino - RM550196
Luisa Cristina dos Santos Neves - RM551889
Gabriel aparecido Cassalho Xavier - RM99794

