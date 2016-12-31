
public enum RotorProperty {

    I ( "EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'),
    II ( "AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
    III ( "BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'),
	IV ( "ESOVPZJAYQUIRHXLNFTGKDCMWB", 'J'),
	V ( "VZBRGITYUPSDNHLXAWMJQOFECK", 'Z');

    private final String wiringKey;
    private final Character notchPosition;
    RotorProperty(String wiringKey, Character notchPosition) {
        this.wiringKey = wiringKey.toUpperCase();
        this.notchPosition = Character.toUpperCase(notchPosition);
    }
    public String wiringKey() { return wiringKey; }
    public Character notchPosition() { return notchPosition; }

}