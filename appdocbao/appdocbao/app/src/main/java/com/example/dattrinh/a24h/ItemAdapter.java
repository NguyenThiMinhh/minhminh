package com.example.dattrinh.a24h;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private ArrayList<Item> arr;

    public ItemAdapter(@NonNull Context context,  @NonNull ArrayList<Item> objects) {
        super(context,android.R.layout.simple_list_item_1, objects);
        inflater = LayoutInflater.from(context);
        arr = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (v==null){
            v = inflater.inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.img = v.findViewById(R.id.imgSex);
            viewHolder.tvTitle = v.findViewById(R.id.tvTitle);
            viewHolder.tvDescription = v.findViewById(R.id.tvDescription);
            viewHolder.tvPubdate = v.findViewById(R.id.tvPubdate);
            v.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) v.getTag();
        }

        Item item = arr.get(position);
        viewHolder.tvTitle.setText(item.getTitle());
        viewHolder.tvDescription.setText(item.getDescription());
        viewHolder.tvPubdate.setText(item.getPubdate());
        Glide.with(getContext())
                .load(item.getImg())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.img);
        return v;
    }

    class ViewHolder{
        ImageView img;
        TextView tvTitle;
        TextView tvDescription;
        TextView tvPubdate;
    }
}
