package io.github.artenes.xyzreader.ui;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.artenes.xyzreader.R;

public class ParagraphAdapter extends RecyclerView.Adapter<ParagraphAdapter.ParagraphViewHolder> {

    private String[] mParagraphs = new String[]{};

    public void setData(String[] paragraphs) {
        if (paragraphs != null) {
            mParagraphs = paragraphs;
            notifyDataSetChanged();
        }
    }

    @Override
    public ParagraphAdapter.ParagraphViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ParagraphViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.paragraph, parent, false));
    }

    @Override
    public void onBindViewHolder(ParagraphAdapter.ParagraphViewHolder holder, int position) {
        holder.bind(mParagraphs[position]);
    }

    @Override
    public int getItemCount() {
        return mParagraphs.length;
    }

    public class ParagraphViewHolder extends RecyclerView.ViewHolder {

        private final TextView mParagraph;

        public ParagraphViewHolder(View itemView) {
            super(itemView);
            mParagraph = (TextView) itemView.findViewById(R.id.paragraph);
        }

        public void bind(String paragraph) {
            mParagraph.setText(Html.fromHtml(paragraph.replaceAll("(\r\n|\n)", "<br />"), 0));
        }

    }

}