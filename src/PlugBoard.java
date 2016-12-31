import java.util.*;

public class PlugBoard {

	private Map<Character, Character> wiring;

	/**
	 * @param wiringKey Space delimited pairs of alphabet characters
	 *                  (e.g. "EN IG MA"), indicating pairs of letters 
	 *                  'plugged' in the plugboard.
	 */
	public PlugBoard( String wiringKey) {

		this.wiring = new HashMap<Character, Character>();

		if(wiringKey == null || wiringKey.isEmpty()) {
			return;
		}

		wiringKey = wiringKey.toUpperCase().trim();
		
		if( !wiringKey.matches("([A-Z]{2})?( [A-Z]{2})+") ){
			throw new RuntimeException( "Wiring key must only contain space delimited alphabet characters.");
		}

		String[] steckeredPairs = wiringKey.split(" ");
		
		for(String steckeredPair:steckeredPairs){
			if ( this.wiring.containsKey(steckeredPair.charAt(0)) ) {
				throw new RuntimeException( "Character " + steckeredPair.charAt(0) + " appears multiple times. Each character can appear at most once." );
			}

			if ( this.wiring.containsKey(steckeredPair.charAt(1)) ) {
				throw new RuntimeException( "Character " + steckeredPair.charAt(1) + " appears multiple times. Each character can appear at most once." );
			}

			this.wiring.put( steckeredPair.charAt(0), steckeredPair.charAt(1) );
			this.wiring.put( steckeredPair.charAt(1), steckeredPair.charAt(0) );
		}

	}

	public Character passThrough( Character in ) {
		if(this.wiring.containsKey(in)) {
			return this.wiring.get(in);
		}
		return in;
	}

}
