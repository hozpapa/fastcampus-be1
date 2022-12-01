package me.day07.practice;

// isPalindrome
// 1) two pointer
// 2) original .equals(reverse())
class Solution {
    public boolean isPalindrome(String s) { // 1)
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int j = str.length() - 1; // right pointer
        for (int i = 0; i < str.length() / 2; i++) { // str.length() / 2 (몫) , left pointer
            if (str.charAt(i) != str.charAt(j)) return false;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) { // 2)
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
    }
}

public class Practice05 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome2("race a car"));
        System.out.println(new Solution().isPalindrome2(" "));

    }
}
