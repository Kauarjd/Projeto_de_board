package com.exemplo.task_board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskBoardApplication {

	private static final Logger logger = LoggerFactory.getLogger(TaskBoardApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskBoardApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(MainMenu mainMenu) {
		return args -> {
			try {
				logger.info("Iniciando aplicação...");
				mainMenu.start();
			} catch (Exception e) {
				logger.error("Ocorreu um erro inesperado: ", e);
			}
		};
	}
}