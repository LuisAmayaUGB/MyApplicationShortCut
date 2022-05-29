package com.example.myapplicationshortcut

      import android.content.Intent
     import android.os.Build
     import android.os.Bundle
     import android.widget.Toast
     import androidx.annotation.RequiresApi
     import androidx.appcompat.app.AppCompatActivity
     import androidx.core.content.pm.ShortcutInfoCompat
     import androidx.core.content.pm.ShortcutManagerCompat
     import androidx.core.graphics.drawable.IconCompat
      import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        ponershortcut.setOnClickListener {
            shorcut()
        }






     }


fun shorcut(){
    if (ShortcutManagerCompat.isRequestPinShortcutSupported(applicationContext)) {
        val shortcutInfo = ShortcutInfoCompat.Builder(applicationContext, "#1")
            .setIntent(
                Intent(
                    applicationContext,
                    MainActivity::class.java
                ).setAction(Intent.ACTION_MAIN)
            ) // !!! intent's action must be set on oreo
            .setShortLabel("Test")
            .setIcon(IconCompat.createWithResource(applicationContext, R.drawable.logo))
            .build()
        ShortcutManagerCompat.requestPinShortcut(applicationContext, shortcutInfo, null)
    } else {
        Toast.makeText(
            this@MainActivity,
            "launcher does not support short cut icon",
            Toast.LENGTH_LONG
        ).show()
    }
}


}