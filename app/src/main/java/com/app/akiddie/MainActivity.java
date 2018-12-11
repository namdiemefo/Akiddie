package com.app.akiddie;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.akiddie.Adapters.BookAdapter;
import com.app.akiddie.Entities.BooksObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView bookRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bookRecyclerView = findViewById(R.id.akiddie_recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        bookRecyclerView.setLayoutManager(gridLayoutManager);
        bookRecyclerView.setHasFixedSize(true);

        BookAdapter bookAdapter = new BookAdapter(MainActivity.this, getAllBooks());
        bookRecyclerView.setAdapter(bookAdapter);

    }

    private List<BooksObject> getAllBooks() {
        List<BooksObject> books = new ArrayList<BooksObject>();

        books.add(new BooksObject(1, "Jandu", R.drawable.artboard_1));
        books.add(new BooksObject(2, "Rilwan", R.drawable.artboard_2));
        books.add(new BooksObject(3, "Tunde", R.drawable.artboard_3));
        books.add(new BooksObject(4, "Chiamaka", R.drawable.artboard_4));
        books.add((new BooksObject(5, " Chisom", R.drawable.artboard_5)));
        books.add(new BooksObject(6, "Kelvin", R.drawable.artboard_6));
        return books;
    }
}
