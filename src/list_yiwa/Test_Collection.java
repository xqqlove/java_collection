package list_yiwa;

import org.junit.Test;

import java.util.*;

public class Test_Collection {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry", 20));
        coll.add(new Person("tom"));
        coll.add(false);
        System.out.println(coll.toString());
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new Person("tom")));
        Person p = new Person("tom");
        System.out.println(coll.contains(p));
        Collection cool1 = Arrays.asList(123, new Person("tom"));
        System.out.println(coll.containsAll(cool1));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry", 20));
        coll.add(new Person("tom"));
        coll.add(false);
        coll.remove(false);
        System.out.println(coll);
        coll.retainAll(Arrays.asList(123));
        System.out.println(coll);
        coll.removeAll(Arrays.asList(123, 456, new Person("tom")));
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry", 20));
        coll.add(new Person("tom"));
        Object[] objects = coll.toArray();
        for (Object obj : objects) {
            System.out.println(obj);
        }
        System.out.println(coll.hashCode());
        List ints = Arrays.asList(new Integer[]{1, 2, 3});
        System.out.println(ints.size());
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry", 20));
        coll.add(new Person("tom"));
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (new Person("tom").equals(obj)) {
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static boolean add(Integer e) {
        throw new UnsupportedOperationException();
    }

    @Test
    public void test5() {
        Collection l = new ArrayList(5);
        l.add(1);
        l.add(2);
        l.add(null);
        System.out.println(l.size());
        System.out.println(l);
        boolean contains = l.contains(null);
        System.out.println(contains);
        System.out.println(add(new Integer(1)));

    }

    @Test
    public void test6() {
        List l1 = new ArrayList();
        l1.add("1");
        l1.add("23");
        l1.add("b");
        l1.add("bb");
        l1.add("d");
        List l2 = new ArrayList();
        l2.add("23");
        l2.add("bb");


        boolean b = l1.removeAll(l2);
        System.out.println(b);
        System.out.println(l1);
    }


}
