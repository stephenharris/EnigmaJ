package com.enigmaj;

import java.util.*;

public class Rotor {

	private Map<Character, Character> wiring;

	private Map<Character, Character> inverseWiring;

	private RotorProperty rotorProperty; 
	
	private int position;

	private int notchPosition;

	private int ringSetting;

	private List<Character> alphabet;

	/**
	 * 
	 * @param rotorProperty Hard-coded wirings of pre-built rotors (I through V).
	 * @param start The character the rotor is initialised to.
	 * @param ringSetting Ring setting as a character ('A'=1, 'B'=2). Internally,
	 *                    the ring setting is stored as an integer ('A'=0,...,'Z'=25)
	 */
	public Rotor( RotorProperty rotorProperty ) {

		this.alphabet = new ArrayList<>(Arrays.asList(
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
		));

		this.wiring = new HashMap<Character, Character>();
		for (int i = 0;i < rotorProperty.wiringKey().length(); i++){
			this.wiring.put( this.alphabet.get(i), rotorProperty.wiringKey().charAt(i) );
		}

		this.inverseWiring = new HashMap<Character, Character>();
		for(Map.Entry<Character, Character> entry : this.wiring.entrySet()){
			this.inverseWiring.put(entry.getValue(), entry.getKey());
		}

		this.rotorProperty = rotorProperty;
		this.notchPosition = this.alphabet.indexOf(rotorProperty.notchPosition());
		this.position = 0;
		this.ringSetting = 0;
	}
	
	public String name() {
		return this.rotorProperty.name();
	}
	
	public void setPosition( Character positionCharacter ) {
		this.position = this.alphabet.indexOf(Character.toUpperCase(positionCharacter));
	}	
	
	public void setRingSetting( Character ringSetting ) {
		this.ringSetting = this.alphabet.indexOf(Character.toUpperCase(ringSetting));
	}

	public Character passThrough( Character in ) {
		//rotate alphabet
		int inIndex = ( this.alphabet.indexOf(in) + this.position + 26 - this.ringSetting ) % 26;
		Character rotatedIn = this.alphabet.get( inIndex );
		Character mapped = this.wiring.get(rotatedIn);;
		int outIndex = ( this.alphabet.indexOf(mapped)  + 26 - this.position + this.ringSetting ) % 26;
		return this.alphabet.get( outIndex );
	}

	public Character passThroughInverse( Character in ) {
		int inIndex = ( this.alphabet.indexOf(in) + this.position  + 26 - this.ringSetting ) % 26;
		Character rotatedIn = this.alphabet.get( inIndex );
		Character mapped = this.inverseWiring.get(rotatedIn);;
		int outIndex = ( this.alphabet.indexOf(mapped)  + 26 - this.position + this.ringSetting ) % 26;
		return this.alphabet.get( outIndex );
	}

	public void rotate() {
		this.position = (this.position + 1)%26;
	}

	public Character position() {
		return this.alphabet.get( this.position );
	}

	public boolean atNotchPosition() {
		return this.position == this.notchPosition;
	}

}
