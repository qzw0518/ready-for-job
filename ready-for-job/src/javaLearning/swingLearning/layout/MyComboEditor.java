package javaLearning.swingLearning.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/3/7 9:18
 */
public class MyComboEditor implements ComboBoxEditor {

    protected JTextField editor;
    private Object oldValue;

    public MyComboEditor() {
        this.editor = createEditorComponet();
    }

    protected JTextField createEditorComponet() {
        JTextField input = new JTextField();
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String text = input.getText();
                char display = e.getKeyChar();

                if (!(display >= '0' && display <= '9')) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        return input;
    }


    @Override
    public Component getEditorComponent() {
        return this.editor;
    }

    @Override
    public void setItem(Object anObject) {
        if (anObject != null) {
            if (anObject instanceof NameValue) {
                this.editor.setText(String.valueOf(((NameValue) anObject).getName()));
            }else {
                this.editor.setText(anObject.toString());
            }
            this.oldValue = anObject;
        }else {
            this.editor.setText("0");
        }
    }

    @Override
    public Object getItem() {
        Object newValue = this.editor.getText();
        if (this.oldValue != null) {
            if (this.oldValue instanceof NameValue) {
                if (newValue.equals(String.valueOf(((NameValue) this.oldValue).getName()))) {
                    return this.oldValue;
                }
            }
        }
        return newValue;
    }

    @Override
    public void selectAll() {

    }

    @Override
    public void addActionListener(ActionListener l) {

    }

    @Override
    public void removeActionListener(ActionListener l) {

    }


}
