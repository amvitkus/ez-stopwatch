import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StopWatch {

    var formattedTime by mutableStateOf("00:00:000")
    //Coroutine scope
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    //If stop watch is active boolean
    private var isActive = false
    private var lastTimestamp = 0L
    private var timeMillis = 0L

    fun start() {
        if(isActive) return

        //Launch new coroutine
        coroutineScope.launch {

        }
    }
}