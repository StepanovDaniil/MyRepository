package myFirstPackage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FuelConsumptionTest3 {

	@Test
	void testGetMoneyAmount() {
		Assert.assertEquals("300,00", FuelConsumption.GetMoneyAmount("100", "30", "10"));
		Assert.assertEquals("0,00", FuelConsumption.GetMoneyAmount("100", "0", "10"));
		Assert.assertEquals(FuelConsumption.ERROR_MESSAGE, FuelConsumption.GetMoneyAmount("100", "asdasdasda", "10"));
		Assert.assertEquals(FuelConsumption.ERROR_MESSAGE, FuelConsumption.GetMoneyAmount("", "", ""));
	}
}