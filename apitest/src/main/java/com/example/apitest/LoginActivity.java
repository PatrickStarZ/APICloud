package com.example.apitest;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.drawable.JellyInterpolator;

public class LoginActivity extends AppCompatActivity implements OnClickListener {

	private Button mBtnLogin;

	private View progress;

	private View mInputLayout;

	private float mWidth, mHeight;

	private LinearLayout mName, mPsw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_main);

		initView();
	}

	private void initView() {
		mBtnLogin = (Button) findViewById(R.id.main_btn_login);
		progress = findViewById(R.id.layout_progress);
		mInputLayout = findViewById(R.id.input_layout);
		mName = (LinearLayout) findViewById(R.id.input_layout_name);
		mPsw = (LinearLayout) findViewById(R.id.input_layout_psw);

		mBtnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		mWidth = mBtnLogin.getMeasuredWidth();
		mHeight = mBtnLogin.getMeasuredHeight();

		mName.setVisibility(View.INVISIBLE);
		mPsw.setVisibility(View.INVISIBLE);

		inputAnimator(mInputLayout, mWidth, mHeight);

	}

	private void inputAnimator(final View view, float w, float h) {

		AnimatorSet set = new AnimatorSet();

		ValueAnimator animator = ValueAnimator.ofFloat(0, w);
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float value = (Float) animation.getAnimatedValue();
				MarginLayoutParams params = (MarginLayoutParams) view
						.getLayoutParams();
				params.leftMargin = (int) value;
				params.rightMargin = (int) value;
				view.setLayoutParams(params);
			}
		});

		ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout,
				"scaleX", 1f, 0f);
		set.setDuration(500);
		set.setInterpolator(new AccelerateDecelerateInterpolator());
		set.playTogether(animator, animator2);
		set.start();
		set.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {

				progress.setVisibility(View.VISIBLE);
				progressAnimator(progress);
				mInputLayout.setVisibility(View.INVISIBLE);

			}

			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void progressAnimator(final View view) {
		PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX",
				0.5f, 1f);
		PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY",
				0.5f, 1f);
		ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view,
				animator, animator2);
		animator3.setDuration(1000);
		animator3.setInterpolator(new JellyInterpolator());
		animator3.start();
		new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					Thread.sleep(3000);//休眠3秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();


	}
}
