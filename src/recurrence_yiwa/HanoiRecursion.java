package recurrence_yiwa;
//汉诺塔递归实现方式 H(n)=H(n-1)+1+H(n-1)
public class HanoiRecursion {
    /**
     * @param n 汉诺塔的层数
     * @param x x柱 起点柱(A)
     * @param y y柱 目标柱(B)
     * @param z z柱 中转柱(C)
     * 其中 A B C 只是作为辅助思考
     */
    public void hanoi(int n,char x,char y,char z){
        if (n==0);
        else {
            //将n-1个圆盘从x移动到z,y为中转柱
            hanoi(n-1,x,z,y);
            System.out.println(x+"->"+y);
            //将n-1个圆盘从z移动到y,x为中转柱
            hanoi(n-1,z,y,x);

        }

    }
    public int hanoiCount(int n,char x,char y,char z){
        int moveCount=0;
        if (n==0)
            return 0;
        else {
            //递推公式：H(n)=H(n-1) + 1 + H(n-1)
            //将n-1个圆盘从x移动到z,y为中转柱
            moveCount+=hanoiCount(n-1,x,z,y);
            moveCount+=1;
            moveCount+=hanoiCount(n-1,z,y,x);
        }
        return moveCount;
    }
    public int h(int n){
        int c=0;
        if (n==0) return 0;
        else {
            c+=h(n-1);
            c+=h(n-1);
            c+=1;
        }
        return c;
    }
    //阶乘递归
    public int f(int n){
        if (n==0) return 1;
        return n*f(n-1);
    }
    //阶乘迭代
    public long f1(int n){
        if (n==0) return 1;
        long result=1;
        if (n>0){
            for (int i=n;i>0;i--){
                result=result*i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        HanoiRecursion hanoiRecursion=new HanoiRecursion();
        hanoiRecursion.hanoi(3,'A','B','C');
        int c=hanoiRecursion.hanoiCount(6,'A','B','C');
        System.out.println("count: "+c);
        System.out.println("ccc="+hanoiRecursion.h(6));
        long l = System.currentTimeMillis();
        System.out.println("阶乘递归："+hanoiRecursion.f(10));
        long l1 = System.currentTimeMillis();
        System.out.println("递归用时："+(l1-l));
        long l2 = System.currentTimeMillis();
        System.out.println("阶乘迭代："+hanoiRecursion.f1(10));
        long l3 = System.currentTimeMillis();
        System.out.println("迭代用时："+(l3-l2));
    }
}
