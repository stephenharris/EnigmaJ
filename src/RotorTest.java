import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RotorTest {

  @Test
  public void testRotor1() {
	  Rotor rotor1 = new Rotor( RotorProperty.I, 'A', 'A' );
	  assertEquals(new Character('E'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('O'), rotor1.passThrough(new Character('M')));
	  assertEquals(new Character('J'), rotor1.passThrough(new Character('Z')));
  }
  
  @Test
  public void testRotor1Rotated() {
	  Rotor rotor1 = new Rotor( RotorProperty.I, 'A', 'A' );
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
	  Rotor rotor1 = new Rotor( RotorProperty.I, 'Z', 'A' );
	  assertEquals(new Character('Z'), rotor1.position());
	  rotor1.rotate();
	  assertEquals(new Character('A'), rotor1.position());
  }
  

  @Test
  public void testAtNotchPosition() {
	  Rotor rotor1 = new Rotor( RotorProperty.II, 'C', 'A' );
	  assertFalse(rotor1.atNotchPosition());
	  
	  rotor1.rotate(); //now at D
	  assertFalse(rotor1.atNotchPosition());
	  
	  rotor1.rotate();//now at E
	  assertTrue(rotor1.atNotchPosition());
  }
  
  @Test
  public void testAtNotchPositionWithRingSetting() {
	  Rotor rotor1 = new Rotor( RotorProperty.II, 'D', 'B' );
	  assertFalse(rotor1.atNotchPosition());
	  //TODO Is this right?
	  rotor1.rotate(); //now at E
	  assertTrue(rotor1.atNotchPosition());
  }
  
  @Test
  public void testRotor1Inverse() {
	  Rotor rotor1 = new Rotor( RotorProperty.I, 'A', 'A' );
	  assertEquals(new Character('E'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('A'), rotor1.passThroughInverse(new Character('E')));
	  
	  rotor1.rotate();
	  assertEquals(new Character('J'), rotor1.passThrough(new Character('A')));
	  assertEquals(new Character('A'), rotor1.passThroughInverse(new Character('J')));
  }

  @Test
  public void testRingSetting() {
	  Rotor rotor1 = new Rotor( RotorProperty.I, 'A', 'B' );
	  assertEquals(new Character('K'), rotor1.passThrough(new Character('A')));
	  
	  rotor1.rotate();
	  assertEquals(new Character('E'), rotor1.passThrough(new Character('A')));
  }
  
}