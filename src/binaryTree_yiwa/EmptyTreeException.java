package binaryTree_yiwa;

import java.io.Serializable;

public class EmptyTreeException extends RuntimeException implements Serializable {
    public EmptyTreeException(){
        super();
    }
    public EmptyTreeException(String msg){
        super(msg);
    }
}
