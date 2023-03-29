package Lesson.day10.generic_enum_anonymous;

public class Word {
    private String letters;

    public Word(String letters) {
        this.letters = letters;
    }

    public boolean isVowel(int i) {
        return "aeiouAEIOU".contains(letters.substring(i, i + 1));
    }

    public boolean isConsonant(int i) {
        if ("aeiouAEIOU".contains(letters.substring(i, i + 1))) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Word word = new Word("aeiousfddfssdfgfsdg");
        System.out.println(word.isVowel(3));
        System.out.println(word.isVowel(13));
        System.out.println(word.isConsonant(3));
        System.out.println(word.isConsonant(13));
    }
}
