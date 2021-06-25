package interview.interview_0102.impl;

import interview.interview_0102.CheckPermutation;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-16 17:15
 * @Version: 1.0
 */
public class CheckPermutationImpl implements CheckPermutation {
    @Override
    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int[] markArr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            markArr[s1.charAt(i) - 'a']++;
            markArr[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < markArr.length; i++) {
            if (markArr[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
