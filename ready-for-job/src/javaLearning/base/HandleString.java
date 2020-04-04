package javaLearning.base;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/2/8 9:27
 */
public class HandleString {

    public static void main(String[] args) {
        String s = "this is a sentence ";

        //以空格分割字符串。函数可以加第二参数int limit表示分割几次
        String[] divides = s.split(" ");    //divides: ["this", "is", "a", "sentence"]

        //下标从0开始。截取从第5个字符到第7-1个字符。如果不加第二个参数表示从一个参数位置截取到末尾
        String sub = s.substring(5,7);  //sub: "is"

        //获取字符串第一次出现的位置。
        int firstOccurence = s.indexOf("e");    //firstOccurence: 11

        //获取字符串最后一次出现的位置
        int lastOccurence = s.lastIndexOf("e");     //lastOccurence: 17

        //替换所有单个字符
        String charReplaced = s.replace('s', 'x');      //charReplaced: "thix ix a xentence "

        //替换目标字符串
        String stringRepalced = s.replaceAll("en","us");    //stringRepalced: "this is a sustusce "

        //去掉首尾多余的空格
        String trimString = s.trim();   //trimString: "this is a sentence"

        //转换为小写
        String lowerString = s.toLowerCase();   //lowerString: "this is a sentence "

        //转换为大写
        String upperString = s.toUpperCase();  //upperString: "THIS IS A SENTENCE "

        //忽略大小写进行比较
        boolean isEqualsIgnore = s.equalsIgnoreCase(upperString);   //isEqualsIgnore: true

        //获取指定位置字符。
        char c = s.charAt(1); //c: 'h'

        //转换为字符数组
        char[] cs = s.toCharArray(); //cs: ['t','h','i','s',' ',...]

        //通过字符数组构建新的字符串
        String newString = new String(cs);  //newString: "this is a sentence "

        //获取某个基本类型的字符串值
        String stringValue = String.valueOf(12);    //stringValue: "12"

        //使用StringBuilder构建字符串。String的+运算符本质上也是通过StringBuilder去做的
        StringBuilder builder = new StringBuilder();
        //追加字符串
        builder.append("str");
        //追加字符
        builder.append('a');
        //追加数字
        builder.append(1);
        //指定位置插入
        builder.insert(2,2);
        //构建String
        String buildString = builder.toString();    //buildString: "st2ra1"
        //字符串反转
        String reverseString = builder.reverse().toString();

        //测试字符串是否与给定的正则表达式匹配。此为是否包含h或者s
        boolean isMatch = s.matches(".*[hs].*");    //isMatch: true

        //是否以某个字符串结尾
        boolean isEndWith = s.endsWith("ce");   //isEndWith: true

        //将数值字符串转为整数
        int num = Integer.valueOf("102");   //num: 102

        //判断字符是否是字母
        boolean isLetter = Character.isLetter('m');
        //判断字符是否大写字母
        boolean isUpper = Character.isUpperCase('A');
        //判断字符是否小写字母
        boolean isLower = Character.isLowerCase('a');
        //判断字符是否是数字
        boolean isDigit = Character.isDigit('9');
        //字符是否在b-h范围内。本质比较ASCII码
        char d = 'd';
        boolean isIn = false;
        if (c >= 'b' && c <= 'h') {
            isIn = true;
        }
        //小写字母转大写字母。小写字母ASCII码比大写字母的大32.需要强转
        char upperD = (char) (d + 32);
    }

}
