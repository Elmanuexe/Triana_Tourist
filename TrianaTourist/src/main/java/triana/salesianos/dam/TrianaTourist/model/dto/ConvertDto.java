package triana.salesianos.dam.TrianaTourist.model.dto;

import org.springframework.stereotype.Component;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.model.POI;

@Component
public class ConvertDto {

    public POI convertDtoToPOI(POIDto dto){
        return POI.builder()
                .location(dto.getLocation())
                .description(dto.getDescription())
                .date(dto.getDate())
                .category(dto.getCategory())
                .coverPhoto(dto.getCoverPhoto())
                .photo2(dto.getPhoto2())
                .photo3(dto.getPhoto3())
                .build();
    }

    public Category convertDtoToCategory(CategoryDto dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }


}
