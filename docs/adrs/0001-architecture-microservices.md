# ADR 0001 — Adoção da arquitetura de Microservices

Data: 2026-08-08

Status: Aceita

Contexto
- O trabalho exige um MVP que adote claramente um padrão arquitetural estudado.
- O repositório já contém dois serviços separados (ms-checkout e ms-pagamento) implementados em Java/Spring Boot, indicando tendência para serviços independentes.
- Requisitos não-funcionais: modularidade, facilidade para dividir trabalho entre membros, possibilidade de escalabilidade independente.

Decisão
- Adotar arquitetura de Microservices com serviços independentes responsáveis por domínios específicos (ex.: ms-checkout para carrinho/pedidos; ms-pagamento para processamento financeiro).

Alternativas consideradas
- Arquitetura monolítica modularizada.
- Arquitetura em camadas dentro de um único deploy.

Consequências
- Vantagens:
  - Baixo acoplamento entre domínios (cada microserviço tem responsabilidade única).
  - Facilita divisão de trabalho e evidência de participação (commits por serviço).
  - Permite escalabilidade independente e deploy granular.
- Desvantagens:
  - Complexidade operacional maior (deploys, observabilidade, coordenação transacional).
  - Necessidade de comunicação inter-serviços (sincrona/assíncrona) e estratégias de consistência.
- Mitigações:
  - Usar HTTP simples para chamadas sincrônicas e Message Broker para eventos assíncronos.
  - Documentar contratos de API e adicionar testes de integração simples.

Referências
- Estrutura atual do repo: ms-checkout, ms-pagamento.
