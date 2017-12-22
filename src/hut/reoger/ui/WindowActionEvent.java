package hut.reoger.ui;
import hut.reoger.listener.ReaderListen;

import java.awt.FlowLayout;
import java.awt.HeadlessException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowActionEvent extends JFrame {
    JTextField text;
    JTextArea textShow;
    JButton button;
    ReaderListen listener;

    public WindowActionEvent() throws HeadlessException {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout());
        text = new JTextField(10);
        button = new JButton("读取");
        textShow = new JTextArea(9,30);
        listener = new ReaderListen();
        listener.setJTextField(text);
        listener.setJTextArea(textShow);
        text.addActionListener(listener);
        button.addActionListener(listener);
        add(text);
        add(button);
        add(new JScrollPane(textShow));
    }
}

