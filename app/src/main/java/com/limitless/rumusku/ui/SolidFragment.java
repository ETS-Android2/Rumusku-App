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

import com.limitless.rumusku.R;
import com.limitless.rumusku.RuangAdapter;
import com.limitless.rumusku.model.RuangData;
import com.limitless.rumusku.model.RuangModel;

import java.util.ArrayList;

public class SolidFragment extends Fragment {
    private RecyclerView rvRuang;
    private ArrayList<RuangModel> list = new ArrayList<>();
    public RuangAdapter ruangAdapter = new RuangAdapter(list);
    public EditText etSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_solid, container, false);

        rvRuang = root.findViewById(R.id.rv_solid);
        rvRuang.setHasFixedSize(true);

        list.addAll(RuangData.getListDataRuang());
        rvRuang.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRuang.setAdapter(ruangAdapter);

        etSearch = root.findViewById(R.id.et_searchs);
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
        ArrayList<RuangModel> temp = new ArrayList();
        for(RuangModel r: list){
            if(r.getNama().toLowerCase().contains(text)){
                temp.add(r);
            }
        }
        ruangAdapter.filterlist(temp);

    }
}