# Contexto e Regras do Projeto (KMP)

Deve-se seguir estas diretrizes rigorosamente. Se não for possível cumpri-las, peça esclarecimentos.

## 1. Estrutura e Arquitetura
- Projeto **Kotlin Multiplatform (KMP)**.
- Respeitar a estrutura de pastas atual (`commonMain`, `androidMain`, etc.).
- Aplicar **Clean Code** e SOLID.
- Para recursos que precisem de actual/expect deve ter o .android .ios. .jvm na implentação.

## 2. Design System (REGRA CRÍTICA)
- Usar **APENAS** componentes do Design System do projeto.
- **BLOQUEIO:** Se um componente necessário não existir, **PARAR A GERAÇÃO IMEDIATAMENTE**.
- Avisar: "Componente [nome] não encontrado no Design System" e sugerir a criação do componente antes de prosseguir.
- **Zero Hardcode:** Proibidas strings, cores ou dimensões fixas. Usar tokens de tema e recursos (ex: MOKO ou BuildKonfig).
- Não gere comentários no código.

## 3. Testes e Documentação
- Gerar Teste para cada funcionalidade.
- Gerar documentação
- Atualizar o `README.md` para novas funcionalidades.
