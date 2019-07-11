package soup.codelab.darktheme.end

sealed class PashaItemUiModel {

    object Error : PashaItemUiModel()

    class Tag(val message: String) : PashaItemUiModel()

    class Pasha(val message: String, val concat: Boolean = false) : PashaItemUiModel()

    class SOUP(val message: CharSequence, val concat: Boolean = false) : PashaItemUiModel()

    companion object {

        fun createDummyList(): List<PashaItemUiModel> {
            return listOf(
                SOUP("Android Q has a dark theme! 😍"),
                Pasha("Um..‍"),
                SOUP("May the 'Force dark' be with you. 🤣"),
                SOUP("https://material.io/design/color/dark-theme.html", concat = true),
                Pasha("Not so funny."),
                SOUP("Why so serious? 🤔"),
                SOUP("I'm not a monster. I just ahead of the curb. 🃏", concat = true),
                SOUP("And.. Winter is coming!! with 'Dark theme'. 🙈", concat = true),
                SOUP("https://developer.android.com/preview/features/darktheme", concat = true),
                Pasha("I don't have enough time. 😱"),
                Pasha("What should I prepare for it?", concat = true),
                SOUP("Color, color, and colors. 🌈 Ah! Lottie files are also needed."),
                SOUP("Specifically, we need a '-night' resource.", concat = true),
                SOUP("https://developer.android.com/guide/topics/resources/providing-resources#AlternativeResources", concat = true),
                Pasha("Okay, I'll try."),
                SOUP("Do or do not. There is no try. - Yoda"),
                Tag("여기까지 읽었습니다."),
                Pasha("🤯🤯🤯🤯🤯"),
                SOUP("There is also a material color picker."),
                SOUP("https://material.io/design/color/the-color-system.html#tools-for-picking-colors", concat = true),
                Error
            )
        }
    }
}
