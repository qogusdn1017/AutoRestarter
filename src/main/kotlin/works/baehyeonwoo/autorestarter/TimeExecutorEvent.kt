package works.baehyeonwoo.autorestarter

interface TimeExecutorEvent {
    fun onTimeReach()
    fun onTimeRemaining(seconds: Int)
}