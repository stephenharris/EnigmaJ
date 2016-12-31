import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlugBoardTest {
	  
  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
	  
  @Test
  public void testEmptyPlugboard() {
	  PlugBoard plugBoard = new PlugBoard( "" );
	  assertEquals(new Character('P'), plugBoard.passThrough(new Character('P')));
  }

  @Test
  public void testNullPlugboard() {
	  PlugBoard plugBoard = new PlugBoard( null );
	  assertEquals(new Character('C'), plugBoard.passThrough(new Character('C')));
  }
  
  @Test
  public void testPlugboardSymmetry() {
	  PlugBoard plugBoard = new PlugBoard( "PO ML IU KJ NH YT GB VF RE DC" );
	  assertEquals(new Character('O'), plugBoard.passThrough(new Character('P')));
	  assertEquals(new Character('P'), plugBoard.passThrough(new Character('O')));
	  
	  assertEquals(new Character('Y'), plugBoard.passThrough(new Character('T')));
	  assertEquals(new Character('T'), plugBoard.passThrough(new Character('Y')));
	  
	  assertEquals(new Character('D'), plugBoard.passThrough(new Character('C')));
	  assertEquals(new Character('C'), plugBoard.passThrough(new Character('D')));
  }
  
  @Test
  public void testLOwercaseWiringKey() {
	  PlugBoard plugBoard = new PlugBoard( "po ML IU KJ NH YT GB VF RE DC" );
	  assertEquals(new Character('O'), plugBoard.passThrough(new Character('P')));
	  assertEquals(new Character('P'), plugBoard.passThrough(new Character('O')));
  }
   
  @Test
  public void testCharactersNotSwitched() {
	  PlugBoard plugBoard = new PlugBoard( "PO ML IU KJ NH YT GB VF RE DC" );
	  assertEquals(new Character('A'), plugBoard.passThrough(new Character('A')));
  }


  @Test
  public void testDuplicateCharacterThrowsException() throws Exception {
      expectedEx.expect(RuntimeException.class);
      expectedEx.expectMessage("Character L appears multiple times. Each character can appear at most once.");
      
      new PlugBoard( "BL ET CH LE YP" ); //duplicate E and L
  }
  

  @Test
  public void testNumericCharacterThrowsException() throws Exception {
      expectedEx.expect(RuntimeException.class);
      expectedEx.expectMessage("Wiring key must only contain space delimited alphabet characters.");
      
      new PlugBoard( "AB CD 3F" );
  }

  @Test
  public void testNonAlphaOrSpaceCharacterThrowsException() throws Exception {
      expectedEx.expect(RuntimeException.class);
      expectedEx.expectMessage("Wiring key must only contain space delimited alphabet characters.");
      
      new PlugBoard( "AB	CD" );
  }
  
  @Test
  public void testSpecialCharacterThrowsException() throws Exception {
      expectedEx.expect(RuntimeException.class);
      expectedEx.expectMessage("Wiring key must only contain space delimited alphabet characters.");
      
      new PlugBoard( "AB-CD" );
  }
 
 
}