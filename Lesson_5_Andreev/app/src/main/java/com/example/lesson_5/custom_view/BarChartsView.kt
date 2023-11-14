package com.example.lesson_5.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import com.example.lesson_5.R
import java.util.Date
import kotlin.math.min
import kotlin.properties.Delegates

class BarChartsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) :
    View(context, attrs, defStyle) {
    private var textColor by Delegates.notNull<Int>()
    private var textAndSubtitleTextSize by Delegates.notNull<Int>()
    private var labelTextSize by Delegates.notNull<Int>()
    private var barsColor by Delegates.notNull<Int>()
    private var text: String? = null
    private var subtitleText: String? = null

    private var maxValue by Delegates.notNull<Int>()
    private val safeField: RectF = RectF()
    private var dataMap: Map<Date, Int> = mutableMapOf()

    init {
        if (attrs == null) initDefaultAttributes()
        else initSetAttributes(attrs, defStyle)
    }

    fun setData(map: Map<Date, Int>) {
        if (map.size in 1..9) dataMap = map
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        val widthFromMeasure = MeasureSpec.getSize(widthMeasureSpec)
        val heightFromMeasure = MeasureSpec.getSize(heightMeasureSpec)

        var resolvedWidth = 0
        var resolvedHeight = 0

        when (widthMode) {
            MeasureSpec.EXACTLY -> {
                when (heightMode) {
                    MeasureSpec.EXACTLY -> {
                        resolvedWidth = widthFromMeasure
                        resolvedHeight = heightFromMeasure
                    }

                    MeasureSpec.AT_MOST, MeasureSpec.UNSPECIFIED -> {
                        val widthsRatio = widthFromMeasure / SCALE_WIDTH
                        val heightsRatio = heightFromMeasure / SCALE_HEIGHT

                        val minOfRatios = min(widthsRatio, heightsRatio)

                        resolvedWidth = SCALE_WIDTH * minOfRatios
                        resolvedHeight = SCALE_HEIGHT * minOfRatios
                    }
                }
            }

            MeasureSpec.UNSPECIFIED -> {
                when (heightMode) {
                    MeasureSpec.EXACTLY -> {
                        resolvedHeight = heightFromMeasure
                        val ratio = heightFromMeasure / SCALE_HEIGHT
                        resolvedWidth = SCALE_WIDTH * ratio
                    }

                    MeasureSpec.AT_MOST, MeasureSpec.UNSPECIFIED -> {
                        val widthsRatio = widthFromMeasure / SCALE_WIDTH
                        val heightsRatio = heightFromMeasure / SCALE_HEIGHT

                        val minOfRatios = min(widthsRatio, heightsRatio)

                        resolvedWidth = SCALE_WIDTH * minOfRatios
                        resolvedHeight = SCALE_HEIGHT * minOfRatios
                    }
                }
            }

            MeasureSpec.AT_MOST -> {
                when (heightMode) {
                    MeasureSpec.EXACTLY -> {
                        resolvedHeight = heightFromMeasure
                        val ratio = heightFromMeasure / SCALE_HEIGHT
                        resolvedWidth = SCALE_WIDTH * ratio
                    }

                    MeasureSpec.AT_MOST, MeasureSpec.UNSPECIFIED -> {
                        val widthsRatio = widthFromMeasure / SCALE_WIDTH
                        val heightsRatio = heightFromMeasure / SCALE_HEIGHT

                        val minOfRatios = min(widthsRatio, heightsRatio)

                        resolvedWidth = SCALE_WIDTH * minOfRatios
                        resolvedHeight = SCALE_HEIGHT * minOfRatios
                    }
                }
            }
        }

        setMeasuredDimension(resolvedWidth, resolvedHeight)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        val safeWidth = w - paddingLeft - paddingRight
        val safeHeight = h - paddingTop - paddingBottom
        val minRatio = min(safeWidth / SCALE_WIDTH, safeHeight / SCALE_HEIGHT)

        val heightDifference = h - SCALE_HEIGHT * minRatio
        val widthDifference = w - SCALE_WIDTH * minRatio

        if (heightDifference != 0 && paddingTop == paddingBottom){
            safeField.top = paddingTop + heightDifference / 2f
            safeField.bottom = h - paddingBottom - heightDifference / 2f
        }
        else {
            safeField.top = paddingTop.toFloat()
            safeField.bottom = safeField.top + SCALE_HEIGHT * minRatio
        }

        if (widthDifference != 0 && paddingLeft == paddingRight){
            safeField.left = paddingLeft + widthDifference / 2f
            safeField.right = w - paddingRight - widthDifference / 2f
        }
        else {
            safeField.left = paddingLeft.toFloat()
            safeField.right = safeField.left + SCALE_WIDTH * minRatio
        }
    }

    override fun onDraw(canvas: Canvas) {
        //drawText(canvas)
        canvas.drawRect(safeField, Paint().apply { color = Color.RED })
        drawBarCharts(canvas)
    }

    private fun drawText(canvas: Canvas) {
        var startVertical = safeField.top + STANDARD_PADDING
        val startHorizontal = safeField.left + STANDARD_PADDING

        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.apply {
            color = textColor
            style = Paint.Style.FILL
            textSize = textAndSubtitleTextSize.toFloat()
            typeface = Typeface.DEFAULT_BOLD
        }

        text?.let {
            val textBounds = Rect()
            textPaint.getTextBounds(it, 0, it.length, textBounds)
            startVertical += textBounds.height()
            canvas.drawText(it.uppercase(), startHorizontal, startVertical, textPaint)
        }

        textPaint.typeface = Typeface.DEFAULT
        subtitleText?.let {
            val textBounds = Rect()
            textPaint.getTextBounds(it, 0, it.length, textBounds)
            startVertical += textBounds.height() + STANDARD_PADDING
            canvas.drawText(it, startHorizontal, startVertical, textPaint)
        }
    }

    private fun drawBarCharts(canvas: Canvas) {
        val barChartsPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        barChartsPaint.apply {
            color = barsColor
            style = Paint.Style.FILL
            strokeWidth = 8f
        }
        val labelTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        labelTextPaint.apply {
            color = barsColor
            style = Paint.Style.FILL_AND_STROKE
            textSize = labelTextSize.toFloat()
        }

        val number = dataMap.size
        val step = safeField.width() / (number + 1)

        var counter = 1

        val dateBound = Rect()
        val percentBound = Rect()
        dataMap.forEach { entry ->
            val dateText = entry.key.date.toString() + "." + (entry.key.month + 1)
            val percentValue = entry.value / maxValue.toFloat()
            labelTextPaint.getTextBounds(dateText, 0, dateText.length, dateBound)
            val percentValueString = (percentValue * maxValue).toInt().toString()
            labelTextPaint.getTextBounds(
                percentValueString,
                0,
                percentValueString.length,
                percentBound
            )

            val lineStart =
                safeField.bottom - 2 * STANDARD_PADDING - dateBound.height() //нижняя точка столбца
            val lineMaxEnd =
                safeField.top + 2 * STANDARD_PADDING + percentBound.height() //конец для линии максимальной длины
            val lineHeight = lineStart - lineMaxEnd //длина максимальной линии
            val lineEnd = lineStart - lineHeight * percentValue //конец заданной линии

            val coordinateX = safeField.left + step * counter

            canvas.drawLine(coordinateX, lineStart, coordinateX, lineEnd, barChartsPaint)
            canvas.drawText(
                dateText,
                coordinateX - dateBound.width() / 2,
                safeField.bottom - STANDARD_PADDING,
                labelTextPaint
            )

            canvas.drawText(
                percentValueString,
                coordinateX - percentBound.width() / 2,
                lineEnd - 2 * STANDARD_PADDING,
                labelTextPaint
            )
            counter++
        }

    }

    private fun initSetAttributes(attrs: AttributeSet, defStyle: Int) {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.BarChartsView, defStyle, 0)
        text = typedArray.getString(R.styleable.BarChartsView_text)
        subtitleText = typedArray.getString(R.styleable.BarChartsView_subtitleText)
        textColor =
            typedArray.getColor(R.styleable.BarChartsView_textColor, TEXT_AND_BARS_DEFAULT_COLOR)
        barsColor =
            typedArray.getColor(R.styleable.BarChartsView_barsColor, TEXT_AND_BARS_DEFAULT_COLOR)
        textAndSubtitleTextSize =
            typedArray.getDimensionPixelSize(R.styleable.BarChartsView_textSize, 16)
        maxValue = typedArray.getInt(R.styleable.BarChartsView_maxValue, STANDARD_MAX_VALUE)
        labelTextSize = typedArray.getDimensionPixelSize(
            R.styleable.BarChartsView_labelTextSize,
            STANDARD_LABEL_TEXT_SIZE
        )
        typedArray.recycle()
    }

    private fun initDefaultAttributes() {
        textColor = TEXT_AND_BARS_DEFAULT_COLOR
        barsColor = TEXT_AND_BARS_DEFAULT_COLOR
        textAndSubtitleTextSize = STANDARD_TEXT_SIZE
        maxValue = STANDARD_MAX_VALUE
        labelTextSize = STANDARD_LABEL_TEXT_SIZE
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }

    companion object {
        val TEXT_AND_BARS_DEFAULT_COLOR = Color.rgb(252, 215, 95)
        const val STANDARD_TEXT_SIZE = 42
        const val STANDARD_LABEL_TEXT_SIZE = 28
        const val STANDARD_PADDING = 5
        const val STANDARD_MAX_VALUE = 100
        const val SCALE_WIDTH = 36
        const val SCALE_HEIGHT = 23
    }
}