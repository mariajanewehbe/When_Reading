package org.mariajane.When_Reading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    public static final String ITEM_NUMBER = "item_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        int itemNum = intent.getIntExtra(ITEM_NUMBER, 0);

        if(itemNum == R.id.nav_quotes) {
            QuoteFragment quoteFragment = new QuoteFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, quoteFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.commit();
        }
        if(itemNum == R.id.nav_fav_characters) {
            CharacterFragment characterFragment = new CharacterFragment();
            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
            ft1.replace(R.id.frame, characterFragment);
            ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft1.addToBackStack(null);
            ft1.commit();
        }
    }
}