/**
 * 1114. 按序打印
 * https://leetcode-cn.com/problems/print-in-order/
 */
public class PrintInOrder {
    public static void main(String[] args) throws InterruptedException {
        Foo foo= new Foo();

        foo.first(()->System.out.print("one"));
        foo.third(()->System.out.print("two"));
        foo.second(()->System.out.print("three"));


    }
}

class Foo {

    private int tag = 1;
    private Object lock = new Object();
    public Foo() {
    }

    public  void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        synchronized(lock){
            tag = 2;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        printSecond.run();
        while(tag != 2){
            lock.wait();
        }
        synchronized (lock){
            tag = 3;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        printThird.run();
        while(tag != 3){
            lock.wait();
        }

    }
}