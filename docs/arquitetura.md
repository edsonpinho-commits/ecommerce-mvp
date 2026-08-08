# Arquitetura do E-commerce MVP — Resumo e Mapeamento do Código

Visão geral
- Arquitetura: Microservices (ms-checkout e ms-pagamento).
- Comunicação: HTTP/REST entre front-end/API Gateway e serviços; eventos assíncronos via Message Broker (opcional).
- Tecnologias: Java + Spring Boot, Spring Data JPA, H2 (para execução local do MVP).

Estrutura do repositório (mapeamento)
- ms-checkout/
  - Responsabilidade: gerenciar carrinho, criar pedidos.
  - Código em: ms-checkout/src/main/java
- ms-pagamento/
  - Responsabilidade: processar pagamentos, validar respostas do gateway.
  - Código em: ms-pagamento/src/main/java/com/ecommerce/ms_pagamento
  - Implementações de patterns: ms-pagamento/src/main/java/com/ecommerce/ms_pagamento/patterns/{factory,strategy}

Documentos auxiliares
- docs/diagrams/: diagramas C4 (contexto e container)
- docs/adrs/: registros de decisões arquiteturais (ADRs)
- docs/patterns.md: explicação dos Design Patterns aplicados
- docs/defesa/: material de defesa (template)

Endpoints principais (exemplos)
- ms-pagamento:
  - POST /pagamentos/processar — processa um pagamento (simulado).

Como rodar localmente (ms-pagamento)
- Pré-requisitos: Java 17+ (ou 21 conforme pom), Maven.
- Build & teste:
  - cd ms-pagamento
  - mvn -DskipTests=false test
- Rodar:
  - mvn spring-boot:run
- Acesso H2 Console:
  - http://localhost:8090/h2-console
  - JDBC URL: jdbc:h2:mem:ms_pagamento

Observações
- Para avaliação local do MVP escolhemos H2 in-memory para evitar dependências externas.
- Os patterns implementados (Factory, Strategy, Repository) têm implementação mínima funcional para demonstração.
