package bsky.bot.spillout.service

import bsky.bot.spillout.model.Lyrics
import bsky.bot.spillout.repository.LyricsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
        return lyricsRepository.findAll().random()
    }

    @Transactional
    fun getRandomLyricsBot(): Lyrics {
        val allRecords = lyricsRepository.findAll()
        val maxTimesChosen = allRecords.maxOfOrNull { it.timesChosen } ?: 0
        val threshold = maxTimesChosen - 1
        val selectedRecord = generateSequence { allRecords.random() }
            .first{ it.timesChosen < threshold }
        lyricsRepository.save(selectedRecord)

        return selectedRecord
    }
}
