package com.uts_pbp_c_9229.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.uts_pbp_c_9229.R;
import com.uts_pbp_c_9229.adapter.RecyclerViewCategory;
import com.uts_pbp_c_9229.adapter.RecyclerViewDestination;
import com.uts_pbp_c_9229.dao.Category;
import com.uts_pbp_c_9229.dao.Destination;
import com.uts_pbp_c_9229.listdata.CategoryList;
import com.uts_pbp_c_9229.listdata.DestinationList;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private ArrayList<Category> categories;
    private ArrayList<Destination> destinations;
    private RecyclerView recyclerViewDestination, recyclerViewCategory;
    private RecyclerViewDestination adapterDestination;
    private RecyclerViewCategory adapterCategory;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextInputEditText searchView;
    private String selectedCategory = "Beach";

    public CategoryFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        destinations = new DestinationList().destinations;
        categories   = new CategoryList().categories;
        searchView   = view.findViewById(R.id.searchview);

        //recycler view Destination
        recyclerViewDestination = view.findViewById(R.id.recyclerview_destination);
        adapterDestination = new RecyclerViewDestination(view.getContext(), destinations);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerViewDestination.setLayoutManager(mLayoutManager);
        recyclerViewDestination.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDestination.setAdapter(adapterDestination);
        adapterDestination.getFilterByCategory().filter(selectedCategory);

        //recycler view Category
        recyclerViewCategory = view.findViewById(R.id.recyclerview_category);
        adapterCategory = new RecyclerViewCategory(view.getContext(), categories, selectedCategory,
                new RecyclerViewCategory.OnItemClickListener() {
                    @Override
                    public void onItemClick(Category category) {
                        selectedCategory = category.getName();
                        adapterCategory.notifyDataSetChanged();
                        adapterDestination.getFilterByCategory().filter(category.getName());
                    }
                });
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(view.getContext(),
                        LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);
        recyclerViewCategory.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCategory.setAdapter(adapterCategory);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapterDestination.getFilter().filter(charSequence);
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