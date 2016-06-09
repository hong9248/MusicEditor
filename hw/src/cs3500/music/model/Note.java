package cs3500.music.model;
import java.util.*;

public class Note {
  private int startBeat;
  private int endBeat;
  private Pitch pitch;

  /**
   * Constructor for class Note whose start time, end time, and pitch is given.
   *
   * @param startBeat The start time of the note.
   * @param endBeat   The end time of the note.
   * @param pitch     The pitch of the note.
   */
  public Note(int startBeat, int endBeat, Pitch pitch) {
    assert startBeat > 0 &&  endBeat > startBeat;
    this.startBeat = startBeat;
    this.endBeat = endBeat;
    this.pitch = pitch;
  }

  /**
   * Judge that whether the current note has across with other note at a certain time.
   *
   * @param that The other note to be compared.
   * @return True if the current note has the same pitch and same certain beats points with
   * the other note
   */
  public boolean isCross(Note that) {
    if (!this.pitch.equals(that.pitch)) {
      return false;
    }
    if(this.startBeat == that.startBeat || this.endBeat == that.endBeat ||
            this.startBeat == that.endBeat || this.endBeat == that.startBeat) {
      return true;
    }
    if (this.startBeat > that.startBeat) {
      return this.startBeat < that.endBeat;
    } else {
      return this.endBeat > that.startBeat;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Note note = (Note) o;

    if (startBeat != note.startBeat) return false;
    if (endBeat != note.endBeat) return false;
    return pitch == note.pitch;

  }

  @Override
  public int hashCode() {
    int result = startBeat;
    result = 31 * result + endBeat;
    result = 31 * result + pitch.hashCode();
    return result;
  }

  public void startBeatSetter(int startBeat) {
    this.startBeat = startBeat;
  }

  public void endBeatSetter(int endBeat) {
    this.endBeat = endBeat;
  }

  public int getStartBeat() {
    return this.startBeat;
  }

  public int getEndBeat() {
    return this.endBeat;
  }

  public Pitch getPitch() {
    return this.pitch;
  }

  public TreeMap<Integer, Pitch> getPosition() {
    return this.position;
  }

}
