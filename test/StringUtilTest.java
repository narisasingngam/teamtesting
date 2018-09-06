import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 * @author Kavinthip
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
		assertEquals(-1, StringUtil.indexOf("Orange", fruit));
	}
	
	@Test
	public void testBlankIndexOf() {
		String[] food = {"Chicken", "", "Steak"};
		assertEquals(1, StringUtil.indexOf("", food));
	}
	
	@Test
	public void testNextLineIndexOf() {
		String[] flower = {"Rose", "Lily", "Lavender\n","Jasmine"};
		assertEquals(2, StringUtil.indexOf("Lavender\n", flower));
	}
	
	@Test
	public void testTabIndexOf() {
		String[] nut = {"Almond", "Pecan", "Pistachio\t"};
		assertEquals(2, StringUtil.indexOf("Pistachio\t", nut));
	}
	
}
