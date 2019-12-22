package collection_yiwa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_ArrayList {
    @Test
    public void test(){
        List list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom",20));
        list.add(456);
        System.out.println(list);
        list.add(3,"BB");
        System.out.println(list);
        List list1= Arrays.asList(1,2,3,new Person("QQ"));
        list.add("BB");
        list.addAll(list1);
        list.add(list1);
        System.out.println(list);
        System.out.println(list.get(3));
        int bb = list.indexOf("BB");
        System.out.println(bb);
        int x = list.lastIndexOf("BB");
        System.out.println(x);
        Object remove = list.remove(3);
        boolean bb1 = list.remove("BB");
        System.out.println("bbbbb"+bb1);
        System.out.println(remove);
        System.out.println(list);
        list.set(3,"CC");
        System.out.println(list);
        List list2 = list.subList(2, 4);
        System.out.println(list2);
        System.out.println(list);

    }
    @Test
    public void test2(){
        char [] ch={'1'};
        System.out.println(ch);
        System.out.println(ch.length);
        String s="";
        System.out.println(s.length());
    }
}
