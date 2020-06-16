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
        chartHorizontalBar.apply {
            this.setLabel("Horizontal Bar Chart")
            this.setLabelAppearance(R.style.text_horizontal_bar_chart)
            this.setTrackBarBackground(R.drawable.bg_horizontal_bar_chart_track)
            this.setValueBarBackground(R.drawable.bg_horizontal_bar_chart_value)
            this.setMaxValue(100f)
            this.setMinValue(0f)
            this.drawChart(50f, 1000)
        }

    }

}
