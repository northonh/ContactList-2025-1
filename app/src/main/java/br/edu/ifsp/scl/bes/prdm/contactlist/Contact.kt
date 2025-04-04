package br.edu.ifsp.scl.bes.prdm.contactlist

import android.os.Parcelable
import br.edu.ifsp.scl.bes.prdm.contactlist.Constant.INVALID_CONTACT_ID
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    var id: Int? = INVALID_CONTACT_ID,
    var name: String = "",
    var address: String = "",
    var phone: String = "",
    var email: String = ""
): Parcelable
