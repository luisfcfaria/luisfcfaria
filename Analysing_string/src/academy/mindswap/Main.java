package academy.mindswap;

public class Main {

    private static final String STRING_TO_ANALYSE = "You can always trust the untrustworthy because you can always trust that they will be untrustworthy. It's the trustworthy you cannot trust.";

        public static void main(String[] args) {

            WordHistogram wordHistogram = new WordHistogram();

            wordHistogram.analyseString(STRING_TO_ANALYSE);


            System.out.println(wordHistogram);
            for (String s : wordHistogram) {
                System.out.println(s + ": " + wordHistogram.getValue(s));
            }

            }
        }
