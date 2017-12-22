package hut.reoger.listener;

import hut.reoger.ui.Read;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ReaderListen implements ActionListener {
    JTextField text;
    JTextField textSource;
    JTextArea textShow;

    public void setJTextField(JTextField text) {
        this.text = text;
    }

    public void setTextSource(JTextField textSource) {
        this.textSource = textSource;
    }

    public void setJTextArea(JTextArea textShow) {
        this.textShow = textShow;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Read.readData(text.getText(),textSource.getText());
            textShow.append("图片输出成功！请去"+textSource.getText()+"查看转化的图片！");
        } catch (Exception e2) {
            textShow.append("系统找不到指定的文件。"+e2.toString());
        }


    }

}