package com.example.android.teatime;

/**
 * Created by manvi on 28/8/17.
 */

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.android.teatime.IdlingResource.SimpleIdlingResource;
import com.example.android.teatime.model.Tea;

import java.util.ArrayList;

/**
 * Created by manvi on 28/8/17.
 */

class ImageDownloader {
    private static final int DELAY_MILLIS = 3000;
    private static Toast mToast;

    private final static ArrayList<Tea> mTea = new ArrayList<> ();
    interface DelayerCallBack{
        void onDone(ArrayList<Tea> teaArray);
    }

    /**
     * This method is meant to simulate downloading a large image file which has a loading time
     * delay. This could be similar to downloading an image from the internet.
     * For simplicity, in this hypothetical situation, we've provided the image in
     * {@link drawable/order_activity_tea_image.jpg}.
     * We simulate a delay time of {@link #DELAY_MILLIS} and once the time
     * is up we return the image back to the calling activity via a {@link DelayerCallback}.
     * @param callback used to notify the caller asynchronously
     *
     */

    static void downloadImage(Context context, final DelayerCallBack callBack, @Nullable final SimpleIdlingResource simpleIdlingResource){

        //set the idling resource to null since background image is started.
        if(simpleIdlingResource !=null){
            simpleIdlingResource.setIdleState(false);
        }

        // Display a toast to let the user know the images are downloading
        String text = context.getString(R.string.loading_msg);
        int duration = Toast.LENGTH_LONG;
        if(mToast ==null) {
            mToast = Toast.makeText(context, text, duration);
            mToast.show();
        }else {
            mToast.cancel();
        }

        mTea.add(new Tea(context.getString(R.string.black_tea_name), R.drawable.black_tea));
        mTea.add(new Tea(context.getString(R.string.green_tea_name), R.drawable.green_tea));
        mTea.add(new Tea(context.getString(R.string.white_tea_name), R.drawable.white_tea));
        mTea.add(new Tea(context.getString(R.string.oolong_tea_name), R.drawable.oolong_tea));
        mTea.add(new Tea(context.getString(R.string.honey_lemon_tea_name), R.drawable.honey_lemon_tea));
        mTea.add(new Tea(context.getString(R.string.chamomile_tea_name), R.drawable.chamomile_tea));

        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(callBack !=null){
                    callBack.onDone(mTea);
                }
                if(simpleIdlingResource!=null){
                    simpleIdlingResource.setIdleState(true);
                }
            }
        }, DELAY_MILLIS);
    }
}

