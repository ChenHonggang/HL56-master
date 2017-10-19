package com.example.jialian.bottomnavigationbardemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jialian.bottomnavigationbardemo.observable.EventBadgeItem;


public class ItemFragment extends Fragment {


    private View mLayout;

    public ItemFragment() {
        // Required empty public constructor
    }

    public static ItemFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("title",title);
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final String title = this.getArguments().getString("title");
        switch (title){

            case "0":
            {
                mLayout = inflater.inflate(R.layout.fragment_scoop, container, false);

                break;
            }
            case "1":
            {
                mLayout = inflater.inflate(R.layout.fragment_home, container, false);
                break;
            }case "2":
            {
                mLayout = inflater.inflate(R.layout.fragment_mine, container, false);
                break;
            }case "3":
            {
                mLayout = inflater.inflate(R.layout.fragment_scoop, container, false);
                break;
            }
        }


        Button titleView = (Button) mLayout.findViewById(R.id.tv_title);
        titleView.setText("f:"+title);
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBadgeItem.getInstance().post("f:"+title);
            }
        });
        return mLayout;
    }

}
