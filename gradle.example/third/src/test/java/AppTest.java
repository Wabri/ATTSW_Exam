
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
	
	@Test
	public void testAppHasAGreeting() {
		App classUnderTest = new App();
		assertNotNull("app should have a greeting", classUnderTest.getGreeting());
	}

	@Test
	public void helloWorldSendTest() {
		App classUnderTest = new App();
		assertEquals("Greetings", classUnderTest.getGreeting());
	}
}
