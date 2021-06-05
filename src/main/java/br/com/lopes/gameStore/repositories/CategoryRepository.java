package br.com.lopes.gameStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lopes.gameStore.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
