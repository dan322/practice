package hello.base;

public class SimpleMatchFigure {

    // todo simple figure number (+, -, *, /)
    public static void main(String[] args)
    {
       /*
       ArrayStack arrayStack =  new ArrayStack(5);
        int nums[] = new int[]{2, 4, 6, 7, 32};
        for (int i=0; i < nums.length; i++) {
            arrayStack.add(nums[i]);
        }
        int j = 0;
        int[] arr = new int[] { 10, 9, 13};
        while (j < 3) {
            arrayStack.add(arr[j]);
            j++;
        }
        for (int n =0; n < 8; n++) {
            System.out.println(arrayStack.getData());
        }
        */
        String expression = "3 + 5 - 6 * 2 / 4";
        SimpleMatchFigure simpleMatchFigure = new SimpleMatchFigure();
        int result = simpleMatchFigure.doFigure(expression);
        System.out.println(result);
    }

    public int doFigure(String expression)
    {
        char[] chars = expression.toCharArray();
        int length = chars.length >> 1;
        ArrayStack arrayStackNum = new ArrayStack(length);
        ArrayStack arrayStackOpera = new ArrayStack(length);
        int res, number, result = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case ' ':
                    break;
                case '+':
                case '-':
                    arrayStackOpera.add(chars[i]);
                    break;
                case '*':
                    res = arrayStackNum.getData() * Integer.parseInt(String.valueOf(chars[2+i]));
                    i += 2;
                    arrayStackNum.add(res);
                    break;
                case '/':
                    res = arrayStackNum.getData() / Integer.parseInt(String.valueOf(chars[2+i]));
                    i += 2;
                    arrayStackNum.add(res);
                    break;
                default:
                    arrayStackNum.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
        char operator;
        while ((number = arrayStackNum.getData()) != -1) {
            operator = (char) arrayStackOpera.getData();
            switch (operator) {
                case '-':
                    result -= number;
                    break;
                default:
                    result += number;
            }
        }
        return result;
    }
}
