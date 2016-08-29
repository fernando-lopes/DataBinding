package com.flandep.android.example.databinding.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flandep.android.example.databinding.R;
import com.flandep.android.example.databinding.databinding.FragmentUserBinding;
import com.flandep.android.example.databinding.model.User;

/**
 * Created by Fernando Lopes on 28/08/2016.
 */
public class UserFragment extends Fragment {

    private static final String USER = "USER";

    private User mUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createInstance(savedInstanceState);
    }

    private void createInstance(Bundle savedInstanceState) {
        boolean isSavedInstance = savedInstanceState != null && savedInstanceState.containsKey(USER);
        mUser = isSavedInstance ? (User) savedInstanceState.getParcelable(USER) : new User();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        binding.setUser(mUser);
        return binding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(USER, mUser);
        super.onSaveInstanceState(outState);
    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }
}
