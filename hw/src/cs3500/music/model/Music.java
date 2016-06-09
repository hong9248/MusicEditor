package cs3500.music.model;
import java.util.*;

public class Music implements IMusicEditor {

  private List<Note> allNotes;
  // The consolidated music piece
  private TreeMap<Integer, TreeMap<Integer, Note>> wholeMusic;

  public Music() {
    allNotes = new ArrayList<>();
    wholeMusic = new TreeMap<>();
  }

  @Override
  public void addNote(Note note) {
    if (allNotes.contains(note)) ;
    for (int i = 0; i < allNotes.size(); i++) {
      if (note.isCross(allNotes.get(i))) {
        int maxStart = Math.max(note.getStartBeat(), allNotes.get(i).getStartBeat());
        int minStart = Math.min(note.getStartBeat(), allNotes.get(i).getStartBeat());
        int maxEnd = Math.max(note.getEndBeat(), allNotes.get(i).getEndBeat());
        int minEnd = Math.min(note.getEndBeat(), allNotes.get(i).getEndBeat());
        Pitch pitch = allNotes.get(i).getPitch();
        allNotes.remove(note);
        if (minStart == maxStart - 1 || minStart == maxStart) {
          Note note1 = new Note(maxStart, maxEnd, pitch);
          allNotes.add(note1);
        } else {
          Note note1 = new Note(maxStart, maxEnd, pitch);
          Note note2 = new Note(minStart, minEnd, pitch);
          allNotes.add(note1);
          allNotes.add(note2);
        }
      }
    }
    this.updateMusic();
  }

  private void updateMusic() {
    wholeMusic = new TreeMap<>();
    for (int i = 0; i < allNotes.size(); i++) {
      TreeMap<Integer, Pitch> position = allNotes.get(i).getPosition();
      List<Note> values = wholeMusic.get(position);
      values.add(allNotes.get(i));
      wholeMusic.put(position, values);
    }
  }


  @Override
  public void removeNote(Note note) {
    if (!allNotes.contains(note)) {
      throw new IllegalArgumentException("Sorry, the note does not exist");
    } else {
      allNotes.remove(note);
    }
    this.updateMusic();
  }

  @Override
  public void editNote(Note note, int NewStartBeat, int NewEndBeat, Pitch pitch) {
    if (!allNotes.contains(note)) {
      throw new IllegalArgumentException("Sorry, the note does not exist");
    } else {
      this.removeNote(note);
      this.addNote(new Note(NewStartBeat, NewEndBeat, pitch));
    }
    this.updateMusic();
  }

  @Override
  public List<Note> getAllNotes() {
    return this.allNotes;
  }

  @Override
  Note getNote(int start, int end, Pitch pitch) {

  }
}
