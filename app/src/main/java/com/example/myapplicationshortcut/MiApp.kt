package com.example.myapplicationshortcut

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class MiApp : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {





    val i1 : PendingIntent = Intent(context,MainActivity2::class.java).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)  }


    val i2 : PendingIntent = Intent(context,MainActivity3::class.java).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)  }



// Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.mi_app)
        // Button 1 onClick Function
        .apply{setOnClickPendingIntent(R.id.btn1,i1)}
        .apply { setOnClickPendingIntent(R.id.btn2,i2) }


    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)




}