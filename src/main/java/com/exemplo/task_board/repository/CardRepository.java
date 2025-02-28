package com.exemplo.task_board.repository;

import com.exemplo.task_board.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    Page<Card> findByColumnId(Long columnId, Pageable pageable);
}