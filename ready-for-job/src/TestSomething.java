import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/2/9 16:56
 */
public class TestSomething {

    public static void main(String[] args) {
//        TestSomething ts = new TestSomething();
//        int re = ts.get();
//        System.out.println(re);
//        int mask1Count = maskStringToInt("255.255.0.0");
//        System.out.println(mask1Count);
//        String binaryIpv4 = ipv4ToBinaryString("10.255.0.0");
//        System.out.println(binaryIpv4.length() + " ----" + binaryIpv4);
//        System.out.println(check(binaryIpv4, mask1Count));
        DecimalFormat df = new DecimalFormat("#,###");
        String commaNumber = df.format(10000000);
        System.out.println(commaNumber);
        int number = Integer.valueOf(commaNumber.replaceAll(",", ""));
        System.out.println(number);
    }

    public static boolean check(String binaryIp, int limit) {
        int rest = 32 - limit;
        for (int i = binaryIp.length() - 1; i >= binaryIp.length() - rest; i--) {
            if (binaryIp.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static int maskStringToInt(String str) {
        String[] items = str.split("\\.");
        StringBuffer stringBuffer = new StringBuffer();
        for (String item : items) {
            stringBuffer.append(Integer.toBinaryString(Integer.valueOf(item)));
        }
        String strTemp = stringBuffer.toString();
        Pattern pat = Pattern.compile("^(1*)");
        Matcher matcher = pat.matcher(strTemp);
        if (matcher.find()) {
            return matcher.group(1).length();
        }
        return 0;
    }

    public static String ipv4ToBinaryString(String str) {
        String[] items = str.split("\\.");
        StringBuffer stringBuffer = new StringBuffer();
        for (String item : items) {
            String s = "00000000" + Integer.toBinaryString(Integer.parseInt(item));
            s = s.substring(s.length() - 8);
            stringBuffer.append(s);
        }
        String strTemp = stringBuffer.toString();
        return strTemp;
    }




    public int get() {
        int n = 10;
        try {
            System.out.println("try block");
            //此处会抛异常
            int p = Integer.valueOf("p");
            return n;
        }catch (Exception e) {
            System.out.println("catch block");
            return n += 10;
        }finally {
            System.out.println("finally block");
            //在catch块返回前捕获,此时n值为20
            if (n > 10) {
                return 1;
            }else {
                return -1;
            }
        }
    }
}


