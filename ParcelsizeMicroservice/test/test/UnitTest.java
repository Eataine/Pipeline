package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import main.ParcelSize;

public class UnitTest {
	
	@Test
	public void testSizeXS() {
		ParcelSize size = new ParcelSize();
		size.setWidth("5");
		size.setHeight("5");
		size.setLength("5");
		size.setParcelSize(size.calculateParcelSize());
		
		assertEquals("XS", size.getParcelSize(), "[ERROR] size differs!");
	}

}
