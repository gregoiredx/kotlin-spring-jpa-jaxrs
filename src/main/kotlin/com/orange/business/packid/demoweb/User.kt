package com.orange.business.packid.demoweb

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(
        @Id val id: String = UUID.randomUUID().toString(),
        var email: String,
        var firstName: String? = null,
        var lastName: String? = null)
