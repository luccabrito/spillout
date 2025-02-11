package bsky.bot.spillout

import bsky.bot.spillout.model.Lyrics
import bsky.bot.spillout.repository.LyricsRepository
import bsky.bot.spillout.service.LyricsService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class LyricsServiceTest {

    private lateinit var lyricsRepository: LyricsRepository
    private lateinit var lyricsService: LyricsService

    @BeforeEach
    fun setup() {
        lyricsRepository = mock()
        lyricsService = LyricsService(lyricsRepository)
    }

    @RepeatedTest(10)
    fun `deve sempre retornar um registro dentro do threshold`() {
        val lyricsList = listOf(
            Lyrics(1, "Letra A", "", "", 0),
            Lyrics(2, "Letra B", "", "", 1),
            Lyrics(3, "Letra C", "", "",4),
            Lyrics(4, "Letra D", "", "", 2),
            Lyrics(5, "Letra E", "", "", 3)
        )

        `when`(lyricsRepository.findAll()).thenReturn(lyricsList)

        val result = lyricsService.getRandomLyricsBot()
        println("The selected lyric's timesChosen is ${result.timesChosen}")

        assertTrue(result.timesChosen <= 2)
    }

}