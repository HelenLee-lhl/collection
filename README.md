# collection
## 数据结构-集合相关问题
### 1 ArrayList VS LinkedList
``` Java
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

        /*********初始化 arrayList和linkedlist数据**********************/
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
        /*********初始化 arrayList和linkedlist数据**********************/
        System.out.println("arrayList VS linkedlist 之随机读取");
        
        /*********arrayList VS linkedlist 之随机读取**********************/
        
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

        
        /*********arrayList VS linkedlist 之随机读取**********************/
        




        System.out.println("arrayList VS linkedlist 之随机新增");
        
        /*********arrayList VS linkedlist 之随机插入**********************/
        
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
        
        /*********arrayList VS linkedlist 之随机插入**********************/
        




        System.out.println("arrayList VS linkedlist 之随机删除");
        
        /*********arrayList VS linkedlist 之随机删除**********************/
        
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
        
        /*********arrayList VS linkedlist 之随机删除**********************/
        
    }
}
//结果输出：
Arryalist 用时为：8118
LinkedList 用时为：14039
arrayList VS linkedlist 之随机读取
arrayList 用时为：0
linkedlist 用时为：3693
arrayList VS linkedlist 之随机新增
arrayList 用时为：2888
linkedlist 用时为：36725
arrayList 之开头插入 用时为：5731
linkedlist 之开头插入 用时为：0
arrayList 之中间插入 用时为：2893
linkedlist 之中间插入 用时为：78895
arrayList VS linkedlist 之随机删除
arrayList 用时为：2835
linkedlist 用时为：37509
```

#### 比较
* 末尾新增，排出arrayList 数组扩容的时间节点，两者开销是确定的，arrayList 要比 linkedlist （需要维护上下node关系）快些。
* 开头新增，linkedlist 要比 arrayList（这是极端情况，主要消耗在元素移动上） 快些
* 随机新增或者删除，这种情况大部分情况都是arrayList 要比 linkedlist 快些，和我们想象的不同（数组需要元素移动而链表只需要重新把某个被删除的节点左右节点关联上即可） linkedlist 确定某个index 元素都要遍历半个链表开销很大。

### 2 CollectionSort
```Java
package com.helen.collectiondemo;

import java.util.*;

/**
 * Created by helenlee on 2017/9/24.
 */
public class CollectionSort {
    public static void main(String[] args) {
        //-------------------------------------------------------------------//
        //-------------------List<String>排序---------------------------------//
        //-------------------------------------------------------------------//

        //初始化集合
        String[] books = new String[]{"BBOOK/b author", "ABOOK/a author", "DBOOK/d author", "CBOOK/c author"};
        List<String> bookls = new ArrayList<>();
        bookls.addAll(Arrays.asList(books));
        printBookls(bookls);
        //字符串型排序
        Collections.sort(bookls);
        System.out.println("-----------下面是排序-----------------");
        printBookls(bookls);
        //-------------------------------------------------------------------//
        //-------------------List<String>排序---------------------------------//
        //-------------------------------------------------------------------//

        //-------------------------------------------------------------------//
        //-------------------List<Object>排序方法一：实现Comparable<T>接口------//
        //-------------------------------------------------------------------//
        List<Book> listB = new ArrayList<>();
        //初始化结合
        for (int i = 0; i < books.length; i++) {
            String[] splits = books[i].split("/");
            Book book = new Book();
            book.setTitle(splits[0]);
            book.setAuthor(splits[1]);
            listB.add(book);
        }
        for (Book book : listB) {
            System.out.println(book.toString());
        }
        Collections.sort(listB);
        System.out.println("-----------下面是排序-----------------");

        for (Book book : listB) {
            System.out.println(book.toString());
        }
        // -------------------------------------------------------------------//
        //-------------------List<Object>排序方法一：实现Comparable<T>接口-------//
        //--------------------------------------------------------------------//


        // -------------------------------------------------------------------//
        //-------------------List<Object>排序方法二：实现Comparable<T>接口-------//
        //--------------------------------------------------------------------//
        List<Book> listB1 = new ArrayList<>();
        //初始化结合
        for (int j = 0; j < books.length; j++) {
            String[] splits = books[j].split("/");
            Book book = new Book();
            book.setTitle(splits[0]);
            book.setAuthor(splits[1]);
            listB1.add(book);
        }
        for (Book book : listB1) {
            System.out.println(book.toString());
        }
        //自定义的比较器
        CustomerCompare customerCompare = new CustomerCompare();
        Collections.sort(listB1,customerCompare);
        System.out.println("-----------下面是排序-----------------");
        for (Book book : listB1) {
            System.out.println(book.toString());
        }
        // -------------------------------------------------------------------//
        //-------------------List<Object>排序方法二：实现Comparable<T>接口-------//
        //--------------------------------------------------------------------//

    }

    /**
     * 自定义的比较器
     * 优点：1)非入侵式
     *      2)可拓展，用户可以根据需要自定义多个比较器
     */
    static class CustomerCompare implements Comparator<Book>{
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    /**
     * 需要排序的对象需要实现Comparable<T>接口的compareTo方法
     * 这种方案的缺点：1)入侵式，必须实现 Comparable<T> 如果是别人提供的jar包中的对象我们无法实现排序的功能
     *              2)不可拓展，排序的方案只能有一种。这里我们使用title排序如果我们使用author排序无法实现
     */
    static class Book implements Comparable<Book>{

        private String title;
        private String author;

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public Book setTitle(String title) {
            this.title = title;
            return this;
        }

        public Book setAuthor(String author) {
            this.author = author;
            return this;
        }

        /**
         * 实现Comparable的compareTo并按照title字段进行排序
         * @param o
         * @return
         */

        @Override
        public int compareTo(Book o) {
            return this.title.compareTo(o.title);
        }


        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    private static void printBookls(List<String> bookls) {
        for (String bookl : bookls) {
            System.out.println(bookl);
        }
    }
}

```
#### 比较的排序 Comparable vs Comparator
* Comparable 需要排序的对象需要实现Comparable<T>接口的compareTo方法
     * 这种方案的确定：1)入侵式，必须实现 Comparable<T> 如果是别人提供的jar包中的对象我们无法实现排序的功能
     * 2)不可拓展，排序的方案只能有一种。这里我们使用title排序如果我们使用author排序无法实现
* Comparator 自定义的比较器
     * 优点：1)非入侵式
     * 2)可拓展，用户可以根据需要自定义多个比较器
