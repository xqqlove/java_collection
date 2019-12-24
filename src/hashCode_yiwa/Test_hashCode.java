package hashCode_yiwa;

import list_yiwa.Person;
import org.junit.Test;

public class Test_hashCode {


    @Test
    public void test(){
        Person o=new Person("tom");
        System.out.println(o.hashCode());
//        long nptr = NativeUtils.getNativePointer(o);
    }
}
