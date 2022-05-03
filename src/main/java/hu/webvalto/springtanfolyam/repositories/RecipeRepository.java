package hu.webvalto.springtanfolyam.repositories;

import hu.webvalto.springtanfolyam.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
