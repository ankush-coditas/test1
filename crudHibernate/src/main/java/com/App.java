package com;

import com.bean.Book;
import com.dao.BookDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int ch,i;
        String bn,an,pn;
        float p;
        Book b= new Book();




                    System.out.println("Enter Book Details==>Book name,author name and price");
                    b=new Book();
                    b.setBname(br.readLine());
                    b.setAname(br.readLine());
                    b.setPrice(Float.parseFloat(br.readLine()));
                    BookDao.insertBook(b);


                    System.out.println("Update Book Details==> Book name and price==>");
                    b=new Book();
                    bn=br.readLine();
                    p=Float.parseFloat(br.readLine());
                    i=BookDao.updateBook(bn,p);

                    System.out.println("Delete Book Details==> Book name");
                    b=new Book();
                    bn=br.readLine();
                    i=BookDao.deleteBook(bn);

                    System.out.println("Fetch Details.....");
                   List<Book> l= BookDao.fetchBooks();

                    for (Book list:l) {
                        System.out.println(list);
                    }


            }

    }

