package bsky.bot.spillout.controller

import bsky.bot.spillout.model.Lyrics
import bsky.bot.spillout.service.LyricsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lyrics")
@CrossOrigin(origins = ["http://localhost:5500"])
class LyricsController(
    private val service: LyricsService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerLyrics(@RequestBody body: LyricCreationRequest) {
        service.registerLyrics(body.toDomain())
    }

    @GetMapping
    fun getAllLyrics(): List<Lyrics> {
        return service.getAllLyrics()
    }

    @GetMapping("/{id}")
    fun getLyricsById(@PathVariable id: Long): Lyrics {
        return service.getLyricsById(id)
    }

    @GetMapping("/random")
    fun getRandom(): Lyrics {
        return service.getRandomLyrics()
    }
}
