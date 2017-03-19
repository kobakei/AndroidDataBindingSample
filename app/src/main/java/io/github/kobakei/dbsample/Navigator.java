package io.github.kobakei.dbsample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */

public class Navigator {

    public static void navigateToImagePicasso(@NonNull Context from) {
        Intent intent = new Intent(from, ImagePicassoActivity.class);
        from.startActivity(intent);
    }

    public static void navigateToTextStrike(@NonNull Context from) {
        Intent intent = new Intent(from, TextStrikeActivity.class);
        from.startActivity(intent);
    }

    public static void navigateToRecyclerScroll(@NonNull Context from) {
        Intent intent = new Intent(from, RecyclerScrollActivity.class);
        from.startActivity(intent);
    }

    public static void navigateToListChoice(@NonNull Context from) {
        Intent intent = new Intent(from, ListChoiceActivity.class);
        from.startActivity(intent);
    }
}
