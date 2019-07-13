package soup.codelab.darktheme.end

import android.content.res.Configuration
import android.view.View
import androidx.annotation.RawRes
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView

/**
 * https://github.com/airbnb/lottie-android/issues/1305
 */
@BindingAdapter("lottie_rawResDay", "lottie_rawResNight")
fun setAnimationAsync(view: LottieAnimationView, @RawRes dayRawRes: Int, @RawRes nightRawRes: Int) {
    if (view.isDarkTheme()) {
        view.setAnimation(nightRawRes)
    } else {
        view.setAnimation(dayRawRes)
    }
}

private fun View.isDarkTheme(): Boolean {
    return context.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK ==
            Configuration.UI_MODE_NIGHT_YES
}
