package com.hyuchiha.boilerplate.app.common.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;

/**
 * Simple animation methods to help UI components smoothly make transitions.
 * This class supports: Fade In, Fade Out, Slide Up From Bottom, Slide Down to Bottom.
 * Created by luisburgos on 10/5/16.
 */

public class BaseAnimator {

    /**
     * This method fades in a UI component.
     * @param viewGroup set of views to be animated.
     * @param duration for the animation to be executed.
     */
    public static void fadeIn(ViewGroup viewGroup, int duration) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(duration);
        animateViewGroup(viewGroup, fadeIn);
        viewGroup.setVisibility(View.VISIBLE);
    }

    /**
     * This method fades in a UI component.
     * The animation has a 2 seconds default duration defined.
     * @param viewGroup set of views to be animated.
     */
    public static void fadeIn(ViewGroup viewGroup){
        fadeIn(viewGroup, 2000);
    }

    /**
     * This method fades out a UI component.
     * @param viewGroup set of views to be animated.
     * @param duration for the animation to be executed.
     */
    public static void fadeOut(ViewGroup viewGroup, int duration) {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(duration);
        animateViewGroup(viewGroup, fadeOut);
        viewGroup.setVisibility(View.INVISIBLE);
    }

    /**
     * This method fades out a UI component.
     * The animation has a 1 second default duration defined.
     * @param viewGroup set of views to be animated.
     */
    public static void fadeOut(ViewGroup viewGroup){
        fadeOut(viewGroup, 1000);
    }

    /**
     * This method slides down a UI component to the bottom screen.
     * @param context of the caller activity or fragment.
     * @param viewGroup set of views to be animated.
     * @param duration for the animation to be executed.
     */
    public static void slideDown(Context context, ViewGroup viewGroup, int duration) {
        /*Animation bottomDown = AnimationUtils.loadAnimation(context, R.anim.bottom_down);
        bottomDown.setDuration(duration);
        viewGroup.startAnimation(bottomDown);
        viewGroup.setVisibility(View.INVISIBLE);*/
    }

    /**
     * This method slides down a UI component to the bottom screen.
     * The animation has a default duration defined on the XML file.
     * @param context of the caller activity or fragment.
     * @param viewGroup set of views to be animated.
     */
    public static void slideDown(Context context, ViewGroup viewGroup) {
       /* Animation bottomDown = AnimationUtils.loadAnimation(context, R.anim.bottom_down);
        viewGroup.startAnimation(bottomDown);
        viewGroup.setVisibility(View.INVISIBLE);*/
    }

    /**
     * This method slides up a UI component from the bottom screen.
     * The animation has a default duration defined on the XML file.
     * @param context of the caller activity or fragment.
     * @param viewGroup set of views to be animated.
     * @param duration for the animation to be executed.
     */
    public static void slideUp(Context context, ViewGroup viewGroup, int duration) {
        /*Animation bottomUp = AnimationUtils.loadAnimation(context, R.anim.bottom_up);
        bottomUp.setDuration(duration);
        viewGroup.startAnimation(bottomUp);
        viewGroup.setVisibility(View.VISIBLE);*/
    }

    /**
     * This method slides up a UI component from the bottom screen.
     * The animation has a default duration defined on the XML file.
     * @param context of the caller activity or fragment.
     * @param viewGroup set of views to be animated.
     */
    public static void slideUp(Context context, ViewGroup viewGroup) {
        /*Animation bottomUp = AnimationUtils.loadAnimation(context, R.anim.bottom_up);
        viewGroup.startAnimation(bottomUp);
        viewGroup.setVisibility(View.VISIBLE);*/
    }

    /**
     * Helper method to add animations to specific view group. This method does not makes a
     * strat
     * @param viewGroup views to be animated.
     * @param animations set of animations to be added to the given view group.
     */
    private static void animateViewGroup(ViewGroup viewGroup, Animation... animations ){
        AnimationSet animationSet = new AnimationSet(false);
        for(Animation animation: animations){
            animationSet.addAnimation(animation);
        }
        viewGroup.setAnimation(animationSet);
    }
}
