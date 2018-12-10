package com.ibm.dpm.constant;

import be.ceau.chart.color.Color;

public class DownloadOptions {

	public static final String[] COUNTRY = {"US", "Slovakia", "Mexico", "Ireland", "India", "China", "Brazil"};
	public static final String[] TYPE_IWM = {"1st Akamai IWM", "2nd Akamai IWM", "DHE IWM"};
	public static final String[] TYPE_DSW = {"1st Akamai DSW", "2nd Akamai DSW", "DHE dsw-mul", "DHE dsw-bld"};
	
	public static final Color COLOR_RED = new Color(255, 99, 132, 1);
	public static final Color COLOR_BLUE = new Color(54, 162, 235, 1);
	public static final Color COLOR_YELLOW = new Color(255, 206, 86, 1);
	public static final Color COLOR_GREY = new Color(135, 206, 235, 1);
	public static final double TRANSPARENCY = 0.2;
	public static final Color[] BORDER_COLOR = {COLOR_RED, COLOR_BLUE, COLOR_YELLOW, COLOR_GREY};
	public static final Color[] BACKGROUND_COLOR = {
			new Color(COLOR_RED, TRANSPARENCY), 
			new Color(COLOR_BLUE, TRANSPARENCY), 
			new Color(COLOR_YELLOW, TRANSPARENCY), 
			new Color(COLOR_GREY, TRANSPARENCY)};
	
	public static final int BORDER_WIDTH = 1;
	
}
