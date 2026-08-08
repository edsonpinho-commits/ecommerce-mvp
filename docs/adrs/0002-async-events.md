# ADR 0002 — Uso de eventos assíncronos (Message Broker) para integrações entre serviços

Data: 2026-08-08

Status: Aceita

Contexto
- Fluxo de checkout envolve criação de pedido e processamento de pagamento.
- Algumas notificações (ex.: confirmação de pagamento, atualização de inventário) podem ser processadas de forma eventual.

Decisão
- Introduzir um Message Broker (RabbitMQ ou Kafka) para eventos assíncronos entre serviços (ex.: evento `pedido.criado`, `pagamento.confirmado`).

Alternativas consideradas
- Comunicação 100% via HTTP síncrono entre serviços.
- Usar apenas callbacks do gateway de pagamento externo.

Consequências
- Vantagens:
  - Desacopla serviços, melhora tolerância a falhas e latência aparente do usuário.
  - Facilita re-processamento e auditoria de eventos.
- Desvantagens:
  - Introduz infraestrutura adicional e complexidade operacional.
  - Requer tratamento de mensagens duplicadas e idempotência.
- Mitigações:
  - Implementar idempotência nas operações consumidoras.
  - Documentar tópicos/events e formatar payloads (ex.: JSON com pedidoId, status, timestamp).

Referências
- Pasta: docs/diagrams (c4-container indica “Message Broker” como componente opcional).
