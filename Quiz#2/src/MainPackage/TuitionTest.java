package MainPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TuitionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Tuition test1 = new Tuition();
		Tuition test2 = new Tuition();
		Tuition test3 = new Tuition();
		Tuition test4 = new Tuition();
		
		assertTrue(test1.Monthly_Payment(500, 10, 20) == 9.66);
		assertTrue(test2.Monthly_Payment(12560, 20, 5) == 82.89);
		assertTrue(test3.Monthly_Payment(100000, 5, 5) == 1887.12);
		assertTrue(test4.Monthly_Payment(126222, 15, 9) == 1280.22);
	}

}
