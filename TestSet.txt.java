package MapSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        //1、实例化set
        Set<String> set=new HashSet<>();
        //2、向set中添加元素
        set.add("Hello");
        set.add("world");
        set.add("!!!");
        //set中元素不能重复，如果add时发现这个元素已经存在，就add失败。
        // 没有任何负面影响，不会抛出异常，也不会影响原有set中的内容。
        set.add("Hello");
        System.out.println(set);
        //3、删除元素
        set.remove("!!!");
        System.out.println(set);
        //4、判断某个元素是否在集合中
        System.out.println(set.contains("Hello"));
        System.out.println(set.contains("Apple"));
        //5、遍历集合
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            String next=iterator.next();
            System.out.println(next);
        }
    }
}
