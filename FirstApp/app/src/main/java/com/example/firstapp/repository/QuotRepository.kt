package com.example.firstapp.repository

import com.example.firstapp.infra.appConstants


data class Quote(val quote: String, val author: String, val category: String)

class QuotRepository{


    private val all = appConstants.KEY.ALL
    private val morning = appConstants.KEY.MORNING
    private val happy = appConstants.KEY.HAPPY

    private val mQuoteList: List<Quote> = listOf(
        Quote("The best way to predict the future is to create it.","Abraham Lincoln", morning),
        Quote("You are never too old to set another goal or to dream a new dream","C.S.Lewis",morning),
        Quote("Live as if you were to die tomorrow. Learn as if you were to live forever.","Mahatma Gandh",morning),
        Quote( "Learning is not a spectator sport.","D. Blocher",morning),
        Quote("There is no substitute for hard work.", "Thomas Edison",morning),
        Quote("Do the difficult things while they are easy and do the great things while they are small. A journey of a thousand miles begins with a single step.", "Lao Tzu",morning),
        Quote("Today a reader, tomorrow a leader.","Margaret Fuller",morning),
        Quote("Happiness is when what you think, what you say, and what you do are in harmony.","Mahatma Gandhi" ,happy),
        Quote("There is only one happiness in this life, to love and be loved.", "George Sand" ,happy),
        Quote("Be happy for this moment. This moment is your life.","Omar Khayyam" ,happy),
        Quote("Happiness lies in the joy of achievement and the thrill of creative effort.","Franklin D. Roosevelt",happy),
        Quote("Spread love everywhere you go. Let no one ever come to you without leaving happier." ,"Mother Theresa",happy),
        Quote("Resolve to keep happy, and your joy and you shall form an invincible host against difficulties.","Helen Keller",happy),
        Quote("The present moment is filled with joy and happiness. If you are attentive, you will see it.","Thich Nhat Hanh",happy),
    )


    fun getQuote(filter: String): Quote{
        var quote = mQuoteList[(0..(mQuoteList.size-1)).random()]
        if(quote.category == filter || filter == all){
            return quote
        }else{
            return getQuote(filter)
        }
    }




}