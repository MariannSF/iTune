package com.example.itune;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itune.databinding.FragmentTopPaidAppsBinding;

import java.util.ArrayList;
import java.util.List;


public class TopPaidAppsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CAT = "param1";
    String category;
    ListView listView;
    DataAdapter adapter;

    // TODO: Rename and change types of parameters



    public TopPaidAppsFragment() {
        // Required empty public constructor
    }
    public static TopPaidAppsFragment newInstance(String category) {
        TopPaidAppsFragment fragment = new TopPaidAppsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CAT, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = (String) getArguments().getString(ARG_CAT);
        }
    }

    FragmentTopPaidAppsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTopPaidAppsBinding.inflate(inflater, container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    ArrayList<DataServices.App> display;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Top Paid Apps");

        listView= binding.listViewTopPaidApps;
        display =DataServices.getAppsByCategory(category);
        adapter = new DataAdapter(getActivity(), R.layout.data_row_item,display);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

            if(context instanceof TopPaidAppsFragment.TopApps) {
                mListener = (TopApps) context;
            }
    }

    TopApps  mListener;

    public interface TopApps{
        public void goToTop(String category);

    }
}

class DataAdapter extends ArrayAdapter<DataServices.App>{


    public DataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DataServices.App> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data_row_item, parent, false);

        }


        DataServices.App display = getItem(position);

        //Toast.makeText(getContext(), "got here", Toast.LENGTH_SHORT).show();
        Log.d("demo", "getView: "+ display.artistName);

        TextView textViewAppName = convertView.findViewById(R.id.textViewDataAppName);
        TextView textViewArtistName = convertView.findViewById(R.id.textViewDataArtistName);
        TextView textViewReleaseDate = convertView.findViewById(R.id.textViewDataReleaseDate);

        textViewAppName.setText(display.name);
        textViewArtistName.setText(display.artistName);
        textViewReleaseDate.setText(display.releaseDate);


        return convertView;

    }

}

