package com.example.itune;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopPaidAppsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopPaidAppsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CAT = "param1";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String title;
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
            mParam1 = getArguments().getString(ARG_CAT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_paid_apps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Top Paid Apps");

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        /*    if(context instanceof TopPaidAppsFragment.TopApps) {
                mListener = (TopApps) context;
            } else{
                throw new RuntimeException(context.toString() + "");
            }*/



    }

    TopApps  mListener;

    public interface TopApps{
        public void goToTop(String category);



    }
}


