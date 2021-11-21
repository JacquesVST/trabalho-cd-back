package aleatorio.itemaleatorio.word.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aleatorio.itemaleatorio.word.model.Word;
import aleatorio.itemaleatorio.word.service.WordService;

@RestController
@RequestMapping("/word")
public class WordController {

	@Autowired
	private WordService wordService;
	
	@PostMapping
	public ResponseEntity<List<String>> wordsPicker(@RequestBody Word WordRequest){
		List<String> words = wordService.wordPicker(WordRequest);
		return ResponseEntity.ok(words);
	}
}
