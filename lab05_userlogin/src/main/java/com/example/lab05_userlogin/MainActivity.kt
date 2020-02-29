package com.example.lab05_userlogin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val users=ArrayList<User>(
        arrayListOf(
            User("habtom","gebre","hatomg127@gmail.com","Ha122017"),
            User("Samuel","isack","aigemito.2006@gmail.com","asm123"),
            User("Bereket","abraha","Berie@gmail.com","berie500") ,
            User("Sandip","sandi","sandi@gmail.com","snd125"),
            User("Robiel","Abraham","Robi@gmail.com","robi103")
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun OnSignIn(veiw:View){
        val us=userName.text.toString()
        val ps=password.text.toString()
        lateinit var currentUser:User
        //check user and password if it is blank
        var auth:Boolean=false
        if(us.isNullOrBlank() || ps.isNullOrBlank()){
            Toast.makeText(this,"Please UserName and Password is required",Toast.LENGTH_LONG).show()

        }
        //check if there is exist in arraylist
        else{
            for (u in users){
                currentUser=u
                if (currentUser.userName.equals(us)&& currentUser.password.equals(ps)){
                    auth=true
                    val intent=Intent(this@MainActivity,Shopping_Activity::class.java)
                    // intent.putExtra("User",currentUser)
                    intent.putExtra("User",currentUser)
                    startActivity(intent)
                }
            }
            if (!auth){
                Toast.makeText(this,"UserName or password is incorrect",Toast.LENGTH_LONG).show()
            }


        }



    }
    fun onCreateNewAccount(view: View) {
        val intent = Intent(this@MainActivity, Register_Activity::class.java)
        startActivityForResult(intent, 1) // Here 1 is the request code
    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val returnedResult = data!!.getSerializableExtra("user")!! as User
                //add the returnedResult to the ArrayList
                if(returnedResult!=null){
                    users.add(returnedResult)
                    Toast.makeText(this,"New user sucessfully added with Email : ${returnedResult.userName}",Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    fun onForgotPassword(view: View) {
        val userName=userName.text.toString().trim()
        var isEmailPresent:Boolean=false
        lateinit var currentUser:User
        if (userName!=null){
            for(u in users){
                currentUser=u
                if(u.userName.equals(userName) ){
                    isEmailPresent=true
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT,"Your password is: ${u.password}")
                    startActivity(intent)
                    break
                }
            }
            if (!isEmailPresent){
                Toast.makeText(this,"Invalid Email address.",Toast.LENGTH_LONG).show()
            }

        }else
        {
            Toast.makeText(this,"Please provide your email address.",Toast.LENGTH_LONG).show()
        }

    }

}

