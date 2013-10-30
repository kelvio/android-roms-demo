package com.kelviomatias.roms;

import android.app.Activity;
import android.os.Bundle;

import com.kelviomatias.romscore.AbstractSplashScreenActivity;
import com.kelviomatias.romscore.util.ActivityUtil;

public class SplashScreenActivity extends AbstractSplashScreenActivity {


	@Override
	public Class<? extends Activity> getNextActivityClass() {
		return MainActivity.class;
	}

}
