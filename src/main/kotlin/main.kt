import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)
    val token = "c4Z2vc_5QDmGh6qIaLux0Q:APA91bGHjOzTGzudPRo5FHRF1draFSz6luXAhVSzHukvtqvm7Oxw8-v_1kBLb4KXnKOFNibENNg_9hPm5r2YxRVhuavyz2V9hqNonkp27ZrdzUABAlfWfzD6Nr2_Eq1_0A5bsXlF-FiK"

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Garry",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)

    val messagePost = Message.builder()
        .putData("action", "POST")
        .putData("content", """{
          "userId": 2,
          "userName": "Petr Svidler",
          "postId": "Hello World!",
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

       FirebaseMessaging.getInstance().send(messagePost)

}