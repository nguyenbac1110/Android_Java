package com.example.baitap.qlsv_all;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.baitap.R;
import com.example.baitap.qlsv_all.adapter.TaiKhoanAdapter;
import com.example.baitap.qlsv_all.dao.CustomDAO;
import com.example.baitap.qlsv_all.model.TaiKhoan;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaiKhoan_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaiKhoan_Frag extends Fragment {
    private RecyclerView recyclerView;
    private TaiKhoanAdapter adapter;
    private ArrayList<TaiKhoan> taiKhoanList;
    private CustomDAO CustomDAO;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TaiKhoan_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaiKhoan_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static TaiKhoan_Frag newInstance(String param1, String param2) {
        TaiKhoan_Frag fragment = new TaiKhoan_Frag();
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
        View view = inflater.inflate(R.layout.fragment_tai_khoan_, container, false);

        recyclerView = view.findViewById(R.id.rcvtk);

        CustomDAO = new CustomDAO(getContext());
        taiKhoanList = CustomDAO.selectAllTaiKhoan();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TaiKhoanAdapter(getContext(), taiKhoanList);
        recyclerView.setAdapter(adapter);

        return view;
        //return inflater.inflate(R.layout.fragment_tai_khoan_, container, false);
    }
}