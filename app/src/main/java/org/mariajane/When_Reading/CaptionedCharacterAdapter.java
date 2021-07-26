package org.mariajane.When_Reading;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedCharacterAdapter extends RecyclerView.Adapter <CaptionedCharacterAdapter.ViewHolder> {

    String[] names;
    String[] books;

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;

        public ViewHolder(CardView cv)
        {
            super(cv);
            cardView = cv;
        }
    }

    public CaptionedCharacterAdapter(String[] names, String[] books) {
        this.names = names;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup. getContext()).inflate(R.layout.card_captioned_character, viewGroup, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;
        TextView nameView = cardView.findViewById(R.id.name_text_view);
        nameView.setText(names[position]);
        nameView.setContentDescription(books[position]);
        TextView textView = cardView.findViewById(R.id.book_text_view);
        textView.setText(books[position]);
    }

    @Override
    public int getItemCount() {
        return books.length;
    }


}
