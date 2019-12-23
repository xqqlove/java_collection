package collection_yiwa;

import org.junit.Test;

import java.util.*;

public class Test_ArrayList {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom", 20));
        list.add(456);
        System.out.println(list);
        list.add(3, "BB");
        System.out.println(list);
        List list1 = Arrays.asList(1, 2, 3, new Person("QQ"));
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
        System.out.println("bbbbb" + bb1);
        System.out.println(remove);
        System.out.println(list);
        list.set(3, "CC");
        System.out.println(list);
        List list2 = list.subList(2, 4);
        System.out.println(list2);
        System.out.println(list);

    }

    @Test
    public void test2() {
        char[] ch = {'1'};
        System.out.println(ch);
        System.out.println(ch.length);
        String s = "";
        System.out.println(s.length());
    }

    //    public static  <E>int indexOf(Object o,List e ){
//        ListIterator<E> it =e.listIterator();
//        if (o==null){
//            while (it.hasNext())
//                if (it.next()==null)
//                    return it.previousIndex();
//        }else {
//            while(it.hasNext())
//                if (o.equals(it.next()))
//                    return it.previousIndex();
//
//        }
//        return -1;
//    }
    @Test
    public void test3() {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom", 20));
        list.add(456);
        Iterator it=list.iterator();
        System.out.println(list);
//        System.out.println(list.indexOf("AA"));
//        List<String> characters = new ArrayList<>();
//        characters.add("AA");
//        characters.add("BB");
//        characters.add("CC");
//        characters.add("DD");
//        System.out.println(characters.indexOf("CC"));
//        ListIterator it = characters.listIterator();
//        System.out.println("===============");
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.previousIndex());
        List l2 = new ArrayList(list);
//        System.out.println("++++++++++++++++++++");
//        System.out.println(l2);
//        int[] a = {1, 2, 3};
//        a = new int[5];
//        System.out.println(a.length);
        Iterator it1 = l2.iterator();
        System.out.println("----------------");
        System.out.println(l2);
//        while (it1.hasNext()) {
//            if ("AA".equals(it1.next()))
//                it1.remove();
//        }
        it1.remove();
        System.out.println(l2);
        LinkedList link=new LinkedList();
        link.add(1);
        link.addFirst(4);
        link.addLast(5);
        System.out.println(link);

    }
    @Test
    public void test4(){
        LinkedList link=new LinkedList();
        link.add(1);
        link.addFirst(4);
        link.addLast(5);
        System.out.println(link);
        System.out.println("clear: "+link);
        link.addAll(0,Arrays.asList("x","6","y"));
        System.out.println(link);
        ListIterator listIterator=link.listIterator();

        System.out.println(link);

    }
}
