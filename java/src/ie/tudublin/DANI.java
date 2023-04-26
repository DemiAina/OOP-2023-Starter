package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

import java.util.random.*;



public class DANI extends PApplet {

	ArrayList<Word> model = new ArrayList<Word>();

	public void settings() {
		size(1000, 1000);
		// fullScreen(SPAN);
	}
	
	String Sonnet;

	public String pickRandomWord() {
        int index = (int) random(model.size());
        return model.get(index).getWord();
    }

	public String pickRandomFollow(Word word) {
        ArrayList<Follow> follows = word.getFollows();
        if (follows.isEmpty()) {
            return null;
        }
        int index = (int) random(follows.size());
        return follows.get(index).getWord();
    }

	public void loadFile() {
		String[] lines = loadStrings("shakespere.txt");
		for (String line : lines) {
			String[] words = split(line, ' ');
			for (int i = 0; i < words.length - 1; i++) {
				String word = words[i].replaceAll("[^\\w\\s]", "").toLowerCase();
				String nextWord = words[i + 1].replaceAll("[^\\w\\s]", "").toLowerCase();
				boolean found = false;
				for (Word w : model) {
					if (w.getWord().equals(word)) {
						w.addFollow(nextWord);
						found = true;
						break;
					}
				}
				if (!found) {
					Word newWord = new Word(word);
					newWord.addFollow(nextWord);
					model.add(newWord);
				}

			}
		}

	}

	public void printModel() {
		for (Word word : model) {
			System.out.println(word);
		}
	}

	String[] sonnet;

	 public String[] writeSonnet() {
        String[] sonnet = new String[14];
        for (int i = 0; i < 14; i++) {
            StringBuilder line = new StringBuilder();
            String currentWord = pickRandomWord();
            line.append(currentWord);
            for (int j = 1; j < 8; j++) {
                Word current = null;
                for (Word w : model) {
                    if (w.getWord().equals(currentWord)) {
                        current = w;
                        break;
                    }
                }
                if (current != null) {
                    String nextWord = pickRandomFollow(current);
                    if (nextWord != null) {
                        line.append(" ").append(nextWord);
                        currentWord = nextWord;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            sonnet[i] = line.toString();
		}
		return sonnet;
	}



	public void setup() {
		colorMode(HSB);
		loadFile();
		printModel();
	}

	public void keyPressed() {
		sonnet = writeSonnet();
	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);

		if (sonnet != null) {
			for (int i = 0; i < sonnet.length; i++) {
				text(sonnet[i], width / 2, height / 2 + i * 30);
			}
		}

	}
}
