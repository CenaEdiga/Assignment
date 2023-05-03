package testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

  class TestPalendrome{
	@Test
	public void testPal(){
		assertTrue(palendrome.Palen("level"));
		assertTrue(palendrome.Palen("RacecaR"));
		assertTrue(palendrome.Palen("GadaG"));
	}
	@Test
	public void testPal1(){
		assertTrue(palendrome.Palen("maan"));
		assertTrue(palendrome.Palen("RacecaR"));
		assertTrue(palendrome.Palen("GadaG"));
	}
}

