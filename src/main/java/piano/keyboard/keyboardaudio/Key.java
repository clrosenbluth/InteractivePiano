package piano.keyboard.keyboardaudio;

import javax.sound.midi.MidiChannel;

public class Key
{
	static final String[] noteNames = new String[] { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };

	private int pitch;
	private String name;
	private MidiChannel midiChannel;

	public Key(int position, MidiChannel midiChannel) {
		pitch = position + Notes.startingC;
		this.name = noteNames[pitch % 12];
		this.midiChannel = midiChannel;
	}

	public String getName() {
		return this.name;
	}

	public void play() {
		SoundThread s = new SoundThread(pitch, midiChannel); // pass in pitch to play
		s.start();
	}
}
