import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
/*
* This class uses Compose to create the UI.
*
* */
@Composable
fun StopWatchDisplay(
    formattedTime: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    //val interactionSource = remember { MutableInteractionSource() }
    // val isPressed by interactionSource.collectIsPressedAsState()
    val color = Color.Cyan

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formattedTime,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        )
        Spacer(Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onStartClick, colors= ButtonDefaults.buttonColors(backgroundColor = color)) {
                Text("Start")

            }
            Spacer(Modifier.width(16.dp))
            Button(onPauseClick, colors= ButtonDefaults.buttonColors(backgroundColor = color)) {
                Text("Pause")
            }
            Spacer(Modifier.width(16.dp))
            Button(onResetClick, colors= ButtonDefaults.buttonColors(backgroundColor = color)) {
                Text("Reset")
            }
        }
    }
}