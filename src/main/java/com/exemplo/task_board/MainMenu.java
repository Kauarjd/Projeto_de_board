package com.exemplo.task_board;

import com.exemplo.task_board.entity.Board;
import com.exemplo.task_board.exception.ResourceNotFoundException;
import com.exemplo.task_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu {

    private final BoardService boardService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public MainMenu(BoardService boardService) {
        this.boardService = boardService;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Criar novo board");
            System.out.println("2. Selecionar board");
            System.out.println("3. Excluir board");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (choice) {
                    case 1:
                        createBoard();
                        break;
                    case 2:
                        selectBoard();
                        break;
                    case 3:
                        deleteBoard();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    private void createBoard() {
        System.out.print("Digite o nome do board: ");
        String name = scanner.nextLine();

        if (name == null || name.trim().isEmpty()) {
            System.out.println("O nome do board não pode ser vazio.");
            return;
        }

        boardService.createBoard(name);
        System.out.println("Board criado com sucesso!");
    }

    private void selectBoard() {
        System.out.print("Digite o ID do board: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir a nova linha

        try {
            Board board = boardService.getBoardById(id);
            System.out.println("Board selecionado: " + board.getName());
            // Aqui você pode chamar um método para exibir o menu de manipulação do board
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteBoard() {
        System.out.print("Digite o ID do board para excluir: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir a nova linha

        try {
            boardService.deleteBoard(id);
            System.out.println("Board excluído com sucesso!");
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}