/***
* Tile : Samples 
* @author Ramesh M Nair
*
* **/
package com.example.framesample;

import com.imageframeanimation.AnimationSpeed;
import com.imageframeanimation.AnimatorControl;
import com.imageframeanimation.FrameImageAnimator;

import android.app.Activity;
import android.os.Bundle;


public class LoadingScreen extends Activity {

	public static int[] mloadingToAnimate = new int[] { R.drawable.frame_000lo,
			R.drawable.frame_001lo, R.drawable.frame_002lo,
			R.drawable.frame_003lo, R.drawable.frame_004lo,
			R.drawable.frame_005lo, R.drawable.frame_006lo,
			R.drawable.frame_007lo, R.drawable.frame_008lo,
			R.drawable.frame_009lo, R.drawable.frame_010lo,
			R.drawable.frame_011lo };

	
	public static int[] mloadingToAnimatetwo = new int[] {
			R.drawable.frame_000brg, R.drawable.frame_001brg,
			R.drawable.frame_002brg, R.drawable.frame_003brg,
			R.drawable.frame_004brg, R.drawable.frame_005brg };

	FrameImageAnimator mAnimateImageView, mAnimateImageViewTwo;
		

	AnimatorControl mAnimatorControl, mAnimatorControlTwo
			;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loadingscreen);

		mAnimateImageView = (FrameImageAnimator) findViewById(R.id.animater_IV);
		mAnimateImageViewTwo = (FrameImageAnimator) findViewById(R.id.animaterthree_IV);

		

		mAnimatorControl = new AnimatorControl();
		mAnimatorControlTwo = new AnimatorControl();
		
		int mAnimationSpeed = AnimationSpeed.MEDIUM;
		
		int mAnimationSpeedFast = AnimationSpeed.FAST;

		
		mAnimatorControl.mApplyFrames(mloadingToAnimate, LoadingScreen.this,
				mAnimateImageView, mAnimationSpeedFast);

		
		mAnimatorControlTwo.mApplyFrames(mloadingToAnimatetwo,
				LoadingScreen.this, mAnimateImageViewTwo, mAnimationSpeed);
		
		
		mAnimatorControl.start();
		
		mAnimatorControlTwo.start();
		
	}

}
