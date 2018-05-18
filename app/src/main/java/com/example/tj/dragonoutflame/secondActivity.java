package com.example.tj.dragonoutflame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.tj.dragonoutflame.MainActivity.elem1;
import static com.example.tj.dragonoutflame.MainActivity.elem10;
import static com.example.tj.dragonoutflame.MainActivity.elem11;
import static com.example.tj.dragonoutflame.MainActivity.elem12;
import static com.example.tj.dragonoutflame.MainActivity.elem2;
import static com.example.tj.dragonoutflame.MainActivity.elem3;
import static com.example.tj.dragonoutflame.MainActivity.elem4;
import static com.example.tj.dragonoutflame.MainActivity.elem5;
import static com.example.tj.dragonoutflame.MainActivity.elem6;
import static com.example.tj.dragonoutflame.MainActivity.elem7;
import static com.example.tj.dragonoutflame.MainActivity.elem8;
import static com.example.tj.dragonoutflame.MainActivity.elem9;

public class secondActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series, series1, series2, series3, series4, series5;
    private LineGraphSeries<DataPoint> series6, series7, series8;
    private final Handler mHandler = new Handler();
    private Runnable mTimer, mTimer1, mTimer2, mTimer3, mTimer4, mTimer5, mTimer6;
    private double graphLastXValue = 5d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        GraphView graph2 = (GraphView) findViewById(R.id.graph2);
        GraphView graph3 = (GraphView) findViewById(R.id.graph3);
        GraphView graph4 = (GraphView) findViewById(R.id.graph4);
        GraphView graph5 = (GraphView) findViewById(R.id.graph5);
        GraphView graph6 = (GraphView) findViewById(R.id.graph6);

        initGraph(graph);
        initGraph2(graph2);
        initGraph3(graph3);
        initGraph4(graph4);
        initGraph5(graph5);
        initGraph6(graph6);
    }

    public void initGraph(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
        graph.getGridLabelRenderer().setLabelVerticalWidth(100);
        // first mSeries is a line
        series = new LineGraphSeries<>();
        series.setDrawDataPoints(true);
        series.setDrawBackground(true);
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.addSeries(series);
    }
    public void initGraph2(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
        graph.getGridLabelRenderer().setLabelVerticalWidth(100);
        // first mSeries is a line
        series1 = new LineGraphSeries<>();
        series1.setDrawDataPoints(true);
        series1.setDrawBackground(true);
        series6 = new LineGraphSeries<>();
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.addSeries(series1);
        graph.addSeries(series6);
    }
    public void initGraph3(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
        graph.getGridLabelRenderer().setLabelVerticalWidth(100);
        // first mSeries is a line
        series2 = new LineGraphSeries<>();
        series2.setDrawDataPoints(true);
        series2.setDrawBackground(true);
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.addSeries(series2);
    }
    public void initGraph4(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
        graph.getGridLabelRenderer().setLabelVerticalWidth(100);
        // first mSeries is a line
        series3 = new LineGraphSeries<>();
        series3.setDrawDataPoints(true);
        series3.setDrawBackground(true);
        series7 = new LineGraphSeries<>();
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.addSeries(series3);
        graph.addSeries(series7);
    }
    public void initGraph5(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
        graph.getGridLabelRenderer().setLabelVerticalWidth(100);
        // first mSeries is a line
        series4 = new LineGraphSeries<>();
        series4.setDrawDataPoints(true);
        series4.setDrawBackground(true);
        series8 = new LineGraphSeries<>();
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.addSeries(series4);
        graph.addSeries(series8);
    }
    public void initGraph6(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
        graph.getGridLabelRenderer().setLabelVerticalWidth(100);
        // first mSeries is a line
        series5 = new LineGraphSeries<>();
        series5.setDrawDataPoints(true);
        series5.setDrawBackground(true);
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.addSeries(series5);
    }

    public void onResume() {
        super.onResume();
        mTimer = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                series.appendData(new DataPoint(graphLastXValue, elem11), true, 22);
                mHandler.postDelayed(this, 330);
            }
        };
        mHandler.postDelayed(mTimer, 1500);
        mTimer1 = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                series1.appendData(new DataPoint(graphLastXValue, elem1), true, 22);
                series6.appendData(new DataPoint(graphLastXValue, elem4), true, 22);
                mHandler.postDelayed(this, 330);
            }
        };
        mHandler.postDelayed(mTimer1, 1500);
        mTimer2 = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                series2.appendData(new DataPoint(graphLastXValue, elem10), true, 22);
                mHandler.postDelayed(this, 330);
            }
        };
        mHandler.postDelayed(mTimer2, 1500);
        mTimer3 = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                series3.appendData(new DataPoint(graphLastXValue, elem2), true, 22);
                series7.appendData(new DataPoint(graphLastXValue, elem5), true, 22);
                mHandler.postDelayed(this, 330);
            }
        };
        mHandler.postDelayed(mTimer3, 1500);
        mTimer4 = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                series4.appendData(new DataPoint(graphLastXValue, elem3), true, 22);
                series8.appendData(new DataPoint(graphLastXValue, elem6), true, 22);
                mHandler.postDelayed(this, 330);
            }
        };
        mHandler.postDelayed(mTimer4, 1500);
        mTimer5 = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                series5.appendData(new DataPoint(graphLastXValue, elem12), true, 22);
                mHandler.postDelayed(this, 330);
            }
        };
        mHandler.postDelayed(mTimer5, 1500);
       /* mTimer6 = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                series6.appendData(new DataPoint(graphLastXValue, elem10), true, 22);
                mHandler.postDelayed(this, 330);
            }
        };
        mHandler.postDelayed(mTimer6, 1500);*/
    }


    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mTimer);
        mHandler.removeCallbacks(mTimer1);
        mHandler.removeCallbacks(mTimer2);
        mHandler.removeCallbacks(mTimer3);
        mHandler.removeCallbacks(mTimer4);
        mHandler.removeCallbacks(mTimer5);
      //  mHandler.removeCallbacks(mTimer6);
    }

}
