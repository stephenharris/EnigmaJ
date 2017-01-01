import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.enigmaj.Rotor;
import com.enigmaj.RotorProperty;

public class RotorTest {

  @Test
  public void testRotor1() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );;
	  assertEquals(new Character('E'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('O'), rotor1.passThrough(new Character('M')));
	  assertEquals(new Character('J'), rotor1.passThrough(new Character('Z')));
  }
  
  @Test
  public void testRotor1Rotated() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );;
	  assertEquals(new Character('A'), rotor1.position());
	  
	  assertEquals(new Character('J'), rotor1.passThrough(new Character('Z')));
	  assertEquals(new Character('E'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('K'), rotor1.passThrough(new Character('B')));
	  
	  rotor1.rotate();
	  assertEquals(new Character('B'), rotor1.position());
	  
	  assertEquals(new Character('D'), rotor1.passThrough(new Character('Z')));
	  assertEquals(new Character('J'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('L'), rotor1.passThrough(new Character('B')));
  }
  
  @Test
  public void testRotatingLoopsBackToA() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  rotor1.setPosition('Z');
	  assertEquals(new Character('Z'), rotor1.position());
	  rotor1.rotate();
	  assertEquals(new Character('A'), rotor1.position());
  }
  
  @Test
  public void testName() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  Rotor rotor2 = new Rotor( RotorProperty.II );
	  Rotor rotor3 = new Rotor( RotorProperty.III );
	  Rotor rotor4 = new Rotor( RotorProperty.IV );
	  Rotor rotor5 = new Rotor( RotorProperty.V );
	  assertEquals("I", rotor1.name());
	  assertEquals("II", rotor2.name());
	  assertEquals("III", rotor3.name());
	  assertEquals("IV", rotor4.name());
	  assertEquals("V", rotor5.name());
  }
  
  

  @Test
  public void testAtNotchPosition() {
	  Rotor rotor = new Rotor( RotorProperty.II );
	  rotor.setPosition('C');
	  assertFalse(rotor.atNotchPosition());
	  
	  rotor.rotate(); //now at D
	  assertFalse(rotor.atNotchPosition());
	  
	  rotor.rotate();//now at E
	  assertTrue(rotor.atNotchPosition());
  }
  
  @Test
  public void testAtNotchPositionWithRingSetting() {
	  Rotor rotor = new Rotor( RotorProperty.II );
	  rotor.setPosition('D');
	  rotor.setRingSetting('B');

	  assertFalse(rotor.atNotchPosition());
	  //TODO Is this right?
	  rotor.rotate(); //now at E
	  assertTrue(rotor.atNotchPosition());
  }
  
  @Test
  public void testRotor1Inverse() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  assertEquals(new Character('E'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('A'), rotor1.passThroughInverse(new Character('E')));
	  
	  rotor1.rotate();
	  assertEquals(new Character('J'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('A'), rotor1.passThroughInverse(new Character('J')));
  }

  @Test
  public void testRingSetting() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  rotor1.setRingSetting('B');
	  assertEquals(new Character('K'), rotor1.passThrough(new Character('A')));
	  
	  rotor1.rotate();
	  assertEquals(new Character('E'), rotor1.passThrough(new Character('A')));
  }
  
}