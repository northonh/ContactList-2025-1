package br.edu.ifsp.scl.bes.prdm.contactlist.ui

sealed interface OnContactClickListener {
    fun onContactClick(position: Int)

    // Funções abstratas relacionadas ao menu de contexto. Poderiam estar numa interface separada e
    // mais específica.
    fun onRemoveContactMenuItemClick(position: Int)
    fun onEditContactMenuItemClick(position: Int)
}