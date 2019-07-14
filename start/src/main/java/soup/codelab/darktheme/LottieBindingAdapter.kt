package soup.codelab.darktheme

import androidx.annotation.RawRes
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView

/**
 * https://github.com/airbnb/lottie-android/issues/1305
 */
@BindingAdapter("lottie_rawResDay", "lottie_rawResNight")
fun setAnimationAsync(view: LottieAnimationView, @RawRes dayRawRes: Int, @RawRes nightRawRes: Int) {
    if (DarkTheme.isEnabled(view.context)) {
        view.setAnimation(nightRawRes)
    } else {
        view.setAnimation(dayRawRes)
    }
}
