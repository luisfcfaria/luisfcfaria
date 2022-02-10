package academy.mindswap;

import java.util.Arrays;
import java.util.stream.Collectors;


public class StringAnalyser {



    public String convert(String stringToAnalyze, String WHAT_TO_REMOVE){
        return Arrays.stream(stringToAnalyze.toUpperCase().split(" "))
                .filter(word -> !word.equalsIgnoreCase(WHAT_TO_REMOVE))
                .collect(Collectors.joining( " "));

//        Stream<String> toAnalyze = Arrays.stream(stringToAnalyze.split(" "));
//        toAnalyze.

        }


    }
