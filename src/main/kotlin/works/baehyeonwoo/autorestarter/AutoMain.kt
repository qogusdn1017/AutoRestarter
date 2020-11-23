package works.baehyeonwoo.autorestarter

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class AutoMain : JavaPlugin() {
    override fun onEnable() {
        val executor = SpecificTimeExecutor()
        executor.setTargetTime(0, 0, 0)
        executor.stopOnReach = true
        executor.addRemainingOffset(30)
        executor.addRemainingOffset(20)
        executor.addRemainingOffset(10)
        executor.setEvent(object : TimeExecutorEvent {
            override fun onTimeReach() {
                for (b in Bukkit.getOnlinePlayers()) {
                    b.sendTitle("", "So Long, and Thanks for All the Fish.", 0, 150, 0)
                }
                Bukkit.broadcastMessage("${ChatColor.GREEN}[AutoRestarter] ${ChatColor.WHITE}${ChatColor.BOLD}서버가 재시작 됩니다.")
                Bukkit.shutdown()
            }
            override fun onTimeRemaining(seconds: Int) {
                println("Current Restart Time Remaining : $seconds seconds left.")
                Bukkit.broadcastMessage("${ChatColor.GREEN}[AutoRestarter] ${ChatColor.WHITE}서버 재시작 까지 ${ChatColor.BOLD}${seconds}초 ${ChatColor.RESET}남았습니다.")
            }
        })
        executor.start()
    }
}