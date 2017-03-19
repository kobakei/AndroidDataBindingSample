package io.github.kobakei.dbsample;

import android.content.Context;
import android.view.View;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */

public class MainActivityViewModel {

    private final Context context;

    public MainActivityViewModel(Context context) {
        this.context = context;
    }

    public void onButton1Click(View view) {
        Navigator.navigateToImagePicasso(context);
    }

    public void onButton2Click(View view) {
        Navigator.navigateToTextStrike(context);
    }

    public void onButton3Click(View view) {
        Navigator.navigateToRecyclerScroll(context);
    }

    public void onButton4Click(View view) {
        Navigator.navigateToListChoice(context);
    }
}
