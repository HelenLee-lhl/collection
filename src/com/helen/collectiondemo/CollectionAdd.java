package com.helen.collectiondemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by helenlee on 2017/9/18.
 */
public class CollectionAdd {
    public static void main(String [] args){
        List<String> list = new ArrayList<>();
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++){
            list.add("字符串" + i);
        }
        System.out.println("Arryalist 用时为：" + (System.currentTimeMillis() - timeMillis));


        List<String> list1 = new LinkedList<String>();
        timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++){
            list1.add("字符串" + i);
        }
        System.out.println("LinkedList 用时为：" + (System.currentTimeMillis() - timeMillis));
    }
}
