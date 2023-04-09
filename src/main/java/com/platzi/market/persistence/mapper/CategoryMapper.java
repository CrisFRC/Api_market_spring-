package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DCategory;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;



@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //conversion directa de Category(persistence) a Category(Domain)
    @Mappings({
            @Mapping(source="idCategory", target = "categoryId"),
            @Mapping(source="description", target = "category"),
            @Mapping(source="state", target = "active")
    })
    DCategory toCategory(Category category);

    //conversión inversa de Category(Domain) a Category(persistence)
    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategoryPer(DCategory category);


}
