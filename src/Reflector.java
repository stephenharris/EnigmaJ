import java.util.*;

public enum Reflector {

	A ( "EJMZALYXVBWFCRQUONTSPIKHGD" ),
	B ( "YRUHQSLDPXNGOKMIEBFZCWVJAT" ),
	C ( "FVPJIAOYEDRZXWGCTKUQSBNMHL" );
	
	private Map<Character, Character> wiring;

	private List<Character> alphabet;

	private Reflector( String wiringKey) {

		wiringKey = wiringKey.toUpperCase();

		this.alphabet = new ArrayList<>(Arrays.asList(
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
		));

		this.wiring = new HashMap<Character, Character>();
		for (int i = 0;i < wiringKey.length(); i++){
			this.wiring.put( this.alphabet.get(i), wiringKey.charAt(i) );
		}
	}

	public Character passThrough( Character in ) {
		return this.wiring.get(in);
	}

}
