package org.mariajane.When_Reading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void onClickAddBook(View view)
    {
        EditText editText_title = findViewById(R.id.title_editText);
        EditText editText_author = findViewById(R.id.author_editText);
        EditText editText_pages = findViewById(R.id.pages_editText);
        EditText editText_review = findViewById(R.id.review_editText);
        Spinner genre_chosen = findViewById(R.id.genre_spinner);

        try{
            SQLiteOpenHelper sqLiteOpenHelper = new BookSQLiteOpenHelper(this);
            SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();

            String pages_string = editText_pages.getText().toString();
            int pages = Integer.parseInt(pages_string);

            ContentValues contentValues = new ContentValues();
            contentValues.put("TITLE", editText_title.getText().toString());
            contentValues.put("PAGES", pages);
            contentValues.put("AUTHOR", editText_author.getText().toString());
            contentValues.put("GENRE", genre_chosen.getSelectedItem().toString());
            contentValues.put("REVIEW", editText_review.getText().toString());
            db.insert("BOOK", null, contentValues);
            Toast.makeText(this, "The book is now added.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Database is not available.", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void onClickAddQuote(View view)
    {
        EditText editText_quote = findViewById(R.id.quote_editText);
        EditText editText_quote_author = findViewById(R.id.quote_author_editText);

        try {
            SQLiteOpenHelper sqLiteOpenHelper = new QuoteSQLiteOpenHelper(this);
            SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("QUOTE", editText_quote.getText().toString());
            contentValues.put("AUTHOR", editText_quote_author.getText().toString());
            db.insert("QUOTES", null, contentValues);
            Toast.makeText(this, "The quote is now added.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Database is not available.", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void onClickAddFavCharacter(View view)
    {
        EditText editText_name = findViewById(R.id.fav_name_editText);
        EditText editText_book_title = findViewById(R.id.title_fav_editText);

        try{
            SQLiteOpenHelper sqLiteOpenHelper = new FavCharacterSQLiteOpenHelper(this);
            SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("NAME", editText_name.getText().toString());
            contentValues.put("BOOK", editText_book_title.getText().toString());
            db.insert("FAVORITES", null, contentValues);
            Toast.makeText(this, "The character is now added.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Database is not available.", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}