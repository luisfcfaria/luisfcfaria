package academy.mindswap.lms.converters;

import academy.mindswap.lms.commands.UniversityDto;
import academy.mindswap.lms.persistence.models.University;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UniversityConverter {

    @Autowired
    private ModelMapper modelMapper;


    public UniversityDto convertToDto(University university){
        return modelMapper.map(university, UniversityDto.class);
    }

    public University convertToEntity (UniversityDto universityDto){
        return modelMapper.map(universityDto , University.class);
    }


    public List<University> universityDtoListToEntity(List<UniversityDto> universityDtos){

        return universityDtos
                .stream()
                .map(this::convertToEntity).collect(Collectors.toList());
    }


    public List<UniversityDto> universityListToDto(List<University> university){

        return university
                .stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }
}
