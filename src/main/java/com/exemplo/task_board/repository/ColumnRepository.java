package com.exemplo.task_board.repository;

import com.exemplo.task_board.entity.Column;
import com.exemplo.task_board.entity.ColumnType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnRepository extends JpaRepository<Column, Long> {
    List<Column> findByType(ColumnType type);
}