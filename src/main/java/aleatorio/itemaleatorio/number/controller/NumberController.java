package aleatorio.itemaleatorio.number.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aleatorio.itemaleatorio.number.model.Number;
import aleatorio.itemaleatorio.number.service.NumberService;

@RestController
@RequestMapping("/numbers")
public class NumberController {

	@Autowired
	private NumberService numberService;
	
	@PostMapping
	public ResponseEntity<List<BigDecimal>> generateRandomNumbers(@RequestBody Number numberRequest){
		List<BigDecimal> numbers = this.numberService.generateRandomNumbers(numberRequest);
		return ResponseEntity.ok(numbers);
	}
}
