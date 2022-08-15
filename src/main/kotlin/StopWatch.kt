import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
class StopWatch {

    var formattedTime by mutableStateOf("00:00:000")
    //Coroutine scope
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    //If stop watch is active boolean
    private var isWatchActive = false
    private var lastTimestamp = 0L
    private var timeMillis = 0L

    fun start() {
        if(isWatchActive) return

        //Launch new coroutine
        coroutineScope.launch {
            lastTimestamp = System.currentTimeMillis()
            this@StopWatch.isWatchActive = true
            while (this@StopWatch.isWatchActive) {
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimestamp
                lastTimestamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)
            }

        }
    }

    fun reset() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        timeMillis = 0L
        lastTimestamp = 0L
        formattedTime = "00:00:000"
        isWatchActive = false
    }

    fun pause() {
        isWatchActive = false
    }

    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timeMillis), ZoneId.systemDefault())
        val formatter = DateTimeFormatter.ofPattern("mm:ss:SSS", Locale.getDefault())

        return localDateTime.format(formatter)
    }
}