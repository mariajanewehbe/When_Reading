package org.mariajane.When_Reading;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QuoteSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "chooseQuote";
    private static final int DB_VERSION = 1;

    public QuoteSQLiteOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE QUOTES (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "QUOTE TEXT," +
                "AUTHOR TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
