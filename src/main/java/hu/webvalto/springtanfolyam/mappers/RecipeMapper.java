package hu.webvalto.springtanfolyam.mappers;

import hu.webvalto.springtanfolyam.domain.Recipe;
import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDTO recipeToRecipeDTO(Recipe recipe);

    Recipe recipeDTOToRecipe(RecipeDTO recipeDTO);
}
