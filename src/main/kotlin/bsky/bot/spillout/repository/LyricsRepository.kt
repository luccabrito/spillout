package bsky.bot.spillout.repository

import bsky.bot.spillout.model.Lyrics
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LyricsRepository : JpaRepository<Lyrics, Long>
