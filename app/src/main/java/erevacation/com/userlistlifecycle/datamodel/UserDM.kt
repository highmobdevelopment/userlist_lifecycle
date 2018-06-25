package erevacation.com.userlistlifecycle.datamodel

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.erevacation.networking.networkmodel.ListNM

@Entity(tableName = "users")
data class UserDM(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        var name: String = "",
        var surname: String = "",
        var image: String = "",
        @Embedded
        var contactDetails: Details = Details("", Details.Phones("", ""), "")) {
    data class Details(
            var email: String,
            @Embedded
            var phones: Phones = Phones("", ""),
            var address: String) {
        data class Phones(
                var home: String,
                var work: String) {

            constructor(phones: ListNM.Details.Phones) : this(
                    phones.home,
                    phones.work
            )
        }

        constructor(details: ListNM.Details) : this(
                details.email,
                Phones(details.phones),
                details.address
        )

    }

    constructor(listNM: ListNM) : this(
            null,
            listNM.name,
            listNM.surname,
            listNM.image,
            Details(listNM.contactDetails)
    )


}
