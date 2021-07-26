package org.mariajane.When_Reading;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedQuotesAdapter extends RecyclerView.Adapter <CaptionedQuotesAdapter.ViewHolder>  {

    String[] quotes;
    String[] authors;

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;

        public ViewHolder(CardView cv)
        {
            super(cv);
            cardView = cv;
        }
    }

    public CaptionedQuotesAdapter(String[] quotes, String[] authors)
    {
        this.quotes = quotes;
        this.authors = authors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup. getContext()).inflate(R.layout.card_captioned_quote, viewGroup, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull CaptionedQuotesAdapter.ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;
        TextView quoteView = cardView.findViewById(R.id. info_image_view);
        quoteView.setText(quotes[position]);
        quoteView.setContentDescription(authors[position]);
        TextView textView = cardView.findViewById(R.id. info_text_view);
        textView.setText(authors[position]);
    }

    @Override
    public int getItemCount() {
        return authors.length;
    }
}
