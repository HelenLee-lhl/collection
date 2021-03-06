package com.helen.collectiondemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by helenlee on 2017/9/18.
 */
public class CollectionOperate {
    public static void main(String [] args){
        final int constantC = 10000000;
        /*************************************************************/
        /*********初始化 arrayList和linkedlist数据**********************/
        /*************************************************************/
        List<String> list = new ArrayList<>();
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < constantC; i++){
            list.add("字符串" + i);
        }
        System.out.println("Arryalist 用时为：" + (System.currentTimeMillis() - timeMillis));


        List<String> list1 = new LinkedList<String>();
        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < constantC; i++){
            list1.add("字符串" + i);
        }
        System.out.println("LinkedList 用时为：" + (System.currentTimeMillis() - timeMillis));
        /*************************************************************/
        /*********初始化 arrayList和linkedlist数据**********************/
        /*************************************************************/

        System.out.println("arrayList VS linkedlist 之随机读取");
        /*************************************************************/
        /*********arrayList VS linkedlist 之随机读取**********************/
        /*************************************************************/
        Random random = new Random();
        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 100; i++){
            int s = random.nextInt(constantC);
            list.get(s);
        }
        System.out.println("arrayList 用时为：" + (System.currentTimeMillis() - timeMillis));

        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 100; i++){
            int s = random.nextInt(constantC);
            list1.get(s);
        }
        System.out.println("linkedlist 用时为：" + (System.currentTimeMillis() - timeMillis));

        /*************************************************************/
        /*********arrayList VS linkedlist 之随机读取**********************/
        /*************************************************************/




        System.out.println("arrayList VS linkedlist 之随机新增");
        /*************************************************************/
        /*********arrayList VS linkedlist 之随机插入**********************/
        /*************************************************************/
        //1.随机新增
        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            int s = random.nextInt(constantC);
            list.add(s,"list insert");
        }
        System.out.println("arrayList 用时为：" + (System.currentTimeMillis() - timeMillis));

        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            int s = random.nextInt(constantC);
            list1.add(s,"linked insert");
        }
        System.out.println("linkedlist 用时为：" + (System.currentTimeMillis() - timeMillis));
        //2.index = 0 处 新增
        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            list.add(0,"list insert");
        }
        System.out.println("arrayList 之开头插入 用时为：" + (System.currentTimeMillis() - timeMillis));

        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            list1.add(0,"linked insert");
        }
        System.out.println("linkedlist 之开头插入 用时为：" + (System.currentTimeMillis() - timeMillis));

        //3 index = middle 处 新增
        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            list.add(constantC/2,"list insert");
        }
        System.out.println("arrayList 之中间插入 用时为：" + (System.currentTimeMillis() - timeMillis));

        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            list1.add(constantC/2,"linked insert");
        }
        System.out.println("linkedlist 之中间插入 用时为：" + (System.currentTimeMillis() - timeMillis));
        /*************************************************************/
        /*********arrayList VS linkedlist 之随机插入**********************/
        /*************************************************************/




        System.out.println("arrayList VS linkedlist 之随机删除");
        /*************************************************************/
        /*********arrayList VS linkedlist 之随机删除**********************/
        /*************************************************************/
        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            int s = random.nextInt(constantC);
            list.remove(s);
        }
        System.out.println("arrayList 用时为：" + (System.currentTimeMillis() - timeMillis));

        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            int s = random.nextInt(constantC);
            list1.remove(s);
        }
        System.out.println("linkedlist 用时为：" + (System.currentTimeMillis() - timeMillis));
        /*************************************************************/
        /*********arrayList VS linkedlist 之随机删除**********************/
        /*************************************************************/

    }
}
