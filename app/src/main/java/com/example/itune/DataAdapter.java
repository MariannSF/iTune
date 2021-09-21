package com.example.itune;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends ArrayAdapter<DataServices.App> {

    ArrayList<DataServices.App> dataApp;

    public DataAdapter(@NonNull Context context, int resource, @NonNull List<DataServices.App> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data_row_item, parent, false);
         /*ViewHolder viewHolder = new ViewHolder();
        viewHolder.textViewAppName = convertView.findViewById(R.id.textViewAppName);
        viewHolder.textViewArtistName = convertView.findViewById(R.id.textViewArtistName);
        viewHolder.textViewReleaseDate = convertView.findViewById(R.id.textViewReleaseDate);
        convertView.setTag(viewHolder);*/


        }

        DataServices.App app = getItem(position);
        TextView textViewAppName = convertView.findViewById(R.id.textViewDataAppName);
        TextView textViewArtistName = convertView.findViewById(R.id.textViewDataArtistName);
        TextView textViewReleaseDate = convertView.findViewById(R.id.textViewDataReleaseDate);

        textViewAppName.setText(app.name);
        textViewArtistName.setText(app.artistName);
        textViewReleaseDate.setText(app.releaseDate);


        return convertView;

    }
   /* private  static class ViewHolder{
        TextView textViewAppName ;
        TextView textViewArtistName;
        TextView textViewReleaseDate;
    }*/
}
