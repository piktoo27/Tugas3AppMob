package com.example.quranapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSurah extends RecyclerView.Adapter<AdapterSurah.SurahViewHolder> {
    ArrayList<SurahModel> arrayListSurahs;

    public AdapterSurah(ArrayList<SurahModel> arrayListSurahs) {
        this.arrayListSurahs = arrayListSurahs;
    }

    @NonNull
    @Override
    public AdapterSurah.SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new SurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSurah.SurahViewHolder holder, int position) {
        final SurahModel surah = arrayListSurahs.get(position);

        holder.textViewSurahLatin.setText(surah.getNameSimple());
        holder.textViewTerjemahanSurah.setText(surah.getTranslatedName().getName());
        holder.textViewSurahArab.setText(surah.getNameArabic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailSurahActivity.class);
                intent.putExtra("Chapters", surah);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListSurahs.size();
    }

    public class SurahViewHolder extends RecyclerView.ViewHolder {
        TextView  textViewSurahLatin , textViewTerjemahanSurah, textViewSurahArab;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSurahLatin = itemView.findViewById(R.id.tvSurahLatin);
            textViewTerjemahanSurah = itemView.findViewById(R.id.tvTerjemahanSurah);
            textViewSurahArab = itemView.findViewById(R.id.tvSurahArab);


        }
    }
}
