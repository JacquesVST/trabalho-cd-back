package aleatorio.itemaleatorio.word.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Word {
	
	private List<String> words;
	private Integer amount;
	private Integer sortDirection;
	private Boolean allowDuplicated;
	
}
