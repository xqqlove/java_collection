package recurrence_yiwa;
//斐波那锲数列实现
public class Fibonacci {
    public static int fibonacci(int day){
        if (day==0)
            return 1;
        else if (day==1||day==2){
            return 1;
        }else
            return fibonacci(day-1)+fibonacci(day-2);
    }
    public static int fibonacci1(int day){
        return day==0?0:(day==1||day==2?1:fibonacci(day-1)+fibonacci(day-2));
    }

    /**
     * F(0)=0
     * F(1)=1
     * F(2)=F(0)+F(1)=1
     * F(3)=F(2)+F(1)=2
     * F(4)=F(3)+F(2)=3
     * F(5)=F(4)+F(3)=5
     * F(6)=F(5)+F(4)=8
     * F(7)=F(6)+F(5)=13
     * F(8)=F(7)+F(6)=21
     * F(9)=F(8)+F(7)=34
     * F(10)=F(9)+F(8)=55
     * F(11)=F(10)+F(9)=89
     * @param x
     * @return
     */
    //迭代实现
    public static int fibonacci2(int x){
        if (x==0) return 0;
        if (x==1||x==2) return 1;
        int c=0;
        int c1=1;
        int c2=1;
        if (x>3){
            for (int i=3;i<=x;i++){
                c=c1+c2;
                c1=c2;
                c2=c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("递归1："+fibonacci(11));
        System.out.println("递归2："+fibonacci1(11));
        System.out.println("迭代："+fibonacci2(11000));
    }
}
