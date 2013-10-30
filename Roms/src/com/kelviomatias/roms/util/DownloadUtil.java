package com.kelviomatias.roms.util;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

import android.content.Context;

public class DownloadUtil {

	public static final int MAX_DOWNLOADS_DAY = 5;
	
	private Context context;
	
	private int numDownloadsDia = 0;
	
	private String fileName;
	
	public DownloadUtil(Context context) {
		super();
		this.context = context;
				
				

		fileName = "downloads.dat";
		
		try {
			Scanner sc = new Scanner(this.context.openFileInput(fileName));
			this.numDownloadsDia = sc.nextInt();
		} catch (Exception e) {
			this.numDownloadsDia = 0;
		}
	}
	
	public void incrementNumDownloadsDay() {
		try {
			PrintWriter writer = new PrintWriter(this.context.openFileOutput(fileName,
					Context.MODE_PRIVATE));
			writer.print("");
			writer.close();
			writer = new PrintWriter(this.context.openFileOutput(fileName,
					Context.MODE_PRIVATE));
			writer.print(numDownloadsDia + 1);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int getNumRemainDownloads() {
		int r =  MAX_DOWNLOADS_DAY - numDownloadsDia;
		if (r < 0) {
			return 0;
		}
		return r;
	}
	
	public boolean canDownloadMoreRoms() {
		return numDownloadsDia < MAX_DOWNLOADS_DAY;
	}
	
}
