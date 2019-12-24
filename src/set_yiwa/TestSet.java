package set_yiwa;

import list_yiwa.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    @Test
    public void test() {
        Set set=new TreeSet();
        set.add(456);
        set.add(123);
        set.add(345);
        set.add(435);
//        set.add("CC");
//        set.add(new Person("tom"));
        set.add(234);
        System.out.println(set);
    }
}
