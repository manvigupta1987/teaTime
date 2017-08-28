package com.example.android.teatime.IdlingResource;

import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by manvi on 28/8/17.
 */

public class SimpleIdlingResource implements IdlingResource {

    private AtomicBoolean mIsIdleNow = new AtomicBoolean(true);
    @Nullable private volatile ResourceCallback mCallBack;

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallBack = callback;
    }

    /**
     * Sets the new idle state, if isIdleNow is true, it pings the {@link ResourceCallback}.
     * @param isIdleNow false if there are pending operations, true if idle.
     */
    public void setIdleState(boolean isIdleNow){
        mIsIdleNow.set(isIdleNow);
        if(isIdleNow && mCallBack!=null){
            mCallBack.onTransitionToIdle();
        }
    }
}
