package org.mariajane.When_Reading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetailActivity extends AppCompatActivity {

    public static final String ITEM_NUMBER = "item_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Intent intent = getIntent();
        int itemNum = intent.getIntExtra(ITEM_NUMBER, 0);

        TextView textViewTitle = findViewById(R.id.title_text_view);
        TextView textViewAuthor = findViewById(R.id.author_text_view);
        TextView textViewPages = findViewById(R.id.pages_text_view);
        TextView textViewGenre = findViewById(R.id.genre_text_view);
        TextView textViewReview = findViewById(R.id.review_text_view);

        try {
            SQLiteOpenHelper sqLiteOpenHelper = new BookSQLiteOpenHelper(this);
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor = db.query("BOOK", new String[] {"TITLE", "PAGES", "AUTHOR", "GENRE", "REVIEW"},
                    "_id = ?", new String[] {Integer.toString(itemNum)},
                    null, null, null);

            if(cursor.moveToFirst()) {
                String titleText = cursor.getString(0);
                int pagesText = cursor.getInt(1);
                String authorText = cursor.getString(2);
                String genreText = cursor.getString(3);
                String reviewText = cursor.getString(4);

                String pages = "" + pagesText;

                textViewTitle.setText(titleText);
                textViewPages.setText(pages);
                textViewAuthor.setText(authorText);
                textViewGenre.setText(genreText);
                textViewReview.setText(reviewText);
            }
            cursor.close();
            db.close();

        } catch (Exception e) {
            Toast.makeText(this, "Database in the unavailable.", Toast.LENGTH_SHORT).show();
        }
    }
}