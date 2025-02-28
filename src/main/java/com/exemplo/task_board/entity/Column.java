package com.exemplo.task_board.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "board_columns") // Nome da tabela no banco de dados
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nome da coluna no banco de dados será "name"

    private int columnOrder; // Nome da coluna no banco de dados será "column_order"

    private ColumnType type; // Nome da coluna no banco de dados será "type"

    @ManyToOne
    @JoinColumn(name = "board_id") // Nome da coluna no banco de dados será "board_id"
    private Board board;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;
}