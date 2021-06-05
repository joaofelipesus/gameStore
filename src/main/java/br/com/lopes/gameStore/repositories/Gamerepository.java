package br.com.lopes.gameStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lopes.gameStore.models.Game;

public interface Gamerepository extends JpaRepository<Game, Long>{

}
