package spring_31.chap01

/**
 * @Author Heli
 */
interface Alarm {
    fun beep(): String
}

class KakaoTalkAlarm : Alarm {
    override fun beep(): String {
        return "KakaoTalk"
    }
}

class SmsAlarm : Alarm {
    override fun beep(): String {
        return "Sms"
    }
}

class EmailAlarm : Alarm {
    override fun beep(): String {
        return "Email"
    }
}

class AlarmCenter(private val alarm: Alarm) {
    fun alarm() {
        println(alarm.beep())
    }
}

fun main() {
    val kakaoTalkAlarm = KakaoTalkAlarm()
    val alarmCenter = AlarmCenter(kakaoTalkAlarm)

    alarmCenter.alarm()
}
