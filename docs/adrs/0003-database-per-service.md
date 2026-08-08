# ADR 0003 — Banco de dados por serviço

Data: 2026-08-08

Status: Aceita

Contexto
- Deseja-se reduzir acoplamento entre serviços e permitir evolução independente do schema.
- Exemplos: pedidos e transações financeiras podem ter requisitos distintos de modelagem.

Decisão
- Cada microserviço terá sua própria base de dados (DB por serviço). Para este MVP, manteremos uma DB principal para pedidos (acessada pelo ms-checkout) e uma DB local para transações do ms-pagamento, evitando compartilhamento direto de tabelas.

Alternativas consideradas
- Banco de dados compartilhado entre serviços.

Consequências
- Vantagens:
  - Baixo acoplamento de dados e independência para evoluir schema.
  - Melhor alinhamento com microservices pattern.
- Desvantagens:
  - Complexidade para consultas transversais e necessidade de event-driven eventual consistency.
- Mitigações:
  - Expor APIs para consultas cross-service.
  - Propagar eventos de sincronização via Message Broker.

Referências
- Arquitetura C4 — container DBs (docs/diagrams).
