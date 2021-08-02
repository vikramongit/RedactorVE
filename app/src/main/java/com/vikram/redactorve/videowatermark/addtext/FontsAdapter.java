package com.vikram.redactorve.videowatermark.addtext;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.vikram.redactorve.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FontsAdapter extends Adapter<FontsAdapter.ViewHolder> {
    String a = "";
    Activity b;
    List<String> c;
    FontProvider d;
    LayoutInflater e;
    int f = R.color.Button_Normal_Color;
    int g = R.color.Button_Selected_Color;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView m;

        public ViewHolder(View view) {
            super(view);
            //this.m = (TextView) view.findViewById(R.id.textView);
        }
    }

    public FontsAdapter(Activity activity, List<String> list, FontProvider fontProvider) {
        this.e = LayoutInflater.from(activity);
        this.d = fontProvider;
        this.b = activity;
        this.c = list;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (this.a.equals("")) {
            viewHolder.m.setTextColor(ContextCompat.getColor(this.b, this.f));
        } else if (i == Integer.parseInt(this.a)) {
            viewHolder.m.setTextColor(ContextCompat.getColor(this.b, this.g));
        } else {
            viewHolder.m.setTextColor(ContextCompat.getColor(this.b, this.f));
        }
        viewHolder.m.setTypeface(this.d.getTypeface((String) this.c.get(i)));
    }

    public int getItemCount() {
        return this.c.size();
    }

    public void setSelection(int i) {
        this.a = String.valueOf(i);
        notifyDataSetChanged();
    }
}
