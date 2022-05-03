package hu.webvalto.springtanfolyam.mappers;

import hu.webvalto.springtanfolyam.domain.Category;
import hu.webvalto.springtanfolyam.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
