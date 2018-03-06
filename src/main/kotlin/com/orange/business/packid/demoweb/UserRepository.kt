package com.orange.business.packid.demoweb

import org.springframework.data.jpa.repository.JpaRepository
import javax.inject.Named

@Named
interface UserRepository: JpaRepository<User, String> {
}