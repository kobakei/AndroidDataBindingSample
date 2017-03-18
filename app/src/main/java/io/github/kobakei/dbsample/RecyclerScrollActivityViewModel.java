package io.github.kobakei.dbsample;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */

public class RecyclerScrollActivityViewModel {

    public ObservableList<Item> items;

    public RecyclerScrollActivityViewModel(Context context) {
        items = new ObservableArrayList<>();
        for (int i = 0; i < 30; i++) {
            items.add(Item.create(i));
        }
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Log.v("Scroll", "dx=" + dx + " dy=" + dy);
    }
}
