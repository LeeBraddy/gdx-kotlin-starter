package lee.game

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxApplicationAdapter
import ktx.log.*

object BadLogic {
    var disposed = false
    val batch = SpriteBatch()
    val img = Texture("badlogic.jpg")

    fun render() {
        if (disposed) {
            val msg = "BadLogic object cannot be rendered because it is already disposed"
            error {msg}
            throw IllegalStateException(msg)
        }
        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()
    }
    fun dispose() {
        info {"Disposing BadLogic object"}
        disposed = true;
        batch.dispose()
        img.dispose()
    }
}

class GdxKotlinStarterGame : KtxApplicationAdapter {
    override fun create() {
        // Do nothing.
        info {"Create method"}
    }

    override fun render() {
        BadLogic.render()
    }

    override fun dispose() {
        BadLogic.dispose()
    }
}
