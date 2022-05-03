package hu.webvalto.springtanfolyam.services;

import hu.webvalto.springtanfolyam.domain.Recipe;
import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import hu.webvalto.springtanfolyam.exceptions.NotFoundException;
import hu.webvalto.springtanfolyam.mappers.RecipeMapper;
import hu.webvalto.springtanfolyam.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public RecipeDTO findRecipeById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (!recipeOptional.isPresent()) {
            throw new NotFoundException("Recipe Not Found!");
        }
        return recipeMapper.recipeToRecipeDTO(recipeOptional.get());
    }

    @Override
    @Transactional
    public RecipeDTO save(RecipeDTO recipeDTO) {
        Recipe recipe = recipeMapper.recipeDTOToRecipe(recipeDTO);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.recipeToRecipeDTO(savedRecipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }
}
