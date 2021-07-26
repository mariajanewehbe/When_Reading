package org.mariajane.When_Reading;

import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class GenreListActivity extends ListActivity {

    public static final String ITEM_NUMBER = "item_number";

    Cursor cursor;

    public GenreListActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String genre = intent.getStringExtra(ITEM_NUMBER);

        try{
            SQLiteOpenHelper sqLiteOpenHelper = new BookSQLiteOpenHelper(this);
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

            if(genre.equals("General Fiction")) {
                cursor = db.query("BOOK",
                        new String[]{"_id", "TITLE"},
                        "GENRE = ?",
                        new String[]{"General Fiction"},
                        null, null, null);
            }

            if(genre.equals("Sci-Fi")) {
                cursor = db.query("BOOK",
                        new String[]{"_id", "TITLE"},
                        "GENRE = ?",
                        new String[]{"Sci-Fi"},
                        null, null, null);
            }

            if(genre.equals("Fantasy")) {
                cursor = db.query("BOOK",
                        new String[]{"_id", "TITLE"},
                        "GENRE = ?",
                        new String[]{"Fantasy"},
                        null, null, null);
            }

            if(genre.equals("Romance")) {
                cursor = db.query("BOOK",
                        new String[]{"_id", "TITLE"},
                        "GENRE = ?",
                        new String[]{"Romance"},
                        null, null, null);
            }

            if(genre.equals("Mystery")) {
                cursor = db.query("BOOK",
                        new String[]{"_id", "TITLE"},
                        "GENRE = ?",
                        new String[]{"Mystery"},
                        null, null, null);
            }

            if(genre.equals("Horror")) {
                cursor = db.query("BOOK",
                        new String[]{"_id", "TITLE"},
                        "GENRE = ?",
                        new String[]{"Horror"},
                        null, null, null);
            }

            if(genre.equals("General Nonfiction")) {
                cursor = db.query("BOOK",
                        new String[]{"_id", "TITLE"},
                        "GENRE = ?",
                        new String[]{"General Nonfiction"},
                        null, null, null);
            }

                CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                        cursor, new String[]{"TITLE"}, new int[]{android.R.id.text1}, 0);
                ListView listView = getListView();
                listView.setAdapter(cursorAdapter);
        } catch (Exception e)
        {
            Toast.makeText(this, "Database is unavailable.", Toast.LENGTH_SHORT).show();
        }

    }


}