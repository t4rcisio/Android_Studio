package Business

import Repository.Recipe
import Repository.Repository_recipes
import android.content.Context

class Busness_Recipe(context: Context) {

    private var mRepository_recipes = Repository_recipes(context)
    private var recipes =  mRepository_recipes.getRecipes()


    fun getRecipeData(index: Int): Recipe{
        return if(index >=0 && index < recipes.size)
             recipes[index]
        else{
            recipes[0]
        }

    }

}