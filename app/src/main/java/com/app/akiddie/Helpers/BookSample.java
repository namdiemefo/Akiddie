package com.app.akiddie.Helpers;

import com.app.akiddie.Entities.BooksObject;
import com.app.akiddie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by namdi on 12/20/18.
 */

public class BookSample  {

    public static final List<BooksObject> BOOKS_OBJECTS = new ArrayList<BooksObject>();


        static {
            BooksObject newbook1 = new BooksObject(1, "Jandu", R.drawable.artboard_1);
            BOOKS_OBJECTS.add(newbook1);

            BooksObject newbook2 = new BooksObject(2, "Rilwan", R.drawable.artboard_2);
            BOOKS_OBJECTS.add(newbook2);

            BooksObject newbook3 = new BooksObject(3, "Tunde", R.drawable.artboard_3);
            BOOKS_OBJECTS.add(newbook3);

            BooksObject newbook4 = new BooksObject(4, "Chiamaka", R.drawable.artboard_4);
            BOOKS_OBJECTS.add(newbook4);

            BooksObject newbook5 = new BooksObject(5, "Chisom", R.drawable.artboard_5);
            BOOKS_OBJECTS.add(newbook5);

            BooksObject newbook6 = new BooksObject(6, "Kelvin", R.drawable.artboard_6);
            BOOKS_OBJECTS.add(newbook6);

            BooksObject newbook7 = new BooksObject(7, "Leke", R.drawable.artboard_7);
            BOOKS_OBJECTS.add(newbook7);

            BooksObject newbook8 = new BooksObject(8, "Kelechi", R.drawable.artboard_8);
            BOOKS_OBJECTS.add(newbook8);

            BooksObject newbook9 = new BooksObject(9, "Ola", R.drawable.artboard_9);
            BOOKS_OBJECTS.add(newbook9);
        }



}
