package bsky.bot.spillout.controller

import bsky.bot.spillout.model.Lyrics

data class LyricCreationRequest(
    val lyric: String,
    val album: String,
    val artist: String
) {
    fun toDomain() = Lyrics(
        lyric = lyric,
        album = album,
        artist = artist
    )
}
