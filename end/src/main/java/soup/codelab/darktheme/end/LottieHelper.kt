package soup.codelab.darktheme.end

import androidx.annotation.RawRes
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieCompositionFactory

/**
 * https://github.com/airbnb/lottie-android/issues/1305
 */
fun LottieAnimationView.setAnimationAsync(@RawRes rawRes: Int) {
    LottieCompositionFactory.fromRawRes(context, rawRes)
        .addListener(::setComposition)
}
