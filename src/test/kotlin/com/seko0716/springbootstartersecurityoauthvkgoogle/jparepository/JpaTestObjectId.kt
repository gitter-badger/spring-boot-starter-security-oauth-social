package com.seko0716.springbootstartersecurityoauthvkgoogle.jparepository

import com.seko0716.springbootstartersecurityoauthvkgoogle.domains.User
import com.seko0716.springbootstartersecurityoauthvkgoogle.repository.UserStorage
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@EnableJpaRepositories(basePackages = [
    "com.seko0716.springbootstartersecurityoauthvkgoogle.jparepository",
    "com.seko0716.springbootstartersecurityoauthvkgoogle.repository"
])
@ComponentScan(basePackages = ["com.seko0716.springbootstartersecurityoauthvkgoogle"])
@EntityScan(basePackages = ["com.seko0716.springbootstartersecurityoauthvkgoogle"])
class JpaTestObjectId {

    @Autowired
    lateinit var userStorage: UserStorage

    @Test
    fun testObjectIdInJpa() {
        val user = userStorage.save(User(login = "123"))

        val foundedUser = userStorage.findOneByLogin("123")
        Assert.assertEquals(user, foundedUser)
    }
}