package io.github.kobakei.dbsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.github.kobakei.dbsample.databinding.RecyclerScrollActivityBinding;
import io.github.kobakei.dbsample.databinding.RecyclerScrollItemBinding;

public class RecyclerScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerScrollActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.recycler_scroll_activity);

        // ビューモデルの作成
        RecyclerScrollActivityViewModel viewModel = new RecyclerScrollActivityViewModel(this);
        binding.setViewModel(viewModel);

        // RecyclerViewのセットアップ
        binding.recyclerView.setAdapter(new ObservableRecyclerAdapter(this, viewModel.items));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class ObservableRecyclerAdapter extends RecyclerView.Adapter<BindingViewHolder> {

        private final Context context;
        private final ObservableList<Item> items;

        ObservableRecyclerAdapter(Context context, ObservableList<Item> items) {
            this.context = context;
            this.items = items;

            items.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Item>>() {
                @Override
                public void onChanged(ObservableList<Item> items) {
                    notifyDataSetChanged();
                }

                @Override
                public void onItemRangeChanged(ObservableList<Item> items, int i, int i1) {
                    notifyItemRangeChanged(i, i1);
                }

                @Override
                public void onItemRangeInserted(ObservableList<Item> items, int i, int i1) {
                    notifyItemRangeInserted(i, i1);
                }

                @Override
                public void onItemRangeMoved(ObservableList<Item> items, int i, int i1, int i2) {
                    notifyItemMoved(i, i1);
                }

                @Override
                public void onItemRangeRemoved(ObservableList<Item> items, int i, int i1) {
                    notifyItemRangeRemoved(i, i1);
                }
            });
        }

        @Override
        public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            RecyclerScrollItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.recycler_scroll_item, parent, false);
            return new BindingViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(BindingViewHolder holder, int position) {
            RecyclerScrollItemBinding binding = (RecyclerScrollItemBinding) holder.getBinding();
            binding.setItem(items.get(position));

            // Or
            // holder.getBinding().setVariable(BR.item, items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    /**
     * Data binding x RecyclerView用共通クラス
     */
    static class BindingViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        BindingViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}
