package academy.mindswap.lms.services;

import academy.mindswap.lms.commands.UniversityDto;
import academy.mindswap.lms.converters.UniversityConverter;
import academy.mindswap.lms.persistence.models.University;
import academy.mindswap.lms.persistence.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UniversityLookupService {


    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private UniversityConverter universityConverter;

    private static final String UNIVERSITY_PER_COUNTRY = "http://universities.hipolabs.com/search?country=%s";

    private final RestTemplate restTemplate;

    public UniversityLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getUniversityPerCountry(String country){
        return String.format(UNIVERSITY_PER_COUNTRY,country);
    }

    public UniversityDto save (UniversityDto universityDto){
        return universityConverter.convertToDto(
                universityRepository.save(
                        universityConverter.convertToEntity(universityDto)
                ));
    }

//    public Optional<UniversityDto> getUniversity(String country){
//        Optional<UniversityDto> university = universityRepository.findByCountry(country);
//        return university;
//    }

    @Async
    public CompletableFuture<List<UniversityDto>> findUniversity(String country){
        String url = getUniversityPerCountry(country);
        UniversityDto[] result = restTemplate.getForObject(url, UniversityDto[].class);
        List<UniversityDto> universityDtos = Arrays.asList(result);
        List<University> universityList = universityRepository.saveAll(universityConverter.universityDtoListToEntity(universityDtos));
        return CompletableFuture.completedFuture(universityConverter.universityListToDto(universityList));
    }


}
