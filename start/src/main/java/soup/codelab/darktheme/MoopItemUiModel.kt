package soup.codelab.darktheme

sealed class MoopItemUiModel {

    object Error : MoopItemUiModel()

    class Tag(val message: String) : MoopItemUiModel()

    class Moop(val message: String, val concat: Boolean = false) : MoopItemUiModel()

    class SOUP(val message: CharSequence, val concat: Boolean = false) : MoopItemUiModel()

    companion object {

        fun createDummyList(): List<MoopItemUiModel> {
            return listOf(
                SOUP("Android Q has a dark theme! 😍"),
                Moop("Um..‍"),
                SOUP("May the 'Force dark' be with you. 🤣"),
                SOUP("https://material.io/design/color/dark-theme.html", concat = true),
                Moop("Not so funny."),
                SOUP("Why so serious? 🤔"),
                SOUP("I'm not a monster. I just ahead of the curb. 🃏", concat = true),
                SOUP("And.. Winter is coming!! with 'Dark theme'. 🙈", concat = true),
                SOUP("https://developer.android.com/preview/features/darktheme", concat = true),
                Moop("I don't have enough time. 😱"),
                Moop("What should I prepare for it?", concat = true),
                SOUP("Color, color, and colors. 🌈 Ah! Lottie files are also needed."),
                SOUP("Specifically, we need a '-night' resource.", concat = true),
                SOUP("https://developer.android.com/guide/topics/resources/providing-resources#AlternativeResources", concat = true),
                Moop("Okay, I'll try."),
                SOUP("Do or do not. There is no try. - Yoda"),
                Tag("여기까지 읽었습니다."),
                Moop("🤯🤯🤯🤯🤯"),
                SOUP("There is also a material color picker."),
                SOUP("https://material.io/design/color/the-color-system.html#tools-for-picking-colors", concat = true),
                Error
            )
        }
    }
}
