package cs3500.music.model;

import java.util.*;
/**
 *To represent an interface of a music model that supports notes with pitch, beat, instrument,
 * and volume.
 */
 public interface IMusicEditor {

  /**
   * Combine two pieces of music such that they play simultaneously.
   *
   * @param  music another piece of music
   * @throws IllegalArgumentException if one of the given values is invalid
   */
  void mergePieceSimultaneously(Music music);

  /**
   * Combine two pieces of music such that they play consecutively.
   *
   * @param  music another piece of music
   * @throws IllegalArgumentException if one of the given values is invalid
   */
  void mergePieceConsecutively(Music music);


  /**
   * Add a new note into the current music piece. If there's a note has across with the new note
   * currently in this music piece, then throw an illegalArguement
   *
   * @param note the note is to be added in the music
   * @throws IllegalArgumentException if one of the given values is invalid
   */
  void addNote(Note note) throws IllegalArgumentException;

  /**
   * edit an existing note to the music editor
   *
   * @param note to be edited
   * @param NewStartBeat give a new starting beat of the note
   * @param NewEndBeat  give an ending beat of the note
   * @param pitch  give a pitch of the note
   * @throws IllegalArgumentException if one of the given values is invalid
   */
  void editNote(Note note, int NewStartBeat, int NewEndBeat, Pitch pitch) throws IllegalArgumentException;

  /**
   * remove a note from the music editor
   *
   * @throws IllegalArgumentException if one of the given values is invalid
   */
  void removeNote(Note note) throws IllegalArgumentException;

  String showMusic();

  Note getNote(int start, int end, Pitch pitch);

  List<Note>  getAllNotes();

}
