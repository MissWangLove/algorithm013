package com.wz.before.time2.a6;

/**
 * @author wangzhi
 */
public class GuessNumbers {

    /**
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     *
     * 你写出一个秘密数字，并请朋友猜这个数字是多少。
     * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
     * 朋友根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用B表示奶牛。
     *
     * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
     * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
     *
     *
     *
     * 示例 1:
     *
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1公牛和3奶牛。公牛是 8，奶牛是 0, 1和 7。
     * 示例 2:
     *
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1是公牛，第二个或第三个 1可被视为奶牛。
     *
     *
     * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
     *
     */

    /**
     * 题看起来复杂，其实就是给两个数字，比较位置相同，数字相同的有多少个；比较位置不同，数字不系相同的有多少个。
     * 脑海中的第一个思路：
     * 1. 可以先统计两个数字每个数字出现的次数，这个就是最大的B，接下来每一位进行比较，就是A，前面的B - A就是真正的B
     * 2. 用一个数组完成，因为里面全是数字，所以可以用一个长度为10的数组
     */

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

    /**
     * 第二遍刷，由于第一遍简单的方法已经写出来，所以这里只用优化后的方法，用一个数组的实现
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] arr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int secretNum = Character.getNumericValue(secret.charAt(i));
            int guessNum = Character.getNumericValue(guess.charAt(i));
            if (secretNum == guessNum) {
                a ++;
            } else {
                if (arr[secretNum] < 0) {
                    b ++;
                }
                if (arr[guessNum] > 0) {
                    b ++;
                }
                arr[secretNum] ++;
                arr[guessNum] --;
            }

        }

        return a + "A" + b + "B";
    }

    /**
     * 先求B，再求A
     * @param secret
     * @param guess
     * @return
     */
    /*public static String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        Map<String, Integer> secretMap = new LinkedHashMap<>();
        Map<String, Integer> guessMap = new LinkedHashMap<>();
        int length = secret.length();
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a ++;
            }
            String aStr = secret.substring(i, i + 1);
            if (secretMap.containsKey(aStr)) {
                Integer num = secretMap.get(aStr);
                secretMap.put(aStr, ++ num);
            } else {
                secretMap.put(aStr, 1);
            }
            String bStr = guess.substring(i, i + 1);
            if (guessMap.containsKey(bStr)) {
                Integer num = guessMap.get(bStr);
                guessMap.put(bStr, ++ num);
            } else {
                guessMap.put(bStr, 1);
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : secretMap.entrySet()) {
            String key = stringIntegerEntry.getKey();
            if (guessMap.containsKey(key)) {
                b += Math.min(guessMap.get(key), secretMap.get(key));
            }
        }
        return a + "A" + (b - a) + "B";
    }*/

}
