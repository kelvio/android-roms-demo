package com.kelviomatias.roms;

import java.util.Calendar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import com.kelviomatias.roms.util.DownloadUtil;
import com.kelviomatias.romscore.AbstractRomActivity;

public class RomActivity extends AbstractRomActivity {


	
	@Override
	public boolean validateBeforeDownload() {


		DownloadUtil du = new DownloadUtil(this);
		if (!du.canDownloadMoreRoms()) {
			
			if (Calendar.SATURDAY == Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
				return true;
			}
			
			showDownloadExcededDialog();
			return false;
		}
	
		du.incrementNumDownloadsDay();

		return true;
	}

	private void showDownloadExcededDialog() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				
				
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						RomActivity.this);
				
				
				// set title
				alertDialogBuilder.setTitle("Warning");

				// set dialog message
				alertDialogBuilder
						.setMessage(
								"You have reached the limit of " + DownloadUtil.MAX_DOWNLOADS_DAY + " downloads of demo version. Do you want to download the premium version for make unlimited downloads?")
						.setCancelable(false)
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(
											DialogInterface dialog, int id) {
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
									public void onClick(
											DialogInterface dialog, int id) {
										dialog.cancel();
									}
								});

				// create alert dialog
				alertDialogBuilder.create().show();
			}
		});
	}
	
}
