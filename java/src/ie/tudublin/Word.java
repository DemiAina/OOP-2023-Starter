package ie.tudublin;

import java.util.ArrayList;

public class Word {

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    ArrayList<Follow> follows = new ArrayList<Follow>();

    public String toString(){
        return word + "\t" + follows;
    }

    
    
}
