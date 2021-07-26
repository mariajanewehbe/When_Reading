package org.mariajane.When_Reading;

import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class BookListActivity extends ListActivity {
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            SQLiteOpenHelper sqLiteOpenHelper = new BookSQLiteOpenHelper(this);
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            cursor = db.query("BOOK",
                    new String[] {"_id", "TITLE"},
                    null, null, null, null, null);

            CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                    cursor, new String[]{"TITLE"}, new int[]{android.R.id.text1}, 0);
            ListView listView = getListView();
            listView.setAdapter(cursorAdapter);
        } catch (Exception e)
        {
            Toast.makeText(this, "Database is unavailable.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
        intent.putExtra(BookDetailActivity.ITEM_NUMBER, (int) id);
        startActivity(intent);
    }
}