package myFirstPackage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FuelConsumptionTest1 {

	@Test
	void testGetMoneyAmount() {
		Assert.assertEquals("4000,00", FuelConsumption.GetMoneyAmount("1000", "40", "10"));
		Assert.assertEquals("0,00", FuelConsumption.GetMoneyAmount("0", "40", "10"));
		Assert.assertEquals(FuelConsumption.ERROR_MESSAGE, FuelConsumption.GetMoneyAmount("qwe", "40", "10"));
		Assert.assertEquals(FuelConsumption.ERROR_MESSAGE, FuelConsumption.GetMoneyAmount("", "", ""));
	}
}