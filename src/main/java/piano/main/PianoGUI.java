package piano.main;

import piano.instruments.InstrumentsPanel;
import piano.keyboard.keyboardui.Keyboard;
import piano.recorder.Recorder;
import piano.recorder.RecorderPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.sound.midi.MidiChannel;
import javax.swing.*;

public class PianoGUI extends JFrame {

    private final JCheckBox checkbox;
    private final Keyboard keyboard;

    public PianoGUI(MidiChannel midiChannel, Recorder recorder) {
        setTitle("MY PIANO");
        setSize(MainFrameInterface.FRAME_WIDTH, MainFrameInterface.FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Color.BLACK);

        checkbox = new JCheckBox("Show names");
        checkbox.setForeground(Color.WHITE);
        checkbox.addActionListener(this::onCheckboxClicked);

        keyboard = new Keyboard(midiChannel, recorder, checkbox.isSelected());

        root.add(new RecorderPanel(recorder), BorderLayout.NORTH);
        root.add(checkbox, BorderLayout.WEST);
        root.add(keyboard, BorderLayout.CENTER);
        root.add(new InstrumentsPanel(midiChannel), BorderLayout.SOUTH);
        setContentPane(root);

	}

    public void onCheckboxClicked(ActionEvent event) {
        keyboard.setShouldShowText(checkbox.isSelected());
    }
}
