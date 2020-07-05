package gkk.lib.android.barchart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testHorizontalBarChartView()
    }


    private fun testHorizontalBarChartView() {
        chartHorizontalBarNormal.apply {
            this.setLabel("Normal (max: 100, value: 50)")
            this.setLabelAppearance(R.style.text_horizontal_bar_chart)
            this.setTrackBarBackground(R.drawable.bg_horizontal_bar_chart_track)
            this.setValueBarBackground(R.drawable.bg_horizontal_bar_chart_value)
            this.setMaxValue(100f)
            this.setMinValue(0f)
            this.drawChart(50f, 1000)
        }


        chartHorizontalBarOver.apply {
            this.setLabel("Over (max: 100, over: 70, value: 75)")
            this.setLabelAppearance(R.style.text_horizontal_bar_chart)
            this.setTrackBarBackground(R.drawable.bg_horizontal_bar_chart_track)
            this.setValueBarBackground(R.drawable.bg_horizontal_bar_chart_value)
            this.setMaxValue(100f)
            this.setMinValue(0f)
            this.setOverConditionValue(70f)
            this.setOverConditionValueBarBackground(R.drawable.bg_horizontal_bar_chart_value_over)
            this.drawChart(80f, 1000)
        }


        chartHorizontalBarUnder.apply {
            this.setLabel("Under (max: 100, under: 30, value: 20)")
            this.setLabelAppearance(R.style.text_horizontal_bar_chart)
            this.setTrackBarBackground(R.drawable.bg_horizontal_bar_chart_track)
            this.setValueBarBackground(R.drawable.bg_horizontal_bar_chart_value)
            this.setMaxValue(100f)
            this.setMinValue(0f)
            this.setUnderConditionValue(30f)
            this.setUnderConditionTrackBarBackground(R.drawable.bg_horizontal_bar_chart_track_under)
            this.setUnderConditionValueBarBackground(R.drawable.bg_horizontal_bar_chart_value_under)
            this.drawChart(20f, 1000)
        }

    }

}
