package com.uts_pbp_c_9229.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.uts_pbp_c_9229.adapter.RecyclerViewHome;
import com.uts_pbp_c_9229.dao.User;
import com.uts_pbp_c_9229.listdata.CityList;
import com.uts_pbp_c_9229.dao.City;
import com.uts_pbp_c_9229.R;
import com.uts_pbp_c_9229.listdata.UserList;

import java.util.ArrayList;

public class HomeFragment<RecyclerViewAdapter> extends Fragment {

    private ArrayList<City> cityList;
    private RecyclerView recyclerView;
    private RecyclerViewHome adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextInputEditText searchView;
    private SharedPreferences preference;
    private TextView tvWelcome;

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cityList = new CityList().cities;
        searchView = view.findViewById(R.id.searchview);
        tvWelcome  = view.findViewById(R.id.tv_welcome);
        preference = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        User user = new UserList().getUserById(preference.getString("userId", null));
        tvWelcome.setText("Welcome, "+ user.getName().substring(0,5));

        //recycler view
        recyclerView = view.findViewById(R.id.recyclerview_city);
        adapter = new RecyclerViewHome(view.getContext(), cityList);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    public void callParentMethod(){
        getActivity().onBackPressed();
    }
}
