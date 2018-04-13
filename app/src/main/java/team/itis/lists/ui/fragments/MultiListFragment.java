package team.itis.lists.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import team.itis.lists.R;

public class MultiListFragment extends Fragment implements View.OnClickListener {

    final String LOG_TAG = "MultiList";
    String[] names;
    ListView lvMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.fragment_multi, container, false);

        // находим список
        lvMain = fragment_view.findViewById(R.id.multi_list);

        // получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);

        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_multiple_choice,
                names
        );

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        Button btnChecked = fragment_view.findViewById(R.id.checked_button);
        btnChecked.setOnClickListener(this);
        return fragment_view;
    }

    public void onClick(View arg0) {
        // пишем в лог выделенные элементы
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        for (int i = 0; i < sbArray.size(); i++) {
            int key = sbArray.keyAt(i);
            if (sbArray.get(key))
                Log.d(LOG_TAG, names[key]);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }


}