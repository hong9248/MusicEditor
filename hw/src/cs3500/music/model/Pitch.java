package cs3500.music.model;

/**
 * In this emun there are different pitches. Because human hearing can detect about ten octaves of
 * notes, then I add other 120 pitches into the enum Pitch.
 */
public enum Pitch {

  C1("C1", 1), C_SHARP1("C#1", 2), D1("D1", 3), D_SHARP1("D#1", 4), E1("E1", 5),
  F1("F1", 6), F_SHARP1("F#1", 7), G1("G1", 8), G_SHARP1("G#1", 9), A1("A1", 10),
  A_SHARP1("A#1", 11), B1("B1", 12),

  C2("C2", 13), C_SHARP2("C#2", 14), D2("D2", 15), D_SHARP2("D#2", 16), E2("E2", 17),
  F2("F2", 18), F_SHARP2("F#2", 19), G2("G2", 20), G_SHARP2("G#2", 21), A2("A2", 22),
  A_SHARP2("A#2", 23), B2("B2", 24),

  C3("C3", 25), C_SHARP3("C#3", 26), D3("D3", 27), D_SHARP3("D#3", 28), E3("E3", 29),
  F3("F3", 30), F_SHARP3("F#3", 31), G3("G3", 32), G_SHARP3("G#3", 33), A3("A3", 34),
  A_SHARP3("A#3", 35), B3("B3", 36),

  C4("C4", 37), C_SHARP4("C#4", 38), D4("D4", 39), D_SHARP4("D#4", 40), E4("E4", 41),
  F4("F4", 42), F_SHARP4("F#4", 43), G4("G4", 44), G_SHARP4("G#4", 45), A4("A4", 46),
  A_SHARP4("A#4", 47), B4("B4", 48),

  C5("C5", 49), C_SHARP5("C#5", 50), D5("D5", 51), D_SHARP5("D#5", 52), E5("E5", 53),
  F5("F5", 54), F_SHARP5("F#5", 55), G5("G5", 56), G_SHARP5("G#5", 57), A5("A5", 58),
  A_SHARP5("A#5", 59), B5("B5", 60),

  C6("C6", 61), C_SHARP6("C#6", 62), D6("D6", 63), D_SHARP6("D#6", 64), E6("E6", 65),
  F6("F6", 66), F_SHARP6("F#6", 67), G6("G6", 68), G_SHARP6("G#6", 69), A6("A6", 70),
  A_SHARP6("A#6", 71), B6("B6", 72),

  C7("C7", 73), C_SHARP7("C#7", 74), D7("D7", 75), D_SHARP7("D#7", 76), E7("E7", 77),
  F7("F7", 78), F_SHARP7("F#7", 79), G7("G7", 80), G_SHARP7("G#7", 81), A7("A7", 82),
  A_SHARP7("A#7", 83), B7("B7", 84),

  C8("C8", 85), C_SHARP8("C#8", 86), D8("D8", 87), D_SHARP8("D#8", 88), E8("E8", 89),
  F8("F8", 90), F_SHARP8("F#8", 91), G8("G8", 92), G_SHARP8("G#8", 93), A8("A8", 94),
  A_SHARP8("A#8", 95), B8("B8", 96),

  C9("C9", 97), C_SHARP9("C#9", 98), D9("D9", 99), D_SHARP9("D#9", 100), E9("E9", 101),
  F9("F9", 102), F_SHARP9("F#9", 103), G9("G9", 104), G_SHARP9("G#9", 105), A9("A9", 106),
  A_SHARP9("A#9", 107), B9("B9", 108),

  C10("C10", 109), C_SHARP10("C#10", 110), D10("D10", 111), D_SHARP10("D#10", 112),
  E10("E10", 113), F10("F10", 114), F_SHARP10("F#10", 115), G10("G10", 116),
  G_SHARP10("G#10", 117), A10("A10", 118), A_SHARP10("A#10", 119), B10("B10", 120);

  private String pitchName;
  private int index;

  Pitch(String _pitchName, int _index) {
    this.pitchName = _pitchName;
    this.index = _index;
  }

  public int getIndex() {
    return index;
  }

  public String getPitchName() {
    return pitchName;
  }

}
