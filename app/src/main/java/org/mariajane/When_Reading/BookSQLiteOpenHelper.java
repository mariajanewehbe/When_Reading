package org.mariajane.When_Reading;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BookSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "chooseBook";
    private static final int DB_VERSION = 1;

    public BookSQLiteOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BOOK (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TITLE TEXT," +
                "PAGES INTEGER," +
                "AUTHOR TEXT," +
                "GENRE TEXT," +
                "REVIEW TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
