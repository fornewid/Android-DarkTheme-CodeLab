package soup.codelab.darktheme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import soup.codelab.darktheme.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeActivityBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)

            setSupportActionBar(toolbar)

            soupCard.run {
                card.setOnClickListener {
                    navigateToGithub()
                }
                favoriteButton.setOnClickListener {
                    val wasSelected = it.isSelected
                    if (wasSelected) {

                    } else {

                    }
                    it.isSelected = wasSelected.not()
                }
            }
            moopCard.run {
                card.setOnClickListener {
                    navigateToMoop()
                }
                favoriteButton.setMaxFrame(30)
                favoriteButton.setOnClickListener {
                    val wasSelected = it.isSelected
                    if (wasSelected) {
                        favoriteButton.speed = -1f
                        favoriteButton.playAnimation()
                    } else {
                        favoriteButton.speed = 1f
                        favoriteButton.playAnimation()
                    }
                    it.isSelected = wasSelected.not()
                }
            }

            fun View.setSelectedIfDarkTheme() {
                isSelected = DarkTheme.isEnabled(context)
            }
            dayNightToggleButton.setSelectedIfDarkTheme()
            dayNightToggleButton.setOnClickListener {
                DarkTheme.apply(enabled = it.isSelected.not())
                it.setSelectedIfDarkTheme()
            }

            bottomSheetPanel.run {
                filterGroup.setOnCheckedChangeListener { group, _ ->
                    Toast.makeText(group.context, "Filter Changed!", Toast.LENGTH_SHORT).show()
                }
                bottomSheetBehavior = BottomSheetBehavior.from(root)
                bottomSheetBehavior.state = STATE_HIDDEN
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_filter ->
                bottomSheetBehavior.state = STATE_COLLAPSED
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (bottomSheetBehavior.state != STATE_HIDDEN) {
            bottomSheetBehavior.state = STATE_HIDDEN
            return
        }
        super.onBackPressed()
    }

    private fun navigateToGithub() {
        startActivity(Intent(this, GithubActivity::class.java))
    }

    private fun navigateToMoop() {
        startActivity(Intent(this, MoopActivity::class.java))
    }
}
