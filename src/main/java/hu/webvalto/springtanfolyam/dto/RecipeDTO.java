package hu.webvalto.springtanfolyam.dto;

import hu.webvalto.springtanfolyam.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    @Min(1)
    @Max(999)
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    @URL
    private String url;
    @NotBlank
    private String directions;
    private Difficulty difficulty;
    private byte[] image;
    private NotesDTO notes;
    private Set<IngredientDTO> ingredients = new HashSet<>();
    private Set<CategoryDTO> categories = new HashSet<>();
}
