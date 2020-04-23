package Card;

import java.util.Comparator;

class Card implements Comparable<Card>{
   public String rank;   //点数
    public String suit;   //花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        //1、和自己比较
        if(this==obj){
            return true;
        }
        //2、判断obj是否为空
        if(obj==null){
            return false;
        }
        //3、判断obj是不是Card类型
        if(!(obj instanceof Card)){
            return false;
        }
        //4、判断花色和点数是否相同
        Card other=(Card) obj;
       return this.rank.equals(other.rank)&&this.suit.equals(other.suit);
    }

    @Override
    public int compareTo(Card  o) {
        //如果 this>o,返回>0的数
        //如果 this<o,返回<0的数
        //如果 this=o,返回0
        //如果o为空，默认o的值比较小
        if(o==null){
            return 1;
        }
        int m=this.getValue();
        int n=o.getValue();
        return m-n;
    }

    public int getValue( ){
        int value=0;
        if("J".equals(rank)){
            value=11;
        }else if("Q".equals(rank)){
            value=12;
        }else if("K".equals(rank)){
            value=13;
        }
        else if("A".equals(rank)){
            value=1;
        } else{
            value=Integer.parseInt(rank);
        }
        return value;
    }
}

class TestComparator implements Comparator<Card>{
    // < 0: 表示 o1 指向的对象小于 o2 指向的对象
    // == 0: 表示 o1 指向的对象等于 o2 指向的对象
    // > 0: 表示 o1 指向的对象等于 o2 指向的对象
    @Override
    public int compare(Card o1, Card o2) {
       if(o1==null){
           return -1;
       }
       if(o2==null){
           return 1;
       }
       if(o1==o2){
           return 0;
       }
       int m=o1.getValue();
       int n=o2.getValue();
       return m-n;
    }
}

public class TestCompare {
    public static void main(String[] args) {
        Card m=new Card("6","红桃");
        Card n=new Card("6","红桃");
        Card o=m;
        //比较的是身份
        System.out.println(m==o);
        System.out.println(m==n);
        //对于非String、Date类型，如果不覆写 equals，默认的 equals 逻辑就是引用比较
        System.out.println(m.equals(o));
        System.out.println(m.equals(n));

        Card p=new Card("8","黑桃");
        Card q=new Card("6","黑桃");
        System.out.println(p.compareTo(m));
        //compareTo只与rank有关，和suit无关
        System.out.println(q.compareTo(n));

        TestComparator comparator=new TestComparator();
        System.out.println(comparator.compare(q,p));
    }
}
