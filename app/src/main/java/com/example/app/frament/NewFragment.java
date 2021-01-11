package com.example.app.frament;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.Adapter.PopularAdapter;
import com.example.app.Adapter.RecomentAdapter;
import com.example.app.R;
import com.example.app.model.Popular;
import com.example.app.model.Recommended;
import com.example.app.tabnavi;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewFragment extends Fragment {
    View v;
    RecyclerView recyclerView,recommentRecy   ;
    private List<Popular> populars=new ArrayList<>();
    private List<Recommended> recommendedList=new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewFragment() {
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
    public static NewFragment newInstance(String param1, String param2) {
        NewFragment fragment = new NewFragment();
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
        populars=tabnavi.sql.getAllPopular();
        recommendedList=tabnavi.sql.getRecoment();
        Log.d("hien thij", recommendedList.get(1).getName());

    }

//    @Override
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //popular
        v= inflater.inflate(R.layout.fragment_new, container, false);
        recyclerView= v.findViewById(R.id.popular_recycler);
        PopularAdapter popularAdapter=new PopularAdapter(getContext(),populars);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(popularAdapter);

        //recoment recycler
        recommentRecy= v.findViewById(R.id.recommended_recycler);
        RecomentAdapter recomentAdapter=new RecomentAdapter(getContext(),recommendedList);
        recommentRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        recommentRecy.setAdapter(recomentAdapter);
        return v;
    }
}