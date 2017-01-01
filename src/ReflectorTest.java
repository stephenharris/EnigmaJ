import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.enigmaj.Reflector;

public class ReflectorTest {
  @Test
  public void testCharactersMappedReflectorB() {
	  Reflector reflectorB = Reflector.B;
	  assertEquals(new Character('Y'), reflectorB.passThrough(new Character('A')));
	  assertEquals(new Character('A'), reflectorB.passThrough(new Character('Y')));
	  
	  assertEquals(new Character('B'), reflectorB.passThrough(new Character('R')));
	  assertEquals(new Character('R'), reflectorB.passThrough(new Character('B')));
	  
	  assertEquals(new Character('C'), reflectorB.passThrough(new Character('U')));
	  assertEquals(new Character('U'), reflectorB.passThrough(new Character('C')));
  }
  
  @Test
  public void testCharactersMappedReflectorC() {
	  Reflector reflectorB = Reflector.C;
	  assertEquals(new Character('D'), reflectorB.passThrough(new Character('J')));
	  assertEquals(new Character('J'), reflectorB.passThrough(new Character('D')));
	  
	  assertEquals(new Character('E'), reflectorB.passThrough(new Character('I')));
	  assertEquals(new Character('I'), reflectorB.passThrough(new Character('E')));
	  
	  assertEquals(new Character('F'), reflectorB.passThrough(new Character('A')));
	  assertEquals(new Character('A'), reflectorB.passThrough(new Character('F')));
  }
  
}