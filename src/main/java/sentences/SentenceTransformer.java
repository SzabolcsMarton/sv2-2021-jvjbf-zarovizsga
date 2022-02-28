package sentences;

public class SentenceTransformer {

    private final static String END_OF_SENTENCE = ".!?";

    public String shortenSentence(String sentence) {
        ensureStartsWithCapital(sentence);
        ensureEndSign(sentence);
        String[] words = sentence.split(" ");
        if (words.length < 5) {
            return sentence;
        }

        return words[0] + " ... " + words[words.length - 1];
    }

    private void ensureEndSign(String sentence) {
        if (END_OF_SENTENCE.indexOf(sentence.charAt(sentence.length() - 1)) == -1) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }

    private void ensureStartsWithCapital(String sentence) {
        if (!Character.isUpperCase(sentence.charAt(0))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
    }
}
