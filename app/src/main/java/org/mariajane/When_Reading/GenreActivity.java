package org.mariajane.When_Reading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

    }

    public void onClickSelect(View view)
    {
        Intent intent = new Intent(GenreActivity.this, GenreListActivity.class);
        Spinner genre_chosen = findViewById(R.id.genre_select_spinner);
        String genre = genre_chosen.getSelectedItem().toString();
        intent.putExtra(GenreListActivity.ITEM_NUMBER, genre);
        startActivity(intent);
    }
}