package bsky.bot.spillout.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Lyrics(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val lyric: String,

    @Column
    val album: String,

    @Column
    val artist: String
) {
    constructor() : this(null, "", "", "")
}
