package gkk.lib.android.barchart.horizontal

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import gkk.lib.android.barchart.R
import kotlinx.android.synthetic.main.view_horizontal_bar_chart.view.*

class HorizontalBarChartView: ConstraintLayout {

    private var maxValue: Float = 0f
    private var value: Float = 0f
    private var overConditionValue: Float = 0f
    private var underConditionValue: Float = 0f
    private var unit: Float = 0f

    private var trackWidth: Int = 0
    private var valueWidth: Int = 0

    private var trackResId: Int = 0
    private var valueResId: Int = 0
    private var overConditionTrackResId: Int = 0
    private var overConditionValueResId: Int = 0
    private var underConditionTrackResId: Int = 0
    private var underConditionValueResId: Int = 0




    constructor(context: Context): super(context)
    constructor(context: Context, attr: AttributeSet): super(context, attr)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_horizontal_bar_chart, this, true)

    }


    fun setLabel(text: String, textColor: Int = Color.parseColor("#000000")) {
        this.textLabel.text = text
        this.textLabel.setTextColor(textColor)
    }

    fun setLabelAppearance(textAppearance: Int) {
        this.textLabel.setTextAppearance(textAppearance)
    }

    fun setTrackBarBackground(resId: Int) {
        this.trackResId = resId
    }

    fun setValueBarBackground(resId: Int) {
        this.valueResId = resId
    }

    fun setOverConditionTrackBarBackground(resId: Int) {
        this.overConditionTrackResId = resId
    }

    fun setOverConditionValueBarBackground(resId: Int) {
        this.overConditionValueResId = resId
    }

    fun setUnderConditionTrackBarBackground(resId: Int) {
        this.underConditionTrackResId = resId
    }

    fun setUnderConditionValueBarBackground(resId: Int) {
        this.underConditionValueResId = resId
    }

    fun setMaxValue(maxValue: Float) {
        this.maxValue = maxValue
    }

    fun drawChart(value: Float) {
        this.value = value
        this.post {
            trackWidth = this.imgTrackBar.width
            valueWidth = try { ((value * trackWidth) / maxValue).toInt() } catch (error: Exception) { 0 }

            if (valueWidth > 0) {
                imgValueBar.visibility = View.VISIBLE
                imgValueBar.layoutParams = imgValueBar.layoutParams.apply {
                    this.width = if (valueWidth > trackWidth) trackWidth else valueWidth
                }
                
            }
        }
    }






}