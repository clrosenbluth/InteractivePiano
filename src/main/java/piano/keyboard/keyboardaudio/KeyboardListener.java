package piano.keyboard.keyboardaudio;

import piano.keyboard.keyboardui.PianoLabel;
import piano.recorder.Recorder;

import javax.sound.midi.MidiChannel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private final Recorder recorder;
    private final MidiChannel midiChannel;

    public KeyboardListener(Recorder recorder, MidiChannel midiChannel) {
        this.recorder = recorder;
        this.midiChannel = midiChannel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        PianoLabel pianoLabel;
        int position;
        switch (key) {
            case '1':
                position = 0;
                break;
            case '!':
                position = 1;
                break;
            case '2':
                position = 2;
                break;
            case '@':
                position = 3;
                break;
            case '3':
                position = 4;
                break;
            case '4':
                position = 5;
                break;
            case '$':
                position = 6;
                break;
            case '5':
                position = 7;
                break;
            case '%':
                position = 8;
                break;
            case '6':
                position = 9;
                break;
            case '^':
                position = 10;
                break;
            case '7':
                position = 11;
                break;
            case '8':
                position = 12;
                break;
            case '*':
                position = 13;
                break;
            case '9':
                position = 14;
                break;
            case '(':
                position = 15;
                break;
            case '0':
                position = 16;
                break;
            case 'q':
                position = 17;
                break;
            case 'Q':
                position = 18;
                break;
            case 'w':
                position = 19;
                break;
            case 'W':
                position = 20;
                break;
            case 'e':
                position = 21;
                break;
            case 'E':
                position = 22;
                break;
            case 'r':
                position = 23;
                break;
            case 't':
                position = 24;
                break;
            case 'T':
                position = 25;
                break;
            case 'y':
                position = 26;
                break;
            case 'Y':
                position = 27;
                break;
            case 'u':
                position = 28;
                break;
            case 'i':
                position = 29;
                break;
            case 'I':
                position = 30;
                break;
            case 'o':
                position = 31;
                break;
            case 'O':
                position = 32;
                break;
            case 'p':
                position = 33;
                break;
            case 'P':
                position = 34;
                break;
            case 'a':
                position = 35;
                break;
            default:
                position = -1;
        }

        if (position != -1) {
            pianoLabel = new PianoLabel(Color.BLACK, Color.BLUE, new Key(position, midiChannel));
            pianoLabel.play();
        }
        }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
