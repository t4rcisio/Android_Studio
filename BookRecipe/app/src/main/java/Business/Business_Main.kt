package Business

import Repository.Recipe
import Repository.Repository_recipes
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.example.bookrecipe.R
import kotlinx.android.synthetic.main.activity_recipe.view.*
import kotlinx.android.synthetic.main.main_layout_post.view.*

class Business_Main (var context: Context){


    private var mRepository_recipes = Repository_recipes(context)
    private var recipes =  mRepository_recipes.getRecipes()



    fun getRecipeByName(recipeTitle: String): Recipe?{
        for(recipe in recipes){
            if(recipe.title.equals(recipeTitle)){
                return recipe
            }
        }
        return null
    }

    fun loadRecipes(linearLayout: LinearLayout, recipeWidgetList: MutableList<View>){



        for(elementRecipe in recipes){

            var recipeWidget = View.inflate(context, R.layout.main_layout_post,null)
            recipeWidget.Main_authorTitle.text = elementRecipe.author
            recipeWidget.Main_recipeTitle.text = elementRecipe.title
            recipeWidget.Main_imageRecipe.background  = elementRecipe.image

            recipeWidget.id = View.generateViewId()
            recipeWidgetList.add(recipeWidget)
            linearLayout.addView(recipeWidget)
        }






    }



}