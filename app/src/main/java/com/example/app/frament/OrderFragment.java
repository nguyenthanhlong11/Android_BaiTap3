package com.example.app.frament;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Adapter.OderAdapter;
import com.example.app.Object.cart;
import com.example.app.R;
import com.example.app.model.Popular;
import com.example.app.model.Recommended;
import com.example.app.tabnavi;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {
    View v;
    RecyclerView recyclerViewOder;
    private List<cart> cartList;
    private List<Recommended> recommendedList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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
        cartList= tabnavi.sql.getCart();
        recommendedList=tabnavi.sql.getRecoment();
        // Inflate the layout for this fragment
        Log.d("them sp","hien thi gio hang");
        v=inflater.inflate(R.layout.fragment_oder, container, false);
        recyclerViewOder=v.findViewById(R.id.recyCart);
        OderAdapter oderAdapter=new OderAdapter(getContext(),cartList,recommendedList);
        recyclerViewOder.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewOder.setAdapter(oderAdapter);
        return v;

    }
}