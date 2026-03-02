package com.senticlaw

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*

class AgentService : Service() {

    private val scope = CoroutineScope(Dispatchers.IO + Job())

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        scope.launch {
            while (true) {
                val decision = AIClient.process("Analyze environment")
                TriggerManager.handle(decision)
                delay(10000)
            }
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
