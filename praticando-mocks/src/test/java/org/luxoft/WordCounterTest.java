package org.luxoft;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WordCounterTest {
	
	@Rule
	public ExpectedException expect = ExpectedException.none();

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
	
//	@Test(expected = IllegalArgumentException.class)
	@Test
	public void countEmpty() {
		expect.expect(IllegalArgumentException.class);
		expect.expectMessage("Invalid!");
		
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
	
	@Test
	public void overFlowWordCounter() {
		Map<String, Integer> myCounter = new ConcurrentHashMap<>();
		
		myCounter.put("Luxoft", Integer.MAX_VALUE);
		
		counter.setCounter(myCounter);
		
		counter.take("Luxoft");
		
	}

}
