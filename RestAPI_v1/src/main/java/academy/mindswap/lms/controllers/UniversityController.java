package academy.mindswap.lms.controllers;

import academy.mindswap.lms.commands.UniversityDto;

import academy.mindswap.lms.services.UniversityLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/university")
public class UniversityController {


    @Autowired
    private UniversityLookupService universityLookupService;


    @GetMapping("/{country}")
    public List<UniversityDto> getUniversityByCountry(@PathVariable String country) throws ExecutionException, InterruptedException {
        CompletableFuture<List<UniversityDto>> university = universityLookupService.findUniversity(country);
        List<UniversityDto> universityDto = university.get();

//        universityLookupService.save(universityDto);
        return universityDto;
    }

}
