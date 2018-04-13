package team.itis.lists.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import team.itis.lists.R;

public class SimpleListFragment extends Fragment {

    final String LOG_TAG = "SimpleList";
    String[] names;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.fragment_single, container, false);

        // находим список
        ListView lvMain = fragment_view.findViewById(R.id.simple_list);

        // получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);


        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                names
        );

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);
            }
        });

        return fragment_view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }


}