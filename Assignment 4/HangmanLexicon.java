/*
F * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HangmanLexicon {
	private ArrayList<String> hangmanLexicon = new ArrayList<String>();
	
	public HangmanLexicon() {
		String s;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("HangmanLexicon.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (bufferedReader != null) {
			try {
				s = bufferedReader.readLine();
				if (s != null) {
					hangmanLexicon.add(s);
				}
				else break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return hangmanLexicon.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return hangmanLexicon.get(index);
	}
}
