package com.enigmaj;

public class Enigma {

	private Rotor rightRotor;
	private Rotor middleRotor;
	private Rotor leftRotor;
	private Reflector reflector;
	private PlugBoard plugBoard;

	public Enigma( Rotor left, Rotor middle, Rotor right, PlugBoard plugBoard, Reflector reflector ) {
		this.plugBoard = plugBoard;

		this.rightRotor = right;
		this.middleRotor = middle;
		this.leftRotor = left;

		this.reflector = reflector;
	}

	public String encrypt( String in ) {
		char[] letters = in.toCharArray();
		String out = "";
		for(char letter:letters){
			Character encryptedLetter = this.encrypt(new Character(letter));
			out = out + encryptedLetter;
		}
		return out;
	}

	public Character encrypt( Character in ) {

		in = Character.toUpperCase(in);

		if ( this.middleRotor.atNotchPosition() ) {
			this.leftRotor.rotate();
			this.middleRotor.rotate();
		} else if ( this.rightRotor.atNotchPosition() ) {
			this.middleRotor.rotate();
		}

		this.rightRotor.rotate();

		Character out0 = this.plugBoard.passThrough( in );
		Character out1 = this.rightRotor.passThrough( out0 );
		Character out2 = this.middleRotor.passThrough( out1 );
		Character out3 = this.leftRotor.passThrough( out2 );
		Character reflected = this.reflector.passThrough( out3 );
		Character out4 = this.leftRotor.passThroughInverse( reflected );
		Character out5 = this.middleRotor.passThroughInverse( out4 );
		Character out6 = this.rightRotor.passThroughInverse( out5 );
		Character out7 = this.plugBoard.passThrough( out6 );
		/*System.out.println(
		"(" + this.leftRotor.position() + this.middleRotor.position() + this.rightRotor.position() + ") "
		 + in + "     ->" + out0 + "->" + out1 + "->" + out2 + "->" + out3 + "->"
		 + reflected + "->"
		 + out4+ "->" + out5 + "->" + out6 + "->     " + out7
		);*/
		return out7;
	}

}
