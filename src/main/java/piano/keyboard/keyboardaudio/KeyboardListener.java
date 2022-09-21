package piano.keyboard.keyboardaudio;
import piano.keyboard.keyboardui.PianoLabel;
import piano.main.PianoGUI;
import piano.recorder.Recorder;
import javax.sound.midi.MidiChannel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private final Recorder recorder;
    private final MidiChannel midiChannel;
    private PianoGUI pianoGUI;
    private PianoLabel pianoLabel;

    public KeyboardListener(Recorder recorder, MidiChannel midiChannel, PianoGUI pianoGUI) {
        this.recorder = recorder;
        this.midiChannel = midiChannel;
        this.pianoGUI = pianoGUI;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        int position;
        switch (key) {
            case '1':
                position = 0;
                break;
            case '!':
                position = 21;
                break;
            case '2':
                position = 1;
                break;
            case '@':
                position = 22;
                break;
            case '3':
                position = 2;
                break;
            case '4':
                position = 3;
                break;
            case '$':
                position = 23;
                break;
            case '5':
                position = 4;
                break;
            case '%':
                position = 24;
                break;
            case '6':
                position = 5;
                break;
            case '^':
                position = 25;
                break;
            case '7':
                position = 6;
                break;
            case '8':
                position = 7;
                break;
            case '*':
                position = 26;
                break;
            case '9':
                position = 8;
                break;
            case '(':
                position = 27;
                break;
            case '0':
                position = 9;
                break;
            case 'q':
                position = 10;
                break;
            case 'Q':
                position = 28;
                break;
            case 'w':
                position = 11;
                break;
            case 'W':
                position = 29;
                break;
            case 'e':
                position = 12;
                break;
            case 'E':
                position = 30;
                break;
            case 'r':
                position = 13;
                break;
            case 't':
                position = 14;
                break;
            case 'T':
                position = 31;
                break;
            case 'y':
                position = 15;
                break;
            case 'Y':
                position = 32;
                break;
            case 'u':
                position = 16;
                break;
            case 'i':
                position = 17;
                break;
            case 'I':
                position = 33;
                break;
            case 'o':
                position = 18;
                break;
            case 'O':
                position = 34;
                break;
            case 'p':
                position = 19;
                break;
            case 'P':
                position = 35;
                break;
            case 'a':
                position = 20;
                break;
            default:
                position = -1;
        }

        if (position != -1) {
            pianoLabel = pianoGUI.keyboard.pianoLabelList.get(position);
            pianoLabel.play();

            if (recorder.getIsRecording()) {
                recorder.append(pianoLabel, System.currentTimeMillis());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        pianoLabel.setColorToDefaultColor();

    }
}
