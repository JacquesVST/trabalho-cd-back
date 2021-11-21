package aleatorio.itemaleatorio.number.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import aleatorio.itemaleatorio.number.model.Number;

@Service
public class NumberService {

	public List<BigDecimal> generateRandomNumbers(Number numberRequest) {
		Integer amount = numberRequest.getAmount();
		Integer decimalPlaces = numberRequest.getRange().getDecimalPlaces();		
		Integer sortDirection = numberRequest.getSortDirection();		
		Boolean allowDuplicated = numberRequest.getAllowDuplicated();		
		BigDecimal min = numberRequest.getRange().getMin().setScale(decimalPlaces, RoundingMode.DOWN);
		BigDecimal max = numberRequest.getRange().getMax().setScale(decimalPlaces, RoundingMode.DOWN);
		List<BigDecimal> numbers = new ArrayList<>();
		
		if(isImpossibleRequest(min, max, decimalPlaces, amount, allowDuplicated)) {
			return numbers;
		}
		
		
		for(Integer i=0; i<amount; i++) {
			BigDecimal number = generateRandomNumber(min, max, decimalPlaces);
			
			while(!allowDuplicated && numbers.contains(number)) {
				number = generateRandomNumber(min, max, decimalPlaces);
			}
			
			numbers.add(number);
		}
		
		if(sortDirection == 1) {
			numbers.sort(Comparator.naturalOrder());
		} else if (sortDirection == -1) {
			numbers.sort(Comparator.reverseOrder());
		}
		
		return numbers;
	}
	
	private static BigDecimal generateRandomNumber(BigDecimal min, BigDecimal max, Integer decimalPlaces) {
		BigDecimal random = new BigDecimal(Math.random()).setScale(decimalPlaces+1, RoundingMode.UP);
		BigDecimal number = min.add(random.multiply(max.subtract(min)));
		number = number.setScale(decimalPlaces, RoundingMode.DOWN);
		return number;
	}
	
	private static Boolean isImpossibleRequest(BigDecimal min, BigDecimal max, Integer decimalPlaces, Integer amount, Boolean allowDuplicated) {
		BigDecimal maxCases = max.multiply(new BigDecimal("10").pow(decimalPlaces));		
		BigDecimal minCases = min.multiply(new BigDecimal("10").pow(decimalPlaces));		
		Integer amountBiggerThanNumberRange = new BigDecimal(amount).compareTo(maxCases.subtract(minCases).add(new BigDecimal("1")));		
		Boolean impossibleRequest = false;
		
		if(!allowDuplicated && amountBiggerThanNumberRange == 1) {
			impossibleRequest = true;
		}		
		
		return impossibleRequest;
	}
	
}
