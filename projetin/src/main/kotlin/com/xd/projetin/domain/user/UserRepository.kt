package com.xd.projetin.domain.user;

interface UserRepository {

    fun findAll(): List<User>
}

