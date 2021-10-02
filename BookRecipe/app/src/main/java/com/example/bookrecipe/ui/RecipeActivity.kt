package com.example.bookrecipe.ui

import Business.Busness_Recipe
import Repository.Recipe
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bookrecipe.R
import kotlinx.android.synthetic.main.activity_recipe.*

class RecipeActivity : AppCompatActivity() {
    private lateinit var mRecipeData : Recipe
    private var index = -1
    private lateinit var mBusness_Recipe: Busness_Recipe


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        if(supportActionBar != null)
            supportActionBar!!.hide()

        mBusness_Recipe = Busness_Recipe(this)
        getRecipeData()

    }

    private fun getRecipeData(){
        if(index < 0){
            var bundle = getIntent().extras
            if (bundle != null) {
                index = bundle.getInt("Data")
                mRecipeData = mBusness_Recipe.getRecipeData(index)
                loadPage()
            }
        }
    }

    private fun loadPage(){
        Recipe_RecipeTitle.text = mRecipeData.title
        Recipe_author.text = mRecipeData.author
    }


}