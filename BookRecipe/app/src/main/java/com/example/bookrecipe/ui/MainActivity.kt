package com.example.bookrecipe.ui

import Business.Business_Main
import Repository.Recipe
import Repository.Repository_recipes
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import com.example.bookrecipe.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout_post.*
import kotlinx.android.synthetic.main.main_layout_post.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView


class MainActivity : AppCompatActivity(){

    private lateinit var mRepository_recipes: Repository_recipes
    private lateinit var mBusiness_Main: Business_Main
    private var recipeWidgetList: MutableList<View> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar != null)
            supportActionBar!!.hide()

        mRepository_recipes = Repository_recipes(this)
        mBusiness_Main = Business_Main(this)


        loadPage()
        listner()

    }

    private fun listner(){
        recipeWidgetList.forEachIndexed { index, widget ->
            widget.setOnClickListener {
                var intent = Intent(this,RecipeActivity::class.java)
                intent.putExtra("Data", index)
                startActivity(intent)
            }
        }

    }



    private fun loadPage(){
        if(!recipeWidgetList.any()){
            mBusiness_Main.loadRecipes(linearPage,recipeWidgetList)
        }
    }


}