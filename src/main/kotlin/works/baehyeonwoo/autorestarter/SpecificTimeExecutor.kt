package works.baehyeonwoo.autorestarter

import java.util.*

class SpecificTimeExecutor : Thread() {
    private var event: TimeExecutorEvent? = null

    private var targetHour = 0
    private var targetMinute = 0
    private var targetSecond = 0
    private var justEventCalled = false
    private var isRunning = false
    var stopOnReach = false
    private var future: Date? = null
    private var nowCalendar: Calendar? = null
    private val remainingOffsetList: ArrayList<Int> = ArrayList()

    fun setTargetTime(hour: Int, minute: Int, second: Int) {
        targetHour = hour
        targetMinute = minute
        targetSecond = second
        nowCalendar = Calendar.getInstance()
        future = targetDate
    }

    fun addRemainingOffset(diffSeconds: Int) {
        remainingOffsetList.add(diffSeconds)
    }

    fun setEvent(e: TimeExecutorEvent?) {
        event = e
    }

    override fun start() {
        super.start()
        isRunning = true
    }

    private val targetDate: Date
        get() {
            val alarmCalendar = Calendar.getInstance()
            val now = nowCalendar!!.time
            alarmCalendar.time = now
            alarmCalendar[Calendar.HOUR_OF_DAY] = targetHour
            alarmCalendar[Calendar.MINUTE] = targetMinute
            alarmCalendar[Calendar.SECOND] = targetSecond
            var alarm = alarmCalendar.time
            val timeDifference = alarm.time - now.time

            if (timeDifference <= 0) {
                alarmCalendar.add(Calendar.DAY_OF_MONTH, 1)
                alarm = alarmCalendar.time
            }
            return alarm
        }

    private fun threadLoop() {
        nowCalendar = Calendar.getInstance()
        val now = Calendar.getInstance().time
        val timeDifference = future!!.time - now.time
        val totalSeconds = timeDifference / 1000

        if (timeDifference < 0) {
            if (!justEventCalled) {
                fireReachedEvent()
                if (stopOnReach) {
                    isRunning = false
                    interrupt()
                } else {
                    future = targetDate
                }
                justEventCalled = true
            }
        } else {
            if (remainingOffsetList.contains(totalSeconds.toInt())) {
                fireRemainingEvent(totalSeconds.toInt())
            }
        }
    }

    private fun fireReachedEvent() {
        if (event != null) {
            event!!.onTimeReach()
        }
    }

    private fun fireRemainingEvent(diffSeconds: Int) {
        if (event != null) {
            event!!.onTimeRemaining(diffSeconds)
        }
    }

    override fun run() {
        while (isRunning) {
            try {
                threadLoop()
                if (!isRunning) break
                sleep(1000)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}