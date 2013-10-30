package com.kelviomatias.roms;

import java.util.Calendar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import com.kelviomatias.roms.util.DownloadUtil;
import com.kelviomatias.romscore.AbstractRomsActivity;

public class RomsActivity extends AbstractRomsActivity {
	
	
	@Override
	protected void onResume() {
		super.onResume();		
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				if (Calendar.SATURDAY == Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
					return;
				}
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						RomsActivity.this);

				// set title
				alertDialogBuilder.setTitle("Warning");

				
				
				// set dialog message
				alertDialogBuilder
						.setMessage(
								"This is the demo version of app. You can download more " + new DownloadUtil(RomsActivity.this).getNumRemainDownloads() + " games. Do you want to download the premium version for make unlimited downloads?")
						.setCancelable(false)
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.cancel();

										try {
											startActivity(new Intent(
													Intent.ACTION_VIEW,
													Uri.parse("market://details?id=com.kelviomatias.romspremium")));
										} catch (android.content.ActivityNotFoundException anfe) {
											startActivity(new Intent(
													Intent.ACTION_VIEW,
													Uri.parse("http://play.google.com/store/apps/details?id=com.kelviomatias.romspremium")));
										}

									}
								})
						.setNegativeButton("No, thanks",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.cancel();
									}
								});

				// create alert dialog
				alertDialogBuilder.create().show();
			}
		});
	}

	@Override
	public Class<? extends Activity> getRomActivityClass() {
		return RomActivity.class;
	}

	
	
}

