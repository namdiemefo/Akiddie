package com.app.akiddie.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.akiddie.Entities.BooksObject;
import com.app.akiddie.R;

import java.util.List;

/**
 * Created by namdi on 12/11/18.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private static final String TAG = BookAdapter.class.getSimpleName();
    private Context context;
    private List<BooksObject> allBooks ;

    public BookAdapter(Context context, List<BooksObject> allBooks) {
        this.context = context;
        this.allBooks = allBooks;
    }
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForBookItem = R.layout.book_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = layoutInflater.inflate(layoutIdForBookItem, parent, shouldAttachToParentImmediately);
        BookViewHolder bookViewHolder = new BookViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        final BooksObject singleBook = allBooks.get(position);
        holder.bookImage.setImageResource(singleBook.getBookCoverImage());
        holder.bookName.setText(singleBook.getBookName());
    }


    @Override
    public int getItemCount() {
        return allBooks.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookName;

        public BookViewHolder(View itemView) {
            super(itemView);

            bookImage = itemView.findViewById(R.id.book_cover_image);
            bookName = itemView.findViewById(R.id.book_name);
        }
    }
}
