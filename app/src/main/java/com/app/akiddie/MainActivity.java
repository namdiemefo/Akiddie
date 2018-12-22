package com.app.akiddie;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.app.akiddie.Adapters.BookAdapter;
import com.app.akiddie.Entities.BooksObject;
import com.app.akiddie.Helpers.BookSample;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView bookRecyclerView;
    private Toolbar toolbar;
    private DrawerLayout mDrawableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bookRecyclerView = findViewById(R.id.akiddie_recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        bookRecyclerView.setLayoutManager(gridLayoutManager);
        bookRecyclerView.setHasFixedSize(true);

        BookAdapter bookAdapter = new BookAdapter(MainActivity.this, BookSample.BOOKS_OBJECTS);
        bookRecyclerView.setAdapter(bookAdapter);

        mDrawableLayout = findViewById(R.id.drawer_layout);


    }


   // private List<BooksObject> getAllBooks() {
     //   List<BooksObject> books = new ArrayList<BooksObject>();

      //  books.add(new BooksObject(1, "Jandu", R.drawable.artboard_1));
        // books.add(new BooksObject(2, "Rilwan", R.drawable.artboard_2));
       // books.add(new BooksObject(3, "Tunde", R.drawable.artboard_3));
       // books.add(new BooksObject(4, "Chiamaka", R.drawable.artboard_4));
      //  books.add((new BooksObject(5, " Chisom", R.drawable.artboard_5)));
      //  books.add(new BooksObject(6, "Kelvin", R.drawable.artboard_6));
      //  return books;
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Context context;
        switch (item.getItemId()) {
            case R.id.book_icon:
                mDrawableLayout.openDrawer(GravityCompat.START);


        }
        return super.onOptionsItemSelected(item);
    }
}
