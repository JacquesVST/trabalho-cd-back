package aleatorio.itemaleatorio.word.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import aleatorio.itemaleatorio.word.model.Word;

@Service
public class WordService {

	public List<String> wordPicker(Word wordRequest) {
		Integer amount = wordRequest.getAmount();
		Integer sortDirection = wordRequest.getSortDirection();
		Boolean allowDuplicated = wordRequest.getAllowDuplicated();
		List<String> allWords = wordRequest.getWords();
		List<String> wordsPicked = new ArrayList<>();
		
		if(isImpossibleRequest(allWords.size(), amount, allowDuplicated)) {
			return wordsPicked;
		}
		
		for(Integer i=0; i<amount; i++) {
			String word = "";
			word = pickRandomWord(allWords);
			
			while(!allowDuplicated && wordsPicked.contains(word)) {
				word = pickRandomWord(allWords);
			}
			
			wordsPicked.add(word);
		}
		
		if(sortDirection == 1) {
			wordsPicked.sort(Comparator.naturalOrder());
		} else if (sortDirection == -1) {
			wordsPicked.sort(Comparator.reverseOrder());
		}
		
		return wordsPicked;
	}
	
	private static String pickRandomWord(List<String> allWords) {
		Integer randomPosition = Integer.valueOf(new BigDecimal(Math.random()).multiply(new BigDecimal(allWords.size())).setScale(0, RoundingMode.DOWN).toString());
		return allWords.get(randomPosition); 
	}
	
	private static Boolean isImpossibleRequest(Integer wordsSize, Integer amount, Boolean allowDuplicated) {	
		Boolean impossibleRequest = false;
		
		if(!allowDuplicated && amount > wordsSize) {
			impossibleRequest = true;
		}		
		
		return impossibleRequest;
	}
}
