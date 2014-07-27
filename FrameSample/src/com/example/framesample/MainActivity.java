/***
 * Tile : Sample Class 
 * @author Ramesh M Nair
 *
 * **/
package com.example.framesample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.imageframeanimation.AnimationSpeed;
import com.imageframeanimation.AnimatorControl;
import com.imageframeanimation.FrameImageAnimator;

public class MainActivity extends Activity {

	/* Image Set To Animate */

	public static int[] mImageToAnimate = new int[] { R.drawable.frame_000,
			R.drawable.frame_001, R.drawable.frame_002, R.drawable.frame_003,
			R.drawable.frame_004, R.drawable.frame_005, R.drawable.frame_006,
			R.drawable.frame_007, R.drawable.frame_008, R.drawable.frame_009,
			R.drawable.frame_010, R.drawable.frame_011, R.drawable.frame_012,
			R.drawable.frame_013, R.drawable.frame_014, R.drawable.frame_015,
			R.drawable.frame_016, R.drawable.frame_017, R.drawable.frame_018,
			R.drawable.frame_019 };

	//Declaring Variables
	
	FrameImageAnimator mAnimateImageView;

	AnimatorControl mAnimatorControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// FrameImageAnimatorimageView
		mAnimateImageView = (FrameImageAnimator) findViewById(R.id.animater_IV);

		mAnimatorControl = new AnimatorControl();

		// Setting the Animation Speed (SLOW,MEDIUM or FAST)
		int mAnimationSpeed = AnimationSpeed.FAST;

		// Applying the Images to Animate with the speed AnimationControl
		mAnimatorControl.mApplyFrames(mImageToAnimate, MainActivity.this,
				mAnimateImageView, mAnimationSpeed);
		
		// Starts The Animation
		mAnimatorControl.start();
		
		Button samples = (Button) findViewById(R.id.animatonchanger_btn);

		samples.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Some Sample Frame Animations
				startActivity(new Intent(MainActivity.this, LoadingScreen.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void medium(View v) {
		int mAnimationSpeed = AnimationSpeed.MEDIUM;
		exampleSpeed(mAnimationSpeed);
		mToastmsg("MEDIUM SELECTED");
	}

	public void fast(View v) {

		int mAnimationSpeed = AnimationSpeed.FAST;
		exampleSpeed(mAnimationSpeed);
		mToastmsg("FAST SELECTED");

	}

	public void slow(View v) {
		int mAnimationSpeed = AnimationSpeed.SLOW;
		exampleSpeed(mAnimationSpeed);
		mToastmsg("SLOW SELECTED");

	}

	public void start(View v) {
		mAnimatorControl.start();
		mToastmsg("ANIMATION STARTED");

	}

	public void stop(View v) {
		mAnimatorControl.stop();
		mToastmsg("STOPPED");

	}

	public void exampleSpeed(int speed) {
		
		//Stops the animation
		mAnimatorControl.stop();

		int mAnimationSpeed = AnimationSpeed.FAST;

		mAnimatorControl.mApplyFrames(mImageToAnimate, MainActivity.this,
				mAnimateImageView, speed);

		mAnimatorControl.start();
	}

	public void mToastmsg(String msg) {
		Toast.makeText(getApplicationContext(), msg, 1).show();
	}
}
