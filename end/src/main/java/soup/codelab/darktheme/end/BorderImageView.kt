package soup.codelab.darktheme.end

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.ImageView

class BorderImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ImageView(context, attrs, defStyle) {

    private val strokePaint = Paint()
    private var borderColor: Int = Color.TRANSPARENT
    private var borderWidth: Float = 0f

    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.BorderImageView, defStyle, 0)
            try {
                borderColor = a.getColor(
                    R.styleable.BorderImageView_borderColor,
                    Color.TRANSPARENT
                )
                borderWidth = a.getDimension(
                    R.styleable.BorderImageView_borderWidth,
                    0f
                )
                strokePaint.apply {
                    color = borderColor
                    style = Paint.Style.STROKE
                    strokeWidth = borderWidth
                    isAntiAlias = true
                }
            } finally {
                a.recycle()
            }
        }
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.borderRectangle(borderWidth.div(2).toInt())
    }

    private fun Canvas.borderRectangle(halfW: Int) = clipBounds.run {
        drawRect(
            Rect(halfW, halfW, right - halfW, bottom - halfW),
            strokePaint
        )
    }
}
