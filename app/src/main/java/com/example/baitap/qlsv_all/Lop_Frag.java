package com.example.baitap.qlsv_all;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baitap.R;
import com.example.baitap.qlsv_all.adapter.LopAdapter;
import com.example.baitap.qlsv_all.dao.CustomDAO;
import com.example.baitap.qlsv_all.model.Lop;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Lop_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lop_Frag extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Lop> lopList;
    CustomDAO lopDAO;
    LopAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Lop_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lop_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Lop_Frag newInstance(String param1, String param2) {
        Lop_Frag fragment = new Lop_Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lop_, container, false);

        recyclerView = view.findViewById(R.id.rcvlop);

        lopDAO = new CustomDAO(getContext());
        lopList = lopDAO.selectAllLop(); // get all Lop data from database

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LopAdapter(getContext(), lopList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}