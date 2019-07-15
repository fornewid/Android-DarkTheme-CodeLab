package soup.codelab.darktheme.end

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.shape.MaterialShapeDrawable

@BindingAdapter("useMaterialBackground")
fun setMaterialBackground(view: View, enabled: Boolean) {
    view.background = if (enabled) {
        MaterialShapeDrawable.createWithElevationOverlay(view.context, view.elevation)
    } else {
        MaterialShapeDrawable.createWithElevationOverlay(view.context)
    }
}
