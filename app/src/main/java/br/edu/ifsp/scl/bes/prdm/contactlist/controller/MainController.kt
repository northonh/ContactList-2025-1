package br.edu.ifsp.scl.bes.prdm.contactlist.controller

import br.edu.ifsp.scl.bes.prdm.contactlist.model.Contact
import br.edu.ifsp.scl.bes.prdm.contactlist.model.ContactDao
import br.edu.ifsp.scl.bes.prdm.contactlist.model.ContactSqlite
import br.edu.ifsp.scl.bes.prdm.contactlist.ui.MainActivity

class MainController(mainActivity: MainActivity) {
    private val contactDao: ContactDao = ContactSqlite(mainActivity)

    fun insertContact(contact: Contact) = contactDao.createContact(contact)
}