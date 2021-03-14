package com.limitless.rumusku.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.limitless.rumusku.DatarAdapter;
import com.limitless.rumusku.R;
import com.limitless.rumusku.model.DatarData;
import com.limitless.rumusku.model.DatarModel;

import java.util.ArrayList;

public class FlatFragment extends Fragment {
    private RecyclerView rvDatar;
    private ArrayList<DatarModel> list = new ArrayList<>();
    private EditText etSearch;
    public DatarAdapter datarAdapter = new DatarAdapter(list);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_flat, container, false);

        rvDatar = root.findViewById(R.id.rv_flat);
        rvDatar.setHasFixedSize(true);

        list.addAll(DatarData.getListData());
        rvDatar.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDatar.setAdapter(datarAdapter);

        etSearch = root.findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return root;
    }

    public void filter(String text) {
        ArrayList<DatarModel> temp = new ArrayList();
        for(DatarModel d: list){
            if(d.getNama().toLowerCase().contains(text)){
                temp.add(d);
            }
        }
        datarAdapter.filterlist(temp);

    }

}