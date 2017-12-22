package hut.reoger.ui;

import hut.reoger.listener.ReaderListen;

import java.awt.*;
import java.awt.event.ActionEvent;



import javax.swing.*;

public class ComponentInWindow extends JFrame {

    JTextField textSourth;
    JTextField text;
    JButton button;
    JTextArea area;
    JButton buttonFile;
    JButton buttonDir;

    ReaderListen listen;

    public ComponentInWindow() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout()); // 设置布局
        listen = new ReaderListen();

        add(new JLabel("文件源:"));
        textSourth = new JTextField(15);
        add(textSourth);
        listen.setJTextField(textSourth);

        buttonFile = new JButton("选择");
        add(buttonFile);
        buttonFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("chooser");
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    textSourth.setText(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });


        add(new JLabel("输出源:"));
        text = new JTextField(15);
        add(text);
        listen.setTextSource(text);

        buttonDir = new JButton("选择");
        add(buttonDir);

        buttonDir.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("chooser");
                JFileChooser jf = new JFileChooser();
                jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = jf.showOpenDialog(frame);
                if(returnVal==JFileChooser.APPROVE_OPTION){
                    text.setText(jf.getSelectedFile().getPath()+"\\");
                }

            }
        });

        add(new JLabel("按钮:"));
        button = new JButton("确认");
        add(button);
       button.addActionListener(listen);

        add(new JLabel("文本区"));
        area = new JTextArea(6, 20);// 文本区设置行数和列数
        add(new JScrollPane(area));
        listen.setJTextArea(area);

    }
}