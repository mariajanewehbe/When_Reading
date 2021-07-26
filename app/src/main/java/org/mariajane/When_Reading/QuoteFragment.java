package org.mariajane.When_Reading;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class QuoteFragment extends Fragment {

    public QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView quoteRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_quote, container, false);
        int count = 0;

        try {
            SQLiteOpenHelper sqLiteOpenHelper = new QuoteSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor_count = db.query("QUOTES",
                    new String[] {"COUNT(_id) AS count"},
                    null, null, null, null, null);
            if(cursor_count.moveToFirst()) {
                count = cursor_count.getInt(0);
            }

            String[] quotes = new String[count];
            String[] authors = new String[count];
            for(int i=0; i<count; i++) {
                Cursor cursor = db.query("QUOTES",
                        new String[] {"QUOTE", "AUTHOR"},
                        "_id = ?",
                        new String[] {Integer.toString(i+1)},
                        null, null, null);
                if(cursor.moveToFirst()) {
                    quotes[i] = cursor.getString(0);
                    authors[i] = cursor.getString(1);
                }
            }
            CaptionedQuotesAdapter captionedQuotesAdapter = new CaptionedQuotesAdapter(quotes, authors);
            quoteRecycler.setAdapter(captionedQuotesAdapter);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            quoteRecycler.setLayoutManager(layoutManager);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Database is not available.", Toast.LENGTH_SHORT).show();
        }

        return quoteRecycler;
    }
}