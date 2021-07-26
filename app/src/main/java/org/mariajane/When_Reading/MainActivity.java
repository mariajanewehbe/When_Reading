package org.mariajane.When_Reading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import  androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_main);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.nav_genre:
                        Intent intent0 = new Intent(MainActivity.this, GenreActivity.class);
                        startActivity(intent0);
                        return false;
                    case R.id.nav_quotes:
                        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                        intent.putExtra(DisplayActivity.ITEM_NUMBER, R.id.nav_quotes);
                        startActivity(intent);
                        return false;
                    case R.id.nav_fav_characters:
                        Intent intent1 = new Intent(MainActivity.this, DisplayActivity.class);
                        intent1.putExtra(DisplayActivity.ITEM_NUMBER, R.id.nav_fav_characters);
                        startActivity(intent1);
                        return false;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_add:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_list:
                Intent intent_list = new Intent(this, BookListActivity.class);
                startActivity(intent_list);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickCheckStats(View view)
    {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

    public void onClickHowLongToRead(View view)
    {
        Intent intent = new Intent(this, HowLongToReadActivity.class);
        startActivity(intent);
    }
}