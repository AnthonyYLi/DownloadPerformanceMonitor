package com.ibm.dpm.chart;


import be.ceau.chart.BarChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;

public class BarTest {

	public static void main(String[] args) {
		
		BarChart barChart = new BarChart();
		BarData barData = new BarData();
		//List backgroupColor = new ArrayList();
		
		String countryList = "US,Slovakia,Mexico,Ireland,India,China,Brazil";
		String testcaseList = "1st Akamai IWM,2nd Akamai IWM,DHE IWM";
		
		String[] countries = countryList.split(",");
		String[] testcases = testcaseList.split(",");
		
		for (String c:countries) {
			barData.addLabel(c);
		}
		
		barChart.setData(barData);
		//BarOptions bo = new BarOptions();
		
		BarDataset dataset = new BarDataset()
				.addBackgroundColors(Color.RED)
				.setBorderWidth(1);
		
		for (String tc:testcases) {
			dataset.setLabel(tc);
			dataset.setData(3.77, 1.18, 1.03, 8.72, 0.61, 1.04, 1.14);
			barData.addDataset(dataset);
		}
		/*
		BarDataset dataset1 = new BarDataset()
				.setLabel("1st Akamai IWM")
				.setData(3.77, 1.18, 1.03, 8.72, 0.61, 1.04, 1.14)
				.addBackgroundColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
				.setBorderWidth(1);
		
		BarDataset dataset2 = new BarDataset()
				.setLabel("2nd Akamai IWM")
				.setData(3.77, 1.18, 1.03, 8.72, 0.61, 1.04, 1.14)
				.addBackgroundColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.BLACK)
				.setBorderWidth(1);
		
		
		barData.addDataset(dataset1).addDataset(dataset2);
		*/
		barChart.setData(barData);
		System.out.println(barChart.toJson());
		
	}
}
