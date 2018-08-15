package hello.althor.divide;

public class LargeIntegeMulti {

    public Integer doMulti(Integer a, Integer b)
    {
        //todo divide to solve two big integer multi problem
        int max_len = 0;
        if (a > b) {
            max_len = getLenth(a);
        } else {
            max_len = getLenth(b);
        }
        if (max_len < 2)
            return a * b;
        int split_line = (--max_len) >> 1;
//        String a_l = a.toString().subSequence(0, split_line);

        return doMulti(a, b);
    }

    public int getLenth(int a)
    {
        int i = 0;
        while ((a/=10) > 0)
            i++;
        return i;
    }

}
