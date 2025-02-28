# Projeto-Gerenciamento_de_tarefas

## Descrição
Este projeto é um sistema de gerenciamento de tarefas (task board) que permite criar boards, colunas e cards para organizar tarefas. Ele foi desenvolvido usando Spring Boot e MySQL.

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  class Board {
    -Long id
    -String name
    -List~Column~ columns
  }

  class Column {
    -Long id
    -String name
    -int columnOrder
    -ColumnType type
    -Board board
    -List~Card~ cards
  }

  class Card {
    -Long id
    -String title
    -String description
    -LocalDateTime createdAt
    -boolean blocked
    -String blockReason
    -Column column
    -Block block
  }

  class Block {
    -Long id
    -String blockReason
    -LocalDateTime blockedAt
    -String unblockReason
    -LocalDateTime unblockedAt
    -Card card
  }

  Board "1" *-- "N" Column : has
  Column "1" *-- "N" Card : contains
  Card "1" *-- "0..1" Block : mayHave

```
