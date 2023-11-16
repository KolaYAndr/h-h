package com.example.lesson_5.custom_view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.example.lesson_5.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.min
import kotlin.properties.Delegates

class BarChartsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) :
    View(context, attrs, defStyle) {
    var textColor by Delegates.notNull<Int>()
    var textAndSubtitleTextSize by Delegates.notNull<Int>()
    var labelTextSize by Delegates.notNull<Int>()
    var barsColor by Delegates.notNull<Int>()
    var text: String? = null
    var subtitleText: String? = null
    var maxValue by Delegates.notNull<Int>()

    private val safeField: RectF = RectF()
    private var dataMap: MutableMap<Date, Int> = mutableMapOf()
    private val simpleDate = SimpleDateFormat("dd.MM", Locale.getDefault())

    private val animatorList: MutableList<ValueAnimator> = mutableListOf()

    private val gestureDetector = GestureDetector(context,
        object : GestureDetector.OnGestureListener {
            override fun onDown(e: MotionEvent): Boolean {
                return false
            }

            override fun onShowPress(e: MotionEvent) {
            }

            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return false
            }

            override fun onScroll(
                e1: MotionEvent?,
                e2: MotionEvent,
                distanceX: Float,
                distanceY: Float
            ): Boolean {
                return false
            }

            override fun onLongPress(e: MotionEvent) {
                startMyAnimation()
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                return false
            }
        })

    init {
        if (attrs == null) initDefaultAttributes()
        else initSetAttributes(attrs, defStyle)
    }

    fun setData(map: Map<Date, Int>) {
        if (map.size in 1..9) dataMap = map.toMutableMap()
    }

    fun startMyAnimation() {
        dataMap.forEach {
            val key = it.key
            val animator = ValueAnimator.ofInt(0, it.value).apply {
                duration = 1000
                addUpdateListener {
                    val value = this.getAnimatedValue().toString().toInt()
                    dataMap[key] = value
                    invalidate()
                }
            }
            animator.start()
            animatorList.add(animator)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when {
            gestureDetector.onTouchEvent(event) -> true
            event.action == MotionEvent.ACTION_UP -> {
                startMyAnimation()
                true
            }

            else -> false
        }
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

        if (heightDifference != 0 && paddingTop == paddingBottom) {
            safeField.top = paddingTop + heightDifference / 2f
            safeField.bottom = h - paddingBottom - heightDifference / 2f
        } else {
            safeField.top = paddingTop.toFloat()
            safeField.bottom = safeField.top + SCALE_HEIGHT * minRatio
        }

        if (widthDifference != 0 && paddingLeft == paddingRight) {
            safeField.left = paddingLeft + widthDifference / 2f
            safeField.right = w - paddingRight - widthDifference / 2f
        } else {
            safeField.left = paddingLeft.toFloat()
            safeField.right = safeField.left + SCALE_WIDTH * minRatio
        }
    }

    override fun onDraw(canvas: Canvas) {
        val offset = drawText(canvas)
        drawBarCharts(canvas, offset)
    }

    private fun drawText(canvas: Canvas): Float {
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
        return startVertical
    }


    val barChartsPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = barsColor
        style = Paint.Style.FILL
        strokeWidth = 8f
    }
    val labelTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = barsColor
        style = Paint.Style.FILL_AND_STROKE
        textSize = labelTextSize.toFloat()
    }

    private fun drawBarCharts(canvas: Canvas, offset: Float) {
        val number = dataMap.size
        val step = safeField.width() / (number + 1)

        var counter = 1

        val dateBound = Rect()
        val percentBound = Rect()
        dataMap.forEach { entry ->
            val dateText = simpleDate.format(entry.key)
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
                safeField.bottom - 2 * EXTENDED_PADDING - dateBound.height() //нижняя точка линии
            val lineMaxEnd =
                safeField.top + 2 * EXTENDED_PADDING + percentBound.height() + offset //конец для линии максимальной длины
            val lineHeight = lineStart - lineMaxEnd //длина максимальной линии
            val lineEnd = lineStart - lineHeight * percentValue //конец заданной линии

            val coordinateX = safeField.left + step * counter

            canvas.drawLine(coordinateX, lineStart, coordinateX, lineEnd, barChartsPaint)
            canvas.drawText(
                dateText,
                coordinateX - dateBound.width() / 2f,
                safeField.bottom - STANDARD_PADDING,
                labelTextPaint
            )

            canvas.drawText(
                percentValueString,
                coordinateX - percentBound.width() / 2f,
                lineEnd - EXTENDED_PADDING,
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
            typedArray.getColor(
                R.styleable.BarChartsView_textColor,
                ContextCompat.getColor(context, TEXT_AND_BARS_DEFAULT_COLOR)
            )
        barsColor =
            typedArray.getColor(
                R.styleable.BarChartsView_barsColor,
                ContextCompat.getColor(context, TEXT_AND_BARS_DEFAULT_COLOR)
            )
        textAndSubtitleTextSize =
            typedArray.getDimensionPixelSize(
                R.styleable.BarChartsView_textSize, resources.getDimensionPixelSize(
                    STANDARD_TEXT_SIZE
                )
            )
        maxValue = typedArray.getInt(
            R.styleable.BarChartsView_maxValue,
            resources.getInteger(STANDARD_MAX_VALUE)
        )
        labelTextSize = typedArray.getDimensionPixelSize(
            R.styleable.BarChartsView_labelTextSize,
            resources.getDimensionPixelSize(STANDARD_LABEL_TEXT_SIZE)
        )
        typedArray.recycle()
    }

    private fun initDefaultAttributes() {
        textColor = ContextCompat.getColor(context, TEXT_AND_BARS_DEFAULT_COLOR)
        barsColor = ContextCompat.getColor(context, TEXT_AND_BARS_DEFAULT_COLOR)
        textAndSubtitleTextSize = resources.getDimensionPixelSize(STANDARD_TEXT_SIZE)
        maxValue = resources.getInteger(STANDARD_MAX_VALUE)
        labelTextSize = resources.getDimensionPixelSize(STANDARD_LABEL_TEXT_SIZE)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animatorList.forEach { it.cancel() }
    }

    companion object {
        val TEXT_AND_BARS_DEFAULT_COLOR = R.color.text_and_bars_default_color
        val STANDARD_TEXT_SIZE = R.dimen.standard_text_size
        val STANDARD_LABEL_TEXT_SIZE = R.dimen.standard_label_text_size
        const val STANDARD_PADDING = 10
        const val EXTENDED_PADDING = 20
        val STANDARD_MAX_VALUE = R.integer.standard_max_value
        const val SCALE_WIDTH = 36
        const val SCALE_HEIGHT = 23
    }
}