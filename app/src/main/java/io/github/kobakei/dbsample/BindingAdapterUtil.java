package io.github.kobakei.dbsample;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */
@InverseBindingMethods({
        @InverseBindingMethod(
                type = ListView.class,
                attribute = "checkedItemPositions",
                event = "checkedItemPositionsAttrChanged",
                method = "getCheckedItemPositions"
        )
})
public class BindingAdapterUtil {

    /**
     * TextViewの打ち消し線
     * @param textView
     * @param strike
     */
    @BindingAdapter(value = {"strike"})
    public static void setTextStrike(TextView textView, boolean strike) {
        if (strike) {
            TextPaint paint = textView.getPaint();
            paint.setFlags(TextPaint.STRIKE_THRU_TEXT_FLAG);
            paint.setAntiAlias(true);
        }
    }

    //-------------------------------

    /**
     * RecyclerViewのスクロールイベント
     * @param recyclerView
     * @param onScrollStateChanged
     * @param onScrolled
     */
    @BindingAdapter(value = {"onScrollStateChanged", "onScrolled"}, requireAll = false)
    public static void setRecyclerViewScroll(RecyclerView recyclerView,
                                             final OnScrollStateChanged onScrollStateChanged,
                                             final OnScrolled onScrolled) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (onScrollStateChanged != null) {
                    onScrollStateChanged.onScrollStateChanged(recyclerView, newState);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (onScrolled != null) {
                    onScrolled.onScrolled(recyclerView, dx, dy);
                }
            }
        });
    }

    public interface OnScrollStateChanged {
        void onScrollStateChanged(RecyclerView recyclerView, int newState);
    }

    public interface OnScrolled {
        void onScrolled(RecyclerView recyclerView, int dx, int dy);
    }

    //-------------------------------

    @BindingAdapter(value = "checkedItemPositions")
    public static void setListViewCheckedItemPositions(ListView listView, SparseBooleanArray positions) {
        if (positions != null) {
            for (int i = 0; i < positions.size(); i++) {
                listView.setItemChecked(positions.keyAt(i), positions.valueAt(i));
            }
        }
    }

    @BindingAdapter(value = "checkedItemPositionsAttrChanged")
    public static void setCheckedItemPositionsAttrChanged(ListView listView,
                                                          final InverseBindingListener checkedItemPositionsAttrChanged) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (checkedItemPositionsAttrChanged != null) {
                    checkedItemPositionsAttrChanged.onChange();
                }
            }
        });
    }
}
