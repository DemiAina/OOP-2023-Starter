package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

/*
 * Write a method called printModel() that prints the model. For the included text file of small.txt above, this is the model:
 */



public class DANI extends PApplet {
 
	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

	public void loadFile(){
		String lines[] = loadStrings("small.txt");

		for(String s: lines){
			String[] words = split(s, " ");
			for(String w: words){
				
			}
		}

	
	
	}
	
	public void printModel(){
		
	}


	
    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);
		loadFile();
		printModel();
	}

	public void keyPressed() {

	}

	

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}
}
