package hashMap_yiwa;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test_map {
    @Test
    public void test() {
        Map m = new LinkedHashMap();
        m.put(1, "qq");
        m.put(null, "qq");
        m.put(2, "qq");
        System.out.println(m);
    }


}
