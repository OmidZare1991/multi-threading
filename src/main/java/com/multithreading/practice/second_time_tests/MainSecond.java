package com.multithreading.practice.second_time_tests;

public class MainSecond {
    public static void main(String[] args) {
        ClassA b1 = new ClassA();

        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b1);

        ClassA b2 = new ClassA();

        Thread t3 = new Thread(b2);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();



        //t1
        //t3
        //t2
        //in block t1
        //in block t3
        //in block t3 end
        //in block t1 end
        //in block t2
        //in block t2 end




//        ClassB b1 = new ClassB();
//
//        Thread t1 = new Thread(b1);
//        Thread t2 = new Thread(b1);
//
//        ClassB b2 = new ClassB();
//
//        Thread t3 = new Thread(b2);
//
//        t1.setName("t1");
//        t2.setName("t2");
//        t3.setName("t3");
//        t1.start();
//        t2.start();
//        t3.start();

        //t1
        //t3
        //t2
        //in block t1
        //in block t1 end
        //in block t2
        //in block t2 end
        //in block t3
        //in block t3 end




//        ClassC b1 = new ClassC();
//
//        Thread t1 = new Thread(b1);
//        Thread t2 = new Thread(b1);
//
//        ClassC b2 = new ClassC();
//
//        Thread t3 = new Thread(b2);
////
//        t1.setName("t1");
//        t2.setName("t2");
//        t3.setName("t3");
//        t1.start();
//        t2.start();
//        t3.start();

        //t1
        //t3
        //t2
        //in block t1
        //in block t1 end1
        //in block t3
        //in block t3 end1
        //in block t2
        //in block t2 end2



//        ClassD b1 = new ClassD();
//
//        Thread t1 = new Thread(b1);
//        Thread t2 = new Thread(b1);
//
//        ClassD b2 = new ClassD();
//
//        Thread t3 = new Thread(b2);
//
//        t1.setName("t1");
//        t2.setName("t2");
//        t3.setName("t3");
//        t1.start();
//        t2.start();
//        t3.start();


        //t3
        //t1
        //t2
        //in block t3
        //in block t3 end1
        //in block t2
        //in block t2 end2
        //in block t1
        //in block t1 end3




//        ClassE b1 = new ClassE();
//
//        Thread t1 = new Thread(b1);
//        Thread t2 = new Thread(b1);
//
//        ClassE b2 = new ClassE();
//
//        Thread t3 = new Thread(b2);
//
//        t1.setName("t1");
//        t2.setName("t2");
//        t3.setName("t3");
//        t1.start();
//        t2.start();
//        t3.start();



        //t3 in increment()
        //in block1 t3
        //in block1 t3 end1 with value: 1
        //t3 in increment2()
        //in block2 t3
        //t1 in increment()
        //in block1 t1
        //in block1 t1 end1 with value: 2
        //t1 in increment2()
        //in block2 t1
        //in block2 t1  end1 with value: 1
        //t2 in increment()
        //in block2 t3  end1 with value: 1
        //in block1 t2
        //in block1 t2 end1 with value: 3
        //t2 in increment2()
        //in block2 t2
        //in block2 t2  end1 with value: 2
    }
}
