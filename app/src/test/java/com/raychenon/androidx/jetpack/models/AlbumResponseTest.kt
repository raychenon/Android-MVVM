package com.raychenon.androidx.jetpack.models

import com.squareup.moshi.Moshi
import java.io.BufferedReader
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumResponseTest {

    @Test
    fun testParseJson() {
        val response = parseJson("user-albums.json")

        assertEquals("f73f6eb8ce6254070948cfbcf02e0276", response?.checksum)
        assertEquals(25, response?.data?.size)
        // check first album
        val firstAlbum = response?.data?.get(0)
        assertEquals("Groove Sessions", firstAlbum?.title)
        assertEquals("http://e-cdn-images.deezer.com/images/cover/f093d4a9d85f50e91b0ae6b2119a72ef/250x250-000000-80-0-0.jpg", firstAlbum?.cover_medium)

        val artist = response?.data?.get(0)?.artist
        assertEquals("Chinese Man", artist?.name)
        assertEquals("http://e-cdn-images.deezer.com/images/artist/d3653b8d5608f93f8e190668d679bec4/250x250-000000-80-0-0.jpg", artist?.picture_medium)
    }

    private fun parseJson(fileName: String): AlbumResponse? {
        val inputStream = javaClass.classLoader
            ?.getResourceAsStream("api-response/$fileName")
        val content = inputStream!!.bufferedReader().use(BufferedReader::readText)

        var moshi = Moshi.Builder()
            .build()

        val albumResponse = moshi.adapter(AlbumResponse::class.java).fromJson(content)
        return albumResponse
    }
}
