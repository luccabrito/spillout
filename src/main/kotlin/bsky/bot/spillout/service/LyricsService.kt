package bsky.bot.spillout.service

import bsky.bot.spillout.model.Lyrics
import bsky.bot.spillout.repository.LyricsRepository
import org.springframework.stereotype.Service
import java.util.Random

@Service
class LyricsService(
    private val lyricsRepository: LyricsRepository
) {

    fun registerLyrics(lyrics: Lyrics): Lyrics {
        return lyricsRepository.save(lyrics)
    }

    fun getAllLyrics(): List<Lyrics> {
        return lyricsRepository.findAll()
    }

    fun getLyricsById(id: Long): Lyrics {
        return lyricsRepository.findById(id).orElseThrow {
            IllegalArgumentException("Lyrics with id $id not found")
        }
    }

    fun getRandomLyrics(): Lyrics {
        val size = lyricsRepository.findAll().size
        val number = Random().nextInt(1, size + 1)
        return lyricsRepository.findById(number.toLong()).orElseThrow {
            IllegalArgumentException("Lyrics with id $size not found")
        }
    }
}
