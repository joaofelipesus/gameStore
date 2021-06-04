package br.com.lopes.gameStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lopes.gameStore.models.Console;

public interface ConsoleRepository extends JpaRepository<Console, Long> {

}
