package section3WorkingWithText.comparingStringForEqualityContentEquals40;

/**
 *
 * Comparer que 2 string sont eguale return un boolean
 * Case sensitive
 *
 */
class LearningString40 {

    public static void main(String[] args) {

        String firstText = "Apple";
        String secondeText = "Apple";
        StringBuilder thirdTex = new StringBuilder("apple");


        boolean result = firstText.contentEquals(secondeText); // contentEquals() => Peut comparer 2 String
        System.out.println(result);


        boolean result2 = firstText.contentEquals(thirdTex); // contentEquals() => Mais aussi 1 string et StringBuilder (car les 2 ont la meme class mére CharSequence)
        System.out.println(result2);

        boolean result3 = firstText.equals(secondeText); // equals() => Ne peut comparer strictement que des String entre eux
        System.out.println(result3);
    }
}
