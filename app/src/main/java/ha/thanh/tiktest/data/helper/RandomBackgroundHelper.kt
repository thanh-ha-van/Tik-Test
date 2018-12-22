package ha.thanh.tiktest.data.helper

import android.content.Context
import android.graphics.drawable.GradientDrawable
import ha.thanh.tiktest.R
import java.util.*

fun getRandomBackgroundColor(context: Context): GradientDrawable {

    // get random color from 0 to 255 is fine but sometime it create ugly colors.
    // So I'm gonna just comment out this solution
    //    val r = Random()
    //    val red = r.nextInt(255 - 0 + 1) + 0
    //    val green = r.nextInt(255 - 0 + 1) + 0
    //    val blue = r.nextInt(255 - 0 + 1) + 0

    // get random color from a pre-defined color resource.
    val array = context.resources.getIntArray(R.array.keyword_color)
    val randomStr = array[Random().nextInt(array.size)]

    val draw = GradientDrawable()
    draw.shape = GradientDrawable.RECTANGLE
    draw.cornerRadius = 15f
    draw.setColor(randomStr)
    return draw
}