package com.example.wgumobileappmcclane.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wgumobileappmcclane.Entities.TermEntities;
import com.example.wgumobileappmcclane.R;
import com.example.wgumobileappmcclane.termDetails;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    public class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termItemView;

        public TermViewHolder(@NonNull View itemView) {
            super(itemView);
            termItemView = itemView.findViewById(R.id.tvTerm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final TermEntities current = mTerm.get(position);
                    Intent intent = new Intent(context, termDetails.class);
                    intent.putExtra("termTitle", current.getTermTitle());
                    intent.putExtra("startMonth", Integer.toString(current.getStartMonth()));
                    intent.putExtra("startYear", Integer.toString(current.getStartYear()));
                    intent.putExtra("endMonth", Integer.toString(current.getEndMonth()));
                    intent.putExtra("endYear", Integer.toString(current.getEndYear()));
                    intent.putExtra("termId", current.getTermId());
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });
        }
    }

    private final LayoutInflater mInflater;
    private final Context context;

    private List<TermEntities> mTerm;

    public TermAdapter (Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TermViewHolder holder, int position) {

        if(mTerm != null){
            final TermEntities current = mTerm.get(position);
            holder.termItemView.setText(current.getTermTitle());
        }else {
            holder.termItemView.setText("No Term");
        }
    }

    public void setWords(List<TermEntities>words){
        mTerm = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mTerm !=null)
            return mTerm.size();
        else return 0;
    }
}