package aleatorio.itemaleatorio.number.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Number {
	
	private Range range;
	private Integer amount;
	private Integer sortDirection;
	private Boolean allowDuplicated;
	
}
