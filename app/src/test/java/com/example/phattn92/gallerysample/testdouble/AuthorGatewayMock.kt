package com.example.phattn92.gallerysample.testdouble

import com.example.phattn92.gallerysample.domain.entity.Author
import com.example.phattn92.gallerysample.external.data.AuthorGateway
import io.reactivex.Single

class AuthorGatewayMock(private val author: Author? = null,
                        private val throwable: Throwable = Throwable()) : AuthorGateway {

    private var getAuthorCalled = false
    private var id : Long? = null

    override fun getAuthor(id: Long?): Single<Author> {
        getAuthorCalled = true
        this.id = id

        if (author == null) return Single.error(throwable)

        return Single.just(author)
    }

    fun verifyGetAuthorCalled(expectedId: Long?) : Boolean {
        return getAuthorCalled && expectedId == id
    }
}
