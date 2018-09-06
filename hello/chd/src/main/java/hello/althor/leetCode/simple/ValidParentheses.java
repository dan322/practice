package hello.althor.leetCode.simple;

import java.util.*;

public class ValidParentheses {
    private Map<Character, Integer> map;
//    private Map<Character, Character> map2;

   /* ValidParentheses()
    {
        this.map = new HashMap<Character, Integer>();
        this.map.put('[', 1);
        this.map.put(']', -1);
        this.map.put('(', 2);
        this.map.put(')', -2);
        this.map.put('{', 3);
        this.map.put('}', -3);
    }*/

  /*  ValidParentheses()
    {
        this.map2 = new HashMap<Character, Character>();
        this.map2.put('[', ']');
        this.map2.put('(', ')');
        this.map2.put('{', '}');
    }*/


    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        String[] strings = new String[]{"", "()", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()(", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])", "(()("};
//        String[] strings = new String[]{"", "()", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}", "[([]])"};
        ValidParentheses validParentheses = new ValidParentheses();
        for (String s: strings) {
//            System.out.println(validParentheses.isValid(s));
            System.out.println(validParentheses.isValid6(s));
//            System.out.println(validParentheses.isValidate(s));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public boolean isValidate(String s)
    {
        if (s != "" && (s.length() & 1) == 1) return false;
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        boolean isValid = true;
        int nowInt;
        for (char c : chars) {
            nowInt = this.map.get(c);
            if (nowInt > 0) {
                stack.push(nowInt);
                continue;
            }
            if (stack.empty() || stack.pop() + nowInt != 0) {
                isValid = false;
                break;
            }
        }
        return isValid && stack.empty();
    }

    public boolean isValid4(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }

        }
        return stack.isEmpty();

    }

   /* public boolean isValidate(String s)
    {
        if (s != "" && (s.length() & 1) == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        boolean isValid = true;
        outer: for (char c : chars) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        isValid = false;
                        break outer;
                    }
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        isValid = false;
                        break outer;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        isValid = false;
                        break outer;
                    }
                    break;
                default:
                    isValid = false;
                    break outer;
            }
        }
        return isValid && stack.empty();
    }*/

    public boolean isValid(String s)
    {
        int length = s.length();
        if ((length & 1) == 1) return false;
        int nowInt, index = -1, j = 0;
        int middle = (length - 1) >> 1;
        boolean isValid = true;
        int[] arr = new int[middle + 1];
        char[] chars = s.toCharArray();
        for (char c: chars) {
            nowInt = this.map.get(c);
            if (nowInt > 0) {
                if (index + j == middle) {
                    isValid = false;
                    break;
                }
                arr[++index] = nowInt;
                continue;
            }
            if (index < 0 || arr[index--] + nowInt != 0) {
                isValid = false;
                break;
            }
            j++;
        }
        return isValid;

        /*
        int length = s.length();
        if ((length & 1) == 1) return false;
        int preInt = 0;
        int total = 0;
        int nowInt;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            nowInt = this.map.get(c);
            if (preInt > 0 ) {
                if (nowInt < 0 && preInt + nowInt != 0)
                    break;
            } else if (preInt + nowInt == 0) {
                break;
            }
            preInt = nowInt;
            total += nowInt;
        }
        return total == 0;*/

      /*  int length = s.length();  // 2
        if ((length & 1) == 1) return false;
        int preInt = 0;
        int total = 0;
        int nowInt;
        while (--length >= 0) {
            nowInt = this.map.get(s.charAt(length));
            if (preInt < 0) {
                if ( nowInt > 0 && (nowInt + preInt) != 0 ) break;
            } else {
                if (nowInt + preInt == 0) break;
            }
            if (preInt < 0 && nowInt > 0 && (nowInt + preInt) != 0) {
                break;
            }
            if (preInt > 0 && (nowInt + preInt) == 0) {
                break;
            }
            total += nowInt;
            preInt = nowInt;
        }
        return total == 0;*/
    }

    public boolean isValid1(String s) {
        int length = s.length();
        if ((length & 1) == 1) return false;
        int middle = length >> 1;
        char[] chars = s.toCharArray();
        while (middle < length ) {
            if (this.map.get(chars[middle]) + this.map.get(chars[length - middle -1]) != 0)
                return false;
            middle++;
        }
        return true;
    }

    public int isLeft(char c){//判断字符是否为左半边
        if(c=='(') return 1;
        else if(c=='[') return 2;
        else if(c=='{') return 3;
        else return 0;
    }

    public int isRight(char c){//判断字符是否为右半边
        if(c==')') return 1;
        else if(c==']') return 2;
        else if(c=='}') return 3;
        else return 0;
    }

    public boolean isValid5(String s) {
        char[] c=s.toCharArray();//存储字符串的数组
        char[] cs=new char[c.length];//栈
        int p=0;//指向栈的头部的指针

        /*for(int i=0;i<c.length;i++){
            System.out.println(c[i]+'\t');
        }*/

        for(int i=0;i<c.length;i++){
            if(isLeft(c[i])>0) {
                cs[p]=c[i];
                p++;
            }
            else if(isRight(c[i])>0&&p>0){
                if(isLeft(cs[p-1])==isRight(c[i])) p--;
                else return false;
            }
            else return false;
        }
        if(p==0){
            return true;
        }
        else return false;
    }

    public boolean isValid6(String s)
    {
        if (s == "") return true;
        int length = s.length();
        if ((length & 1) == 1) return false;
        int index = -1, nowInt;
        int middle = (length - 1) >> 1;
        int[] arr = new int[middle + 1];
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if((nowInt = isLeft(c))>0) {
                if (index >= middle) return false;
                arr[++index]=nowInt;
                continue;
            }
            if (index >= 0 && isRight(c) == arr[index]) {
                index--;
            } else {
                return false;
            }
        }
        return index == -1;
    }

}
