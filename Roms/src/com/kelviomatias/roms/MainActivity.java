package com.kelviomatias.roms;

import android.app.Activity;

import com.kelviomatias.romscore.AbstractMainActivity;

public class MainActivity extends AbstractMainActivity {
	
	@Override
	public Class<? extends Activity> getRomsActivityClass() {
		return RomsActivity.class;
	}

	
	
}
