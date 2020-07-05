package gkk.lib.android.barchart.horizontal

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import androidx.constraintlayout.widget.ConstraintLayout
import gkk.lib.android.barchart.R
import kotlinx.android.synthetic.main.view_horizontal_bar_chart.view.*

class HorizontalBarChartView: ConstraintLayout {
    private val TAG = HorizontalBarChartView::class.java.simpleName

    private var maxValue: Float = 0f
    private var minValue: Float = 0f
    private var value: Float = 0f
    private var overConditionValue: Float = 0f
    private var underConditionValue: Float = 0f

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

    fun setMinValue(minValue: Float) {
        this.minValue = minValue
        this.underConditionValue = minValue
    }

    fun setMaxValue(maxValue: Float) {
        this.maxValue = maxValue
        this.overConditionValue = maxValue
    }

    fun setOverConditionValue(overValue: Float) {
        this.overConditionValue = overValue
    }

    fun setUnderConditionValue(underValue: Float) {
        this.underConditionValue = underValue
    }


    fun drawChart(value: Float, animationDuration: Long = 0) {
        this.value = if (value < minValue) minValue else value
        this.post {
            trackWidth = this.layoutTrackBar.width
            valueWidth = try { ((value * trackWidth) / maxValue).toInt() } catch (error: Exception) { 0 }

            if (valueWidth > 0) {
                if (value > overConditionValue) {
                    layoutTrackBar.setBackgroundResource(overConditionTrackResId)
                    imgValueBar.setBackgroundResource(overConditionValueResId)

                } else if (value < underConditionValue) {
                    layoutTrackBar.setBackgroundResource(underConditionTrackResId)
                    imgValueBar.setBackgroundResource(underConditionValueResId)

                } else {
                    layoutTrackBar.setBackgroundResource(trackResId)
                    imgValueBar.setBackgroundResource(valueResId)

                }
                layoutTrackBar.clipToOutline = true
                imgValueBar.layoutParams = imgValueBar.layoutParams.apply {
                    this.width = if (valueWidth > trackWidth) trackWidth else valueWidth
                }
                if (animationDuration > 0) {
                    startValueAnimation(animationDuration)
                } else {
                    imgValueBar.visibility = View.VISIBLE
                }
            }
        }
    }


    private fun startValueAnimation(duration: Long) {
        val anim = TranslateAnimation(-valueWidth.toFloat(), 0f, 0f, 0f)    // val anim = ScaleAnimation(0f, 1f, 1f, 1f)
        anim.repeatMode = Animation.RESTART
        anim.repeatCount = 0
        anim.duration = duration
        anim.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                imgValueBar.visibility = View.VISIBLE
            }
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {}
        })
        imgValueBar.startAnimation(anim)
    }


}