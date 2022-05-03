package hu.webvalto.springtanfolyam.dto;

import hu.webvalto.springtanfolyam.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private byte[] image;
    private NotesDTO notes;
    private Set<IngredientDTO> ingredients = new HashSet<>();
    private Set<CategoryDTO> categories = new HashSet<>();
}
