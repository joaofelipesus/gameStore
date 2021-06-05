package br.com.lopes.gameStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lopes.gameStore.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
