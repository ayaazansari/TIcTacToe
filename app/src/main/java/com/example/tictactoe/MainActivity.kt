package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.tictactoe.R.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    lateinit var board: Array<Array<Button>>
    var boardgame = Array(3){ IntArray(3)}
    var data = 1
    var count=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        board = arrayOf(
            arrayOf(button,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )
        for(i in board)
        {
            for(btn in i)
            {
                btn.setOnClickListener(this)
            }
        }
        btnreset.setOnClickListener {
            data = 1
            count=0
            displaytv.text = "Player X turn"
            reset()
        }

    }

    override fun onClick(view: View?) {
        when(view)
        {
            button->{
                setvalue(0,0,data)
            }
            button2->{
                setvalue(0,1,data)
            }
            button3->{
                setvalue(0,2,data)
            }
            button4->{
                setvalue(1,0,data)
            }
            button5->{
                setvalue(1,1,data)
            }
            button6->{
                setvalue(1,2,data)
            }
            button7->{
                setvalue(2,0,data)
            }
            button8->{
                setvalue(2,1,data)
            }
            button9->{
                setvalue(2,2,data)
            }
        }


        if(data == 1){
            displaytv.text = "Player O turn"
            data= 0}
        else
        {displaytv.text ="Player X turn"
            data = 1}
        if(count==8) {
            displaytv.text = "The game is draw"
            setallfalse()
        }
        count++
        rowcheck()
        columncheck()
        diagonalcheck()

    }

    private fun setallfalse()
    {
        for(i in 0..2) {
            for (j in 0..2) {
                board[i][j].isEnabled=false
            }
        }
    }
    private fun setvalue(i:Int,j:Int,symbol:Int) {
        if(symbol ==1)
        board[i][j].text= "X"
        else
            board[i][j].text = "O"
        board[i][j].isEnabled =false

    }
    private fun reset()
    {
        for(i in 0..2) {
            for (j in 0..2) {
                board[i][j].text = ""
                board[i][j].isEnabled=true
            }
        }
    }
    private fun rowcheck()
    {
        for(i in 0..2)
        {
            if(board[i][0].text.toString() ==board[i][1].text.toString() && board[i][0].text.toString()==board[i][2].text.toString())
            {
                Log.i("rowcheck","run")
                if(board[i][0].text.toString() =="X") {
                    displaytv.text = "Player X won"
                    setallfalse()
                } else if(board[i][0].text.toString() == "O") {
                    displaytv.text = "Player O won"
                    setallfalse()
                }

            }
        }
    }
    private fun columncheck()
    {
        for(i in 0..2)
        {
            if(board[0][i].text.toString()==board[1][i].text.toString() && board[0][i].text.toString()==board[2][i].text.toString())
            {
                if(board[0][i].text.toString()=="X") {
                    displaytv.text = "Player X won"
                    setallfalse()
                }
                else if(board[0][i].text.toString()=="O"){
                    displaytv.text = "Player O won"
                    setallfalse()
                }
            }
        }
    }
    private fun diagonalcheck()
    {
        if(board[0][0].text.toString()==board[1][1].text.toString() && board[0][0].text.toString()==board[2][2].text.toString())
        {
            if(board[0][0].text.toString()=="X") {
                displaytv.text = "Player X won"
                setallfalse()
            }
            else if(board[0][0].text.toString()=="O"){
                displaytv.text = "Player O won"
                setallfalse()
            }
        }
        else if(board[0][2].text.toString()==board[1][1].text.toString() && board[0][2].text.toString()==board[2][0].text.toString())
        {
            if(board[0][2].text.toString()=="X") {
                displaytv.text = "Player X won"
                setallfalse()
            }
            else if(board[0][2].text.toString()=="O") {
                displaytv.text = "Player O won"
                setallfalse()
            }
        }
    }

}