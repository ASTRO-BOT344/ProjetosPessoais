# 🚀 Sistema de Gestão de Bootcamp e Pagamentos

Este projeto, desenvolvido por **Caio Felix (ASTRO-BOT344)**, demonstra a aplicação do padrão **MVC** em um ambiente **Spring Boot**, integrando lógica de gamificação (XP) com um sistema de pagamentos via **Strategy Pattern**.

## 🛠️ O que foi feito?
- **Desacoplamento**: O código original foi separado em camadas para facilitar a manutenção.
- **Domínio de Bootcamp**: Implementação de herança e polimorfismo com as classes `Curso`, `Mentoria` e `Dev`.
- **API de Pagamentos**: Endpoint funcional para processar diferentes métodos de pagamento de forma extensível.

## 📁 Organização de Pastas
- `/model`: Contém as entidades de negócio e regras de cálculo de XP.
- `/service`: Camada intermediária que processa a lógica de pagamento.
- `/controller`: Gerencia as rotas da API (ex: `/pagar`).

## 🚀 Como Rodar
1. Instale as dependências listadas no `pom.xml`.
2. Execute a classe `Main.java`.
3. Para testar o pagamento, acesse: `http://localhost:8080/pagar?tipo=PIX&valor=50.0`
