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
     * 这种方案的确定：1)入侵式，必须实现 Comparable<T> 如果是别人提供的jar包中的对象我们无法实现排序的功能
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
