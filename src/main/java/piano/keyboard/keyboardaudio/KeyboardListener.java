package piano.keyboard.keyboardaudio;

import piano.keyboard.keyboardui.PianoLabel;
import piano.main.PianoGUI;
import piano.recorder.Recorder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private final Recorder recorder;
    private final PianoGUI pianoGUI;
    private PianoLabel pianoLabel;

    public KeyboardListener(Recorder recorder, PianoGUI pianoGUI) {
        this.recorder = recorder;
        this.pianoGUI = pianoGUI;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        int labelIndex = getPosition(key);

        if (labelIndex != -1) {
            pianoLabel = pianoGUI.getKeyboard().getPianoLabelList().get(labelIndex);
            pianoLabel.play();

            if (recorder.getIsRecording()) {
                recorder.append(pianoLabel, System.currentTimeMillis());
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (pianoLabel != null) {
            pianoLabel.setColorToDefaultColor();
        }
    }
    private static int getPosition(char key) {
        int labelIndex;
        switch (key) {
            case '1':
                labelIndex = 0;
                break;
            case '!':
                labelIndex = 21;
                break;
            case '2':
                labelIndex = 1;
                break;
            case '@':
                labelIndex = 22;
                break;
            case '3':
                labelIndex = 2;
                break;
            case '4':
                labelIndex = 3;
                break;
            case '$':
                labelIndex = 23;
                break;
            case '5':
                labelIndex = 4;
                break;
            case '%':
                labelIndex = 24;
                break;
            case '6':
                labelIndex = 5;
                break;
            case '^':
                labelIndex = 25;
                break;
            case '7':
                labelIndex = 6;
                break;
            case '8':
                labelIndex = 7;
                break;
            case '*':
                labelIndex = 26;
                break;
            case '9':
                labelIndex = 8;
                break;
            case '(':
                labelIndex = 27;
                break;
            case '0':
                labelIndex = 9;
                break;
            case 'q':
                labelIndex = 10;
                break;
            case 'Q':
                labelIndex = 28;
                break;
            case 'w':
                labelIndex = 11;
                break;
            case 'W':
                labelIndex = 29;
                break;
            case 'e':
                labelIndex = 12;
                break;
            case 'E':
                labelIndex = 30;
                break;
            case 'r':
                labelIndex = 13;
                break;
            case 't':
                labelIndex = 14;
                break;
            case 'T':
                labelIndex = 31;
                break;
            case 'y':
                labelIndex = 15;
                break;
            case 'Y':
                labelIndex = 32;
                break;
            case 'u':
                labelIndex = 16;
                break;
            case 'i':
                labelIndex = 17;
                break;
            case 'I':
                labelIndex = 33;
                break;
            case 'o':
                labelIndex = 18;
                break;
            case 'O':
                labelIndex = 34;
                break;
            case 'p':
                labelIndex = 19;
                break;
            case 'P':
                labelIndex = 35;
                break;
            case 'a':
                labelIndex = 20;
                break;
            default:
                labelIndex = -1;
        }
        return labelIndex;
    }
}
