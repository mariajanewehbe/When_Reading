package org.mariajane.When_Reading;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        TextView booksTextView = findViewById(R.id.book_count_text_view);
        TextView pagesTextView = findViewById(R.id.pages_count_text_view);

        TextView romanceTextView = findViewById(R.id.romance_count_text_view);
        TextView fictionTextView = findViewById(R.id.fiction_count_text_view);
        TextView scifiTextView = findViewById(R.id.scifi_count_text_view);
        TextView fantasyTextView = findViewById(R.id.fantasy_count_text_view);
        TextView mysteryTextView = findViewById(R.id.mystery_count_text_view);
        TextView horrorTextView = findViewById(R.id.horror_count_text_view);
        TextView nonfictionTextView = findViewById(R.id.nonfiction_count_text_view);

        TextView charactersTextView = findViewById(R.id.fav_count_text_view);
        TextView quotesTextView = findViewById(R.id.quotes_count_text_view);

        try {
            SQLiteOpenHelper sqLiteOpenHelperBooks = new BookSQLiteOpenHelper(this);
            SQLiteDatabase db1 = sqLiteOpenHelperBooks.getReadableDatabase();

            SQLiteOpenHelper sqLiteOpenHelperQuotes = new QuoteSQLiteOpenHelper(this);
            SQLiteDatabase db2 = sqLiteOpenHelperQuotes.getReadableDatabase();

            SQLiteOpenHelper sqLiteOpenHelperFav = new FavCharacterSQLiteOpenHelper(this);
            SQLiteDatabase db3 = sqLiteOpenHelperFav.getReadableDatabase();

            Cursor cursor1 = db1.query("BOOK",
                    new String[] {"COUNT(_id) AS count"},
                    null, null, null, null, null);
            if(cursor1.moveToFirst()) {
                String book_count = "" + cursor1.getInt(0);
                booksTextView.setText(book_count);
            }

            Cursor cursor2 = db1.query("BOOK",
                    new String[] {"SUM(PAGES) AS sum"},
                    null, null, null, null, null);
            if(cursor2.moveToFirst()) {
                String pages_count = "" + cursor2.getInt(0);
                pagesTextView.setText(pages_count);
            }

            Cursor cursor3 = db1.query("BOOK",
                    new String[] {"GENRE"},
                    "GENRE = ?",
                    new String[] {"Romance"},
                    null, null, null);
            if(cursor3.moveToFirst()) {
                String romance_count = "" + cursor3.getCount();
                romanceTextView.setText(romance_count);
            }

            Cursor cursor4 = db1.query("BOOK",
                    new String[] {"GENRE"},
                    "GENRE = ?",
                    new String[] {"General Fiction"},
                    null, null, null);
            if(cursor4.moveToFirst()) {
                String fiction_count = "" + cursor4.getCount();
                fictionTextView.setText(fiction_count);
            }

            Cursor cursor5 = db1.query("BOOK",
                    new String[] {"GENRE"},
                    "GENRE = ?",
                    new String[] {"Sci-Fi"},
                    null, null, null);
            if(cursor5.moveToFirst()) {
                String scifi_count = "" + cursor5.getCount();
                scifiTextView.setText(scifi_count);
            }

            Cursor cursor6 = db1.query("BOOK",
                    new String[] {"GENRE"},
                    "GENRE = ?",
                    new String[] {"Fantasy"},
                    null, null, null);
            if(cursor6.moveToFirst()) {
                String fantasy_count = "" + cursor6.getCount();
                fantasyTextView.setText(fantasy_count);
            }

            Cursor cursor7 = db1.query("BOOK",
                    new String[] {"GENRE"},
                    "GENRE = ?",
                    new String[] {"Mystery"},
                    null, null, null);
            if(cursor7.moveToFirst()) {
                String mystery_count = "" + cursor7.getCount();
                mysteryTextView.setText(mystery_count);
            }

            Cursor cursor8 = db1.query("BOOK",
                    new String[] {"GENRE"},
                    "GENRE = ?",
                    new String[] {"Horror"},
                    null, null, null);
            if(cursor8.moveToFirst()) {
                String horror_count = "" + cursor8.getCount();
                horrorTextView.setText(horror_count);
            }

            Cursor cursor9 = db1.query("BOOK",
                    new String[] {"GENRE"},
                    "GENRE = ?",
                    new String[] {"General Nonfiction"},
                    null, null, null);
            if(cursor9.moveToFirst()) {
                String nonfiction_count = "" + cursor9.getCount();
                nonfictionTextView.setText(nonfiction_count);
            }

            Cursor cursor10 = db3.query("FAVORITES",
                    new String[] {"COUNT(_id) AS count"},
                    null, null, null, null, null);
            if(cursor10.moveToFirst()) {
                String fav_count = "" + cursor10.getInt(0);
                charactersTextView.setText(fav_count);
            }

            Cursor cursor11 = db2.query("QUOTES",
                    new String[] {"COUNT(_id) AS count"},
                    null, null, null, null, null);
            if(cursor11.moveToFirst()) {
                String quotes_count = "" + cursor11.getInt(0);
                quotesTextView.setText(quotes_count);
            }

        } catch(Exception e) {
            Toast.makeText(this, "Database is unavailable.", Toast.LENGTH_SHORT).show();
        }
    }
}