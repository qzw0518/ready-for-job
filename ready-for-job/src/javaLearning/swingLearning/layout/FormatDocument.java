package javaLearning.swingLearning.layout;

import javax.swing.event.DocumentEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import java.text.DecimalFormat;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/3/10 17:16
 */
public class FormatDocument extends PlainDocument {
    private JTextComponent textComponent;
    private int min;
    private int max;
    private DecimalFormat format = new DecimalFormat("#,###");

    public FormatDocument(JTextComponent textComponent) {
        this(textComponent, 0, Integer.MAX_VALUE);
    }

    public FormatDocument(JTextComponent textComponent, int min, int max) {
        this.textComponent = textComponent;
        this.min = min;
        this.max = max;
    }



    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        int num = 0;
        try {
            num = Integer.parseInt(str);
        }catch (Exception e) {  //输入的字符不是整数，不允许插入
            return;
        }
        //之前的字符的长度
        int prevLen = getLength();
        //之前的字符串
        String prevText = getText(0, prevLen);
        //0开始后续不允许插入
        if (prevText.startsWith("0")) {
            return;
        }

        if (offs == 0) { //插入位置在开头。注意str可能为键盘单个输入也可能是粘贴的一串字符串
            super.insertString(0, format.format(num), a);
        }else {
            StringBuilder builder = new StringBuilder(prevText);
            builder.insert(offs, str);
            String textNew = builder.toString().replaceAll(",", "");
            try {
                int number = Integer.parseInt(textNew);
                if (number < min || number > max) {
                    return;
                }
                String commaString = format.format(number);
                remove(0, prevText.length());
                super.insertString(0, commaString, a);
            }catch (Exception e) {
                return;
            }
        }

    }

}
