package com.example.lab3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends ArrayAdapter<Animal> {
    private int reSourceId;

    public AnimalAdapter(Context context, int textViewResourceId, List<Animal> objects){
        super(context,textViewResourceId,objects);
        reSourceId=textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Animal animal=getItem(position);//获取当前Animal实例

        View view= LayoutInflater.from(getContext()).inflate(reSourceId,parent,false);

        TextView animalText=(TextView) view.findViewById(R.id.animal_text);
        ImageView animalImage=(ImageView) view.findViewById(R.id.animal_image);

        animalText.setText(animal.getName());
        animalImage.setImageResource(animal.getImageId());
        return view;
    }
}
