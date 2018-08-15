package hello.collection.map;

import java.util.TreeMap;
import java.util.Map;

public class TreeMapT
{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args)
    {
        Map map = new TreeMap();
        map.put("1", "1");
        map.put("4", "4");
        map.put("2", "2");
        map.put("2", "3");
        // 注意排序
        System.out.println(map);
    }
}