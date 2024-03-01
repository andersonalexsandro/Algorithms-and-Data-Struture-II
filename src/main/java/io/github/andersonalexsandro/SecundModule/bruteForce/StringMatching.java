package io.github.andersonalexsandro.SecundModule.bruteForce;

public class StringMatching {
    private  char pattern[];
    private char text[];

    public StringMatching(String pattern, String text){
        this.pattern = pattern.toCharArray();
        this.text = text.toCharArray();
    }

    public int stringMatching(){
        int textSize = text.length;
        int patternSize = pattern.length;
        for(int i=0; i< textSize - patternSize; i++){
            int j = 0;
            while(j < patternSize && pattern[j] == text[i + j]){
                j = j + 1;
            }
            if(j == patternSize) return i;
        }
        return -1;
    }

    public static void main(String[] arg){
        String text = "NOBODY_NOTICED_HIM";
        String pattern = "NOT";

        StringMatching stringMatcher = new StringMatching(pattern, text);
        System.out.println(stringMatcher.stringMatching());
    }

}
