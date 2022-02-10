package academy.mindswap;

public class Main {

    public static void main(String[] args) {

        StringAnalyser analise = new StringAnalyser();

        String prayer = "Oh Lord, won't you buy me a trash Mercedes Benz\n" +
                "My friends all drive trash Porsches, I must make trash amends\n" +
                "Worked hard all my trash lifetime, no help from my trash friends\n" +
                "So Lord, won't you buy me a trash Mercedes Benz";


        System.out.println(analise.convert(prayer,"trash" ));

    }
}

