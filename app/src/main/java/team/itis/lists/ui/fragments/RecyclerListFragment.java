package team.itis.lists.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import team.itis.lists.R;
import team.itis.lists.ui.adapters.StrangeAdapter;

public class RecyclerListFragment extends Fragment {

    final String LOG_TAG = "RecyclerList";
    String[] names;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.fragment_recycler, container, false);

        mRecyclerView = fragment_view.findViewById(R.id.recycler_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        names = getResources().getStringArray(R.array.names);

        mAdapter = new StrangeAdapter(names, R.layout.strange_row);
        mRecyclerView.setAdapter(mAdapter);

        return fragment_view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }


}