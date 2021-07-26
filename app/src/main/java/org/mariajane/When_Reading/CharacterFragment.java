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

public class CharacterFragment extends Fragment {

    public CharacterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView characterRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_character, container, false);
        int count = 0;

        try {
            SQLiteOpenHelper sqLiteOpenHelper = new FavCharacterSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor_count = db.query("FAVORITES",
                    new String[] {"COUNT(_id) AS count"},
                    null, null, null, null, null);
            if(cursor_count.moveToFirst()) {
                count = cursor_count.getInt(0);
            }

            String[] names = new String[count];
            String[] books = new String[count];
            for(int i=0; i<count; i++) {
                Cursor cursor = db.query("FAVORITES",
                        new String[] {"NAME", "BOOK"},
                        "_id = ?",
                        new String[] {Integer.toString(i+1)},
                        null, null, null);
                if(cursor.moveToFirst()) {
                    names[i] = cursor.getString(0);
                    books[i] = cursor.getString(1);
                }
            }
            CaptionedCharacterAdapter captionedCharacterAdapter = new CaptionedCharacterAdapter(names, books);
            characterRecycler.setAdapter(captionedCharacterAdapter);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            characterRecycler.setLayoutManager(layoutManager);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Database is not available from char frag.", Toast.LENGTH_SHORT).show();
        }

        return characterRecycler;
    }
}