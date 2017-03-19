package io.github.kobakei.dbsample;

import android.databinding.ObservableField;

/**
 * Created by keisukekobayashi on 2017/03/19.
 */

public class ImagePicassoActivityViewModel {

    public ObservableField<String> url = new ObservableField<>();

    public ImagePicassoActivityViewModel() {
        this.url.set("https://ja.gravatar.com/userimage/47707269/a3f2615011f5b4260f13055826f486ff.jpeg");
    }
}
