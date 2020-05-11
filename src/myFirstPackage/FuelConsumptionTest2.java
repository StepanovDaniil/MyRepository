package myFirstPackage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FuelConsumptionTest2 {

	@Test
	void testGetMoneyAmount() {
		Assert.assertEquals("150,00", FuelConsumption.GetMoneyAmount("50", "30", "10"));
		Assert.assertEquals("0,00", FuelConsumption.GetMoneyAmount("0", "0", "0"));
		Assert.assertEquals("0,01", FuelConsumption.GetMoneyAmount("1", "1", "1"));
		Assert.assertEquals(FuelConsumption.ERROR_MESSAGE, FuelConsumption.GetMoneyAmount("", "", ""));
	}
}