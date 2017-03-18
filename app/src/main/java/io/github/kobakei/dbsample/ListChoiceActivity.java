package io.github.kobakei.dbsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import io.github.kobakei.dbsample.databinding.ListChoiceActivityBinding;
import io.github.kobakei.dbsample.databinding.ListChoiceItemBinding;

public class ListChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListChoiceActivityViewModel viewModel = new ListChoiceActivityViewModel();

        ListChoiceActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.list_choice_activity);
        binding.setViewModel(viewModel);

        binding.listView.setAdapter(new MyAdapter(this, viewModel.items));

        binding.listView.getCheckedItemPositions();
    }

    static class MyAdapter extends ArrayAdapter<Item> {

        public MyAdapter(@NonNull Context context, @NonNull List<Item> objects) {
            super(context, 0, 0, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ListChoiceItemBinding binding;
            if (convertView == null) {
                binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.list_choice_item, parent, false);
            } else {
                binding = DataBindingUtil.getBinding(convertView);
            }

            binding.setItem(getItem(position));

            return binding.getRoot();
        }
    }
}
