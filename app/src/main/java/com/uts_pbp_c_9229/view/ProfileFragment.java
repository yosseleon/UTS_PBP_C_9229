package com.uts_pbp_c_9229.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uts_pbp_c_9229.LoginActivity;
import com.uts_pbp_c_9229.R;
import com.uts_pbp_c_9229.dao.User;
import com.uts_pbp_c_9229.listdata.UserList;

public class ProfileFragment extends Fragment {

    private TextView tvName, tVEmail, tvPhone, tvLogout;
    private ImageView ivProfile;
    private SharedPreferences preference;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvName      = view.findViewById(R.id.tv_name);
        tVEmail     = view.findViewById(R.id.tv_email);
        tvPhone     = view.findViewById(R.id.tv_noHp);
        tvLogout    = view.findViewById(R.id.tv_logout);
        ivProfile   = view.findViewById(R.id.profile_image);

        preference = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        editor = preference.edit();
        User user = new UserList().getUserById(preference.getString("userId", null));

        tvName.setText(user.getName());
        tVEmail.setText(user.getEmail());
        tvPhone.setText(user.getNoHp());
        Glide.with(view.getContext())
                .load(user.getFoto())
                .circleCrop()
                .into(ivProfile);

        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("isLogin", "tidak");
                editor.putString("userId", "");
                editor.apply();

                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        return view;
    }

    public void callParentMethod(){
        getActivity().onBackPressed();
    }
}