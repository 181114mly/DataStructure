//推导lamber表达式
//函数式接口定义:任何接口只要包含一个唯一的抽象方法，那么它就是一个函数式接口。
//对于任意的函数式接口，我们可以通过lambda表达式来创建该接口对象。
public class Lambda {
    //2、静态内部类
    static class Like2 implements Ilike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }
    public static void main(String[] args) {
        Ilike like=new Like();
        like.lambda();

        like=new Like2();
        like.lambda();
        //3、局部内部类
        class Like3 implements Ilike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        like=new Like3();
        like.lambda();
        //4、匿名内部类，没有类名称，借助接口或父类实现。
         like=new Ilike(){
             @Override
             public void lambda() {
                 System.out.println("I like lambda4");
             }
         };
         like.lambda();
         //5、Lambda表达式
        like=() ->{
            System.out.println("I like lambda5");
        };
        like.lambda();
    }
}
//0、定义一个函数式接口
interface Ilike{
    public abstract void lambda();
}
//1、实现类
class Like implements Ilike{
    @Override
    public void lambda() {
        System.out.println("I like lambda1");
    }
}

