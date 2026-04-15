# BRIEF DO PRODUTO — RoomBook Corporate

## 1. Contexto
O processo de reserva de salas é hoje informal/manual, gerando conflitos de uso, baixa visibilidade de ocupação e perda de tempo operacional.

## 2. Problema
Colaboradores podem reservar a mesma sala no mesmo período sem controle centralizado, causando retrabalho e impacto em reuniões internas.

## 3. Objetivo do MVP
Construir uma aplicação Java console para registrar reservas de salas corporativas, listar ocupação e impedir conflitos básicos de agendamento.

## 4. Escopo da versão 1
- Cadastrar reserva
- Associar responsável à reserva
- Associar sala à reserva
- Reservar por turno
- Listar salas ocupadas
- Listar salas livres

## 5. Regras de negócio
- Uma sala não pode possuir duas reservas no mesmo turno
- Apenas salas existentes podem ser reservadas
- O sistema deve exibir a ocupação atual de forma clara

## 6. Critérios de aceite
- Usuário consegue registrar uma reserva com sucesso
- Sistema impede conflito de reserva
- Sistema lista salas ocupadas e livres
- Fluxo funciona integralmente via terminal

## 7. Stack inicial
- Java
- Eclipse
- Execução em console
- Versionamento com Git/GitHub

## 8. Próxima entrega
Implementar a estrutura inicial do domínio com classes de sala e reserva.