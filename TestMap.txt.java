package MapSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        //1、向map中插入键值对
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        System.out.println(map);
        //2、求map中键值对个数
        System.out.println(map.size());
        //3、根据key找到指定的Value。
        System.out.println(map.get(1));
        //4、判断map是否为空
        System.out.println(map.isEmpty());
        //5、根据key查找value,如果找到了就返回value，否则返回默认值。
        System.out.println(map.getOrDefault(6,"F"));
        //6、判断map是否包含key
        System.out.println(map.containsKey(1));
        //7、判断map中是否包含value
        System.out.println(map.containsValue("K"));
        //8、删除指定的键值对
        map.remove(5);
        System.out.println(map);
        //9、遍历map
        //(1)使用foreach遍历map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() +"="+ entry.getValue());
        }
        System.out.println();
        //(2)使用迭代器遍历map
        Iterator <Map.Entry<Integer,String>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry=iterator.next();
            System.out.println(entry.getKey() +"="+ entry.getValue());
        }
    }
}
