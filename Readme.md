# EnigmaJ

A Java simulator of the Enigma machine.

The program currently only supports Enigma I, with the following planned:

- Enigma M3 (3 additional rotors, which have two turnover points) 
- Enigma M4 (M3 and Zusatzwalze, Beta & Gamma )

It does not provide a user interface, but a simple API for encrypting messages:

	// Rotors: I, II, III with inital setting of AAZ and ring setting of 1 foreach rotor
    Rotor left = new Rotor( RotorProperty.I, 'A', 'A' );
    Rotor middle = new Rotor( RotorProperty.II, 'A', 'A' );
    Rotor right = new Rotor( RotorProperty.III, 'Z', 'A' );
    
    PlugBoard plugBoard = new PlugBoard( "EN IG MA" );
    
    Enigma enigma = new Enigma( left, middle, right, plugBoard, Reflector.B );
	  
	String ciphertext = enigma.encrypt("HELLOWORLD"));

**Questions? Bugs? Please open an issue**.

## License

EnigmaJ is open source and released under MIT license. See LICENSE file for more info.

## Resources:

The following resources have been invaluable in building and testing this project:

- https://people.physik.hu-berlin.de/~palloks/js/enigma/enigma-u_v20_en.html
- https://www.codesandciphers.org.uk/enigma/rotorspec.htm
- http://users.telenet.be/d.rijmenants/Enigma%20Sim%20Manual.pdf
