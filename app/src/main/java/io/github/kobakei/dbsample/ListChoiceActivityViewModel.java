package io.github.kobakei.dbsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */

public class ListChoiceActivityViewModel extends BaseObservable {

    public ObservableList<Item> items;

    public ObservableField<SparseBooleanArray> checkedItemPositions;

    public ListChoiceActivityViewModel() {
        this.items = new ObservableArrayList<>();
        for (int i = 0; i < 30; i++) {
            this.items.add(Item.create(i));
        }

        this.checkedItemPositions = new ObservableField<>();
    }

    public void onButtonClick(View view) {
        String text = "position: ";
        SparseBooleanArray array = checkedItemPositions.get();
        if (array != null) {
            for (int i = 0; i < array.size(); i++) {
                if (array.valueAt(i)) {
                    text += array.keyAt(i) + " ";
                }
            }
        }
        Log.v("List", text);
    }
}
