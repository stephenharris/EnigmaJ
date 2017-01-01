import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.enigmaj.Enigma;
import com.enigmaj.PlugBoard;
import com.enigmaj.Reflector;
import com.enigmaj.Rotor;
import com.enigmaj.RotorProperty;

public class EnigmaTest {
  @Test
  public void testWithoutRingSetting() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  Rotor rotor2 = new Rotor( RotorProperty.II );
	  Rotor rotor3 = new Rotor( RotorProperty.III );
	  rotor3.setPosition('Z');
	  PlugBoard plugBoard = new PlugBoard( "" );
	  Enigma enigma = new Enigma( rotor1, rotor2, rotor3, plugBoard, Reflector.B );
	  
	  assertEquals( "UBDZGOWCXLTKSBTMCDLPBMUQOF", enigma.encrypt("AAAAAAAAAAAAAAAAAAAAAAAAAA"));
  }
  
  @Test
  public void testRotorStepsWithRingSetting() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  rotor1.setPosition('A');
	  rotor1.setRingSetting('B');
	  Rotor rotor2 = new Rotor( RotorProperty.II );
	  rotor2.setPosition('D');
	  rotor2.setRingSetting('C');
	  Rotor rotor3 = new Rotor( RotorProperty.III );
	  rotor3.setPosition('U');
	  rotor3.setRingSetting('D');

	  PlugBoard plugBoard = new PlugBoard( "" );
	  Enigma enigma = new Enigma( rotor1, rotor2, rotor3, plugBoard, Reflector.B );
	  
	  assertEquals( 
			  "IVAKQJAKYEQHKEGSNRSQUSSGOIBFSMDZXFMPOJMZDQBHWCDCFBRCQWLFSVZMYWDUSUNFEUGUWYJKAXFVVESYFZXDGCRSIUQJTCRJSRUTFFXROUTOTWCEPHPRENCXDUYMUTOOLUCBVMNTLTZRFEJWUSMYVWCSKCWMYYEJLZFZLMFNYFUFFNNUUAPQGMVYZWCYWXZTPILXWSYTKANVAHPPGPTUCJWWQXDAGLOUOVTFQRHEWOSLQNVGLQWPSDZOZTTFUQMEJHKUIMAGGGNUBRJRPVTKSZCTWVFVJRMFNNNYCNXPPMOXOASKUTNTNABCDBNMJPPVULRIUFAUPFFWGHPBSQUUCLNMBYVVPVATOXMXNNADVSZFQWBCIEHVEVMVTUZPGXFMYDZUNSHFFWQRHLLSEDOUPJEQOCDFZ", 
			  enigma.encrypt("THENEWFORMOFTHEPROBLEMCANBEDESCRIBEDINTERMSOFAGAMEWHICHWECALLTHEIMITATIONGAMEITISPLAYEDWITHTHREEPEOPLEAMANAAWOMANBANDANINTERROGATORCWHOMAYBEOFEITHERSEXTHEINTERROGATORSTAYSINAROOMAPARTFRONTTHEOTHERTWOTHEOBJECTOFTHEGAMEFORTHEINTERROGATORISTODETERMINEWHICHOFTHEOTHERTWOISTHEMANANDWHICHISTHEWOMANHEKNOWSTHEMBYLABELSXANDYANDATTHEENDOFTHEGAMEHESAYSEITHERXISAANDYISBORXISBANDYISATHEINTERROGATORISALLOWEDTOPUTQUESTIONSTOAANDB")
			  );
  }
  
  @Test
  public void testWithPlugboardSetting() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  Rotor rotor2 = new Rotor( RotorProperty.II );
	  Rotor rotor3 = new Rotor( RotorProperty.III );

	  PlugBoard plugBoard = new PlugBoard( "PO ML IU KJ NH YT GB VF RE DC" );
	  Enigma enigma = new Enigma( rotor1, rotor2, rotor3, plugBoard, Reflector.B );
	  
	  assertEquals( 
			  "HQXELGHHPUUMBVBYLBUZGIMBBXQNQLELEDEJNDIMIDLDIWQRBFKRPVNMJWNWVIZCEWZAHDTJMOENMHPFFOQFXQOQDQJHWNDCNQSNFKGQZCRCXBDXQVUBHIFRUMTXYARXTYIRCRQLOCKJDLTARPVPVEPBSFNNUQRBYJMGLNDWNSSNYOJDTLW", 
			  enigma.encrypt("THEINTELLIGENCEWHICHHASEMANATEDFROMYOUBEFOREANDDURINGTHISCAMPAIGNHASBEENOFPRICELESSVALUETOMEITHASSIMPLIFIEDMYTASKASACOMMANDERENORMOUSLYITHASSAVEDTHOUSANDSOFBRITISHANDAMERICANLIVES")
			  );
  }
  
  @Test
  public void testWithRingSetting() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  rotor1.setRingSetting('B');
	  Rotor rotor2 = new Rotor( RotorProperty.II );;
	  rotor2.setRingSetting('C');
	  Rotor rotor3 = new Rotor( RotorProperty.III );
	  rotor3.setRingSetting('D');

	  PlugBoard plugBoard = new PlugBoard( "" );
	  Enigma enigma = new Enigma( rotor1, rotor2, rotor3, plugBoard, Reflector.B );
	  
	  assertEquals( 
			  "DAIFXGNBAZQAWEAFIGTLNNOCPWHMUYADDBKJTMSLXMF", 
			  enigma.encrypt("MYGEESETHATLAIDTHEGOLDENEGGSBUTNEVERCACKLED")
			  );
  }

  @Test
  public void testRotorRotations() {
	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  rotor1.setPosition('A');
	  Rotor rotor2 = new Rotor( RotorProperty.II );
	  rotor2.setPosition('A');
	  Rotor rotor3 = new Rotor( RotorProperty.III );
	  rotor3.setPosition('U');
	  
	  PlugBoard plugBoard = new PlugBoard( "" );
	  Enigma enigma = new Enigma( rotor1, rotor2, rotor3, plugBoard, Reflector.B );
	  
	 
	  //Right rotor always rotates. Rotates into its notch position.
	  enigma.encrypt("A");
	  assertEquals( new Character('A'), rotor1.position() );
	  assertEquals( new Character('A'), rotor2.position() );
	  assertEquals( new Character('V'), rotor3.position() );
	  
	  //Right rotor rotates and rotates middle rotor
	  enigma.encrypt("A");
	  assertEquals( new Character('A'), rotor1.position() );
	  assertEquals( new Character('B'), rotor2.position() );
	  assertEquals( new Character('W'), rotor3.position() );
	  
	  //Right rotor rotates again
	  enigma.encrypt("A");
	  assertEquals( new Character('A'), rotor1.position() );
	  assertEquals( new Character('B'), rotor2.position() );
	  assertEquals( new Character('X'), rotor3.position() );
  }
  
  @Test
  public void testDoubleStep() {

	  Rotor rotor1 = new Rotor( RotorProperty.I );
	  rotor1.setPosition('A');
	  Rotor rotor2 = new Rotor( RotorProperty.II );
	  rotor2.setPosition('D');
	  Rotor rotor3 = new Rotor( RotorProperty.III );
	  rotor3.setPosition('U');
	  
	  PlugBoard plugBoard = new PlugBoard( "" );
	  Enigma enigma = new Enigma( rotor1, rotor2, rotor3, plugBoard, Reflector.B );
	 
	  //Right rotor always rotates. Rotates into its notch position.
	  enigma.encrypt("A");
	  assertEquals( new Character('A'), rotor1.position() );
	  assertEquals( new Character('D'), rotor2.position() );
	  assertEquals( new Character('V'), rotor3.position() );
	  
	  //Right rotor rotates and rotates middle rotor, which is now in its notch position
	  enigma.encrypt("A");
	  assertEquals( new Character('A'), rotor1.position() );
	  assertEquals( new Character('E'), rotor2.position() );
	  assertEquals( new Character('W'), rotor3.position() );
	  
	  //Right rotor rotates as normal. Double step of middle rotor. Left rotor rotates. 
	  enigma.encrypt("A");
	  assertEquals( new Character('B'), rotor1.position() );
	  assertEquals( new Character('F'), rotor2.position() );
	  assertEquals( new Character('X'), rotor3.position() );
	  
	  //Right rotor rotates as normal. 
	  enigma.encrypt("A");
	  assertEquals( new Character('B'), rotor1.position() );
	  assertEquals( new Character('F'), rotor2.position() );
	  assertEquals( new Character('Y'), rotor3.position() );
  }
  
  
}