package bsky.bot.spillout

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpilloutApplication

@SuppressWarnings("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<SpilloutApplication>(*args)
}
