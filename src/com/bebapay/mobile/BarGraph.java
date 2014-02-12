package com.bebapay.mobile;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class BarGraph {
	public Intent getIntent(Context context) {
		int y[] = { 25, 10, 15, 20 , 40, 35, 70, 45, 10, 20 ,35, 20};
		CategorySeries series = new CategorySeries("Fare spent");
		for (int i = 0; i < y.length; i++) {
			series.add("Day " + (i + 1), y[i]);
		}
		XYMultipleSeriesDataset dataSet = new XYMultipleSeriesDataset();
		dataSet.addSeries(series.toXYSeries());
		
		// customization of the chart
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		renderer.setColor(Color.RED);
		renderer.setDisplayChartValues(true);
		renderer.setChartValuesSpacing((float) 5.5d);
		renderer.setLineWidth((float) 10.5d);
		
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		
		mRenderer.addSeriesRenderer(renderer);
		mRenderer.setChartTitle("Your Expenditure");
		mRenderer.setXTitle("Time in days");
		mRenderer.setYTitle("Kshs");
		mRenderer.setZoomButtonsVisible(true);
		mRenderer.setShowLegend(true);
		mRenderer.setShowGridX(true);
		mRenderer.setShowGridY(true);
		mRenderer.setAntialiasing(true);
		mRenderer.setBarSpacing(.5);
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setBackgroundColor(Color.BLACK);
		mRenderer.setXAxisMin(0);
		mRenderer.setXAxisMax(5);
		mRenderer.setYAxisMax(50);
		mRenderer.setXLabels(5);

		mRenderer.setPanEnabled(true, true);
		Intent intent = ChartFactory.getBarChartIntent(context, dataSet,
				mRenderer, Type.DEFAULT);
		return intent;
	}
}