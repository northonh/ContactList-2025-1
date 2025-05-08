package br.edu.ifsp.scl.bes.prdm.contactlist.controller

import br.edu.ifsp.scl.bes.prdm.contactlist.model.Contact
import br.edu.ifsp.scl.bes.prdm.contactlist.model.ContactDao
import br.edu.ifsp.scl.bes.prdm.contactlist.model.ContactSqlite
import br.edu.ifsp.scl.bes.prdm.contactlist.ui.MainActivity

class MainController(mainActivity: MainActivity) {
    private val contactDao: ContactDao = ContactSqlite(mainActivity)

    fun insertContact(contact: Contact) = contactDao.createContact(contact)
    fun getContact(id: Int) = contactDao.retrieveContact(id)
    fun getContacts() = contactDao.retrieveContacts()
    fun modifyContact(contact: Contact) = contactDao.updateContact(contact)
    fun removeContact(id: Int) = contactDao.deleteContact(id)
}