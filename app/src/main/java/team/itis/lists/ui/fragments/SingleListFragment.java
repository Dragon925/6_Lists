package team.itis.lists.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import team.itis.lists.R;

public class SingleListFragment extends Fragment implements View.OnClickListener {

    final String LOG_TAG = "SingleList";
    String[] names;
    ListView lvMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.fragment_single, container, false);

        // находим список
        lvMain = fragment_view.findViewById(R.id.single_list);

        // получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);

        lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_single_choice,
                names
        );

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        Button btnChecked = fragment_view.findViewById(R.id.checked_button);
        btnChecked.setOnClickListener(this);

        return fragment_view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }


    public void onClick(View arg0) {
        int checkedI = lvMain.getCheckedItemPosition();
        if (checkedI == -1)
            return;
        // пишем в лог выделенный элемент
        Log.d(LOG_TAG, "checked: " + names[checkedI]);
    }
}