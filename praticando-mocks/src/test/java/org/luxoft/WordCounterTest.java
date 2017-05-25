package org.luxoft;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WordCounterTest {

	private WordCounter counter;

	@Mock
	private Translator translator;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		counter = new WordCounter();
	}
	
	@Test
	public void takeAndCountOneWord() {
		counter.take("Luxoft");
		
		assertEquals(1, counter.count("Luxoft"));
	}
	
	@Test
	public void takeAndCountTwoTimesSameWord() {
		counter.take("Luxoft");
		counter.take("Luxoft");
		
		assertEquals(2, counter.count("Luxoft"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void takeNull() {
		counter.take(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void takeEmpty() {
		counter.take("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void countNull() {
		counter.count(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void countEmpty() {
		counter.count("");
	}
	
	@Test
	public void takeAndCountTwoWords() {
		counter.take("Luxoft");
		counter.take("Interview");
		
		assertEquals(1, counter.count("Luxoft"));
		assertEquals(1, counter.count("Interview"));
	}
	
	@Test
	public void takeAndCountATranslatedWord() {
		counter = new WordCounter(translator);
		
		when(translator.translate("Olá")).thenReturn("Hello");
		
		counter.take("Olá");
		
		assertEquals(1, counter.count("Hello"));
	}

}
