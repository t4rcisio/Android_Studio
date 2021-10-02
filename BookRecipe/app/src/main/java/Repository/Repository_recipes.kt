package Repository

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.view.View
import android.widget.ImageView
import com.example.bookrecipe.R


data class Recipe(var author: String = "",var image: Drawable ,var title: String = "", var time: String = "", var favs: String = "", var sumary: String = "",var instructions: String = "")

class Repository_recipes(context: Context) {

    private var recipeList : List<Recipe> = listOf(

        Recipe("Narseh Evaristus", context.getDrawable(R.drawable.chicken)!!,"Roast Chicken"),
        Recipe("Dương Mayu",context.getDrawable(R.drawable.chocolte)!!,"Chocolate molten cakes"),
        Recipe("Luana Víðarr",context.getDrawable(R.drawable.pizza)!!,"Easiest Pizza"),
        Recipe("Hulda Janina",context.getDrawable(R.drawable.broccolo)!!,"Broccoli pesto penne"),
        Recipe("Lencho Benjamin",context.getDrawable(R.drawable.sandwich)!!,"Cuban Sandwich"),
    )


    fun getRecipes(): List<Recipe>{
        return recipeList
    }

}