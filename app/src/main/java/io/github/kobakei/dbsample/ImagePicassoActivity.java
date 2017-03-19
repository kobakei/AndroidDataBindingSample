package io.github.kobakei.dbsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.kobakei.dbsample.databinding.ImagePicassoActivityBinding;

public class ImagePicassoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImagePicassoActivityViewModel viewModel = new ImagePicassoActivityViewModel();

        ImagePicassoActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.image_picasso_activity);
        binding.setViewModel(viewModel);
    }
}
