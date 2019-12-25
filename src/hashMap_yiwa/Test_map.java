package hashMap_yiwa;

import list_yiwa.Person;
import org.junit.Test;

import java.util.*;

public class Test_map {
    @Test
    public void test() {
        Map m = new HashMap();
        m.put(1, "qq");
        m.put(3, null);
        m.put(2, "XX");
        m.computeIfAbsent(3,(k)->{
            return "我替换位置3的值";
        });
        System.out.println(m);
        System.out.println(m);
        System.out.println(m.containsKey(1));
        System.out.println(m.keySet());
        System.out.println(m.values());
        System.out.println(m.entrySet());
        m.forEach((x,y)->{
            System.out.println(x);
            System.out.println(y);
        });
        m.compute(2,(x,y)->{
           String s=null;
           s= x+"->"+y;
           return s;
        });
        System.out.println(m);
        m.replaceAll((k,v)->{
            String s=null;
            s="key="+k+"value"+v;
            return s;
        });
        System.out.println(m);
        System.out.println(m.containsValue("key=1valueqq"));

    }
    @Test
    public void test2(){
        HashMap<Object,Integer> hashMap=new HashMap();
        hashMap.put("tim",25);
        hashMap.put("bob",26);
        hashMap.put("jerry",27);
        hashMap.put("honey",28);
        hashMap.put("honey",29);
        hashMap.put(new User("tom"),44);
        hashMap.put(new User("tom"),45);
        for (Map.Entry<Object,Integer> entry:hashMap.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
    static{
        System.out.println("跑起来");
    }
    public static void main(String[] args) {

    }
    @Test
    public void testh(){
        Object o=new Person("tom");
        int i=o.hashCode();
        String s = Integer.toBinaryString(i);
        System.out.println(s.length());
        System.out.println(Integer.toBinaryString(i));
        int i1 = i ^ (i >>> 16);
        System.out.println(Integer.toBinaryString(i1));
    }

}
