package org.luxoft;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WordCounter {

	private Map<String, Integer> wordsCounted = new ConcurrentHashMap<>();
	private Translator translator;
	
	public WordCounter() {}
	
	WordCounter(Translator translator) {
		super();
		this.translator = translator;
	}

	public void take(String word) {
		
		if (word == null || word.isEmpty())
			throw new IllegalArgumentException();
		
		String translatedWord = word;
		
		if (translator != null)
			translatedWord = translator.translate(word);
		
		if (wordsCounted.containsKey(translatedWord)) {
			Integer count = wordsCounted.get(translatedWord);
			wordsCounted.put(translatedWord, count + 1);
		} else
			wordsCounted.put(translatedWord, 1);
			
	}

	public int count(String word) {
		
		if (word == null || word.isEmpty())
			throw new IllegalArgumentException();

		return wordsCounted.get(word);
	}

}
