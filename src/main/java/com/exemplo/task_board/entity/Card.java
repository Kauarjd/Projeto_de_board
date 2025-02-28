package com.exemplo.task_board.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean blocked;
    private String blockReason;

    @ManyToOne
    @JoinColumn(name = "column_id")
    private Column column;
}