package academy.mindswap;

import java.util.Arrays;
import java.util.stream.Collectors;


public class StringAnalyser {



    public String convert(String stringToAnalyze, String wordToRemove){
        return Arrays.stream(stringToAnalyze.toUpperCase().split(" "))
                .filter(word -> !word.equalsIgnoreCase(wordToRemove))
                .collect(Collectors.joining( " "));
        }


    }
