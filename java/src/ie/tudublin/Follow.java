package ie.tudublin;

public class Follow {
    private String word;
    private int count;
    

    public String getWord() {
        return word;
    }


    public void setWord(String word) {
        this.word = word;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public String toString()
    {
        return word + "\t" + count;
    }
    
}
