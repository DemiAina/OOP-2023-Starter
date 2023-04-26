package ie.tudublin;
import java.util.ArrayList;


public class Word {
 
  public String word;
  public ArrayList<Follow> follows;


  public Word(String word) {
    this.word = word;
    follows = new ArrayList<Follow>();
  }

  public String getWord() {
    return word;
  }


  public ArrayList<Follow> getFollows() {
    return follows;
  }


  public void addFollow(String word) {

    for (Follow follow : follows) {
      if (follow.getWord().equals(word)) {
        follow.incrementCount();
      }
    }
    follows.add(new Follow(word));
  }

  public String toString() {
    String s = word + ": ";
    for (Follow follow : follows) {
      s += follow.toString() + " ";
    }
    return s;
  }
}