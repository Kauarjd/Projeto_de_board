package com.exemplo.task_board.repository;

import com.exemplo.task_board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b JOIN FETCH b.columns c JOIN FETCH c.cards WHERE b.id = :boardId")
    Optional<Board> findBoardWithColumnsAndCards(@Param("boardId") Long boardId);
}