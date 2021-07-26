package org.mariajane.When_Reading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HowLongToReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_long_to_read);


    }

    public void onClickCalculate(View view)
    { //calculates how long it takes to read a certain book using a specific formula
        EditText pagesEditText = findViewById(R.id.pages_edit_text);
        EditText wpmEditText = findViewById(R.id.wpm_edit_text);

        String p = pagesEditText.getText().toString();
        int pages = Integer.parseInt(p);

        String w = wpmEditText.getText().toString();
        int wpm = Integer.parseInt(w);

        int words = pages * 300; //there are on average 300 words in one page in a book
        int minutes = (int) Math.ceil(words/wpm);

        TextView resultTextView = findViewById(R.id.result_text_view);

        String text;

        if(minutes < 60)
            text = "It would take you " + minutes + " minutes to finish " + pages + " pages if you read at a rate of " + wpm + " words per minute.";
        else
        {
            int hours = minutes / 60;
            int min = minutes % 60;
            text = "It would take you " + hours + " hours and " + min + " minutes to finish " + pages + " pages if you read at a rate of " + wpm + " words per minute.";
        }
        resultTextView.setText(text);
    }
}