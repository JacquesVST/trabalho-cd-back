package aleatorio.itemaleatorio.number.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Range {

	private BigDecimal min;
	private BigDecimal max;
	private Integer decimalPlaces;
	
}
