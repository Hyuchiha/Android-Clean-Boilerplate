package com.hyuchiha.boilerplate.lib.base;

import android.widget.ImageView;

/**
 * Created by Kev' on 08/07/2016.
 */
public interface ImageLoader {
    void load(ImageView imgAvatar, String url);
    void setOnFinishedImageLoadingListener(Object listener);
}
