package hut.reoger.ui;

import hut.reoger.listener.ReaderListen;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class ComponentInWindow extends JFrame {

    JTextField textSourth;
    JTextField text;
    JButton button;
    JTextArea area;

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
        textSourth = new JTextField(20);
        add(textSourth);
        listen.setJTextField(textSourth);

        add(new JLabel("输出源:"));
        text = new JTextField(20);
        add(text);
        listen.setTextSource(text);


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