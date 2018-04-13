package com.example.phattn92.gallerysample.external.data

import com.example.phattn92.gallerysample.domain.entity.Author
import io.reactivex.Single
import java.util.*

class AuthorNetworkGateway : AuthorGateway {

    override fun getAuthor(id: Long?): Single<Author> {
        return Single.create<Author> { source ->
            if (id == null) {
                return@create source.onSuccess(Author.EmptyAuthor())
            }

            val author = queryAuthorById(id)
            return@create source.onSuccess(author)
        }
    }

    private fun queryAuthorById(id: Long) : Author {
        // Simulate network delay
        Thread.sleep(50)

        val randNum = Random().nextInt(AUTHOR_LIST.size)

        return AUTHOR_LIST[randNum]
    }

    private companion object {
        val AUTHOR_LIST = arrayOf(
                Author.AuthorInfo(1L, "FirstName1", "LastName1",
                        Date().time, "VN"),
                Author.AuthorInfo(2L, "FirstName2", "LastName2",
                        Date().time, "VN"),
                Author.AuthorInfo(3L, "FirstName3", "LastName3",
                        Date().time, "VN"),
                Author.AuthorInfo(4L, "FirstName4", "LastName4",
                        Date().time, "VN"),
                Author.AuthorInfo(5L, "FirstName5", "LastName5",
                        Date().time, "VN"),
                Author.AuthorInfo(6L, "FirstName6", "LastName6",
                        Date().time, "VN"),
                Author.AuthorInfo(7L, "FirstName7", "LastName7",
                        Date().time, "VN"),
                Author.AuthorInfo(8L, "FirstName8", "LastName8",
                        Date().time, "VN"),
                Author.AuthorInfo(9L, "FirstName9", "LastName9",
                        Date().time, "VN"),
                Author.AuthorInfo(10L, "FirstName10", "LastName10",
                        Date().time, "VN"),
                Author.AuthorInfo(11L, "FirstName11", "LastName11",
                        Date().time, "VN"),
                Author.AuthorInfo(12L, "FirstName12", "LastName12",
                        Date().time, "VN"),
                Author.AuthorInfo(13L, "FirstName13", "LastName13",
                        Date().time, "VN"),
                Author.AuthorInfo(14L, "FirstName14", "LastName14",
                        Date().time, "VN"),
                Author.AuthorInfo(15L, "FirstName15", "LastName15",
                        Date().time, "VN"),
                Author.AuthorInfo(16L, "FirstName16", "LastName16",
                        Date().time, "VN")
        )
    }
}