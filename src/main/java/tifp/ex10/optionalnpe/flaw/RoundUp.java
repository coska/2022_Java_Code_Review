package tifp.ex10.optionalnpe.flaw;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.util.Objects;

public class RoundUp {

	public Object halfRoundUp(Object input) {
		final String valueInString = Objects.toString(input, "").trim();
		if (!valueInString.isEmpty()) {
			final BigDecimal number = new BigDecimal(valueInString);
			if (number.scale() > 2) {
				return number.setScale(2, HALF_UP).toString();
			}
		}
		return input;
	}
}
