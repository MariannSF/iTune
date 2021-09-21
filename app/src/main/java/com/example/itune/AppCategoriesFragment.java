package com.example.itune;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.itune.databinding.FragmentAppCategoriesBinding;

import java.util.ArrayList;


public class AppCategoriesFragment extends Fragment {
    ArrayList<String > data = new ArrayList<>();
    LinearLayoutManager layoutManager;
    ArrayAdapter<String> adapter;
    ListView listView;
    String c;


    public AppCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppCategoriesBinding.inflate(inflater, container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    FragmentAppCategoriesBinding binding;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("App Categories");

        //data = DataServices.getAppCategories();
        ArrayList<String> category = DataServices.getAppCategories();
        listView = binding.listViewAppCategories;
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, category );
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.goToTop(category.get(i));


            }
        });




    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AppCategoriesFragment.AppCategoryListener) {
            mListener = (AppCategoryListener) context;
        }


    }

    AppCategoryListener mListener;

    public interface AppCategoryListener{
        public void goToTop(String category);



    }
}