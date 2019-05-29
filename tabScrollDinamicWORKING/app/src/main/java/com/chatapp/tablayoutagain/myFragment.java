package com.chatapp.tablayoutagain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class myFragment extends Fragment {
 
    public myFragment() {
        // Required empty public constructor
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout, container, false);

        TextView tv_fragment= (TextView) view.findViewById(R.id.tv_fragment);
        tv_fragment.setText( TextUtils.join("\n", MainActivity.opened_channel_arr_content.get(MainActivity.tabLayout.getSelectedTabPosition())) );  //rellena el textview con el arraylist del contenido almacenado

        return view;
    }
 
}