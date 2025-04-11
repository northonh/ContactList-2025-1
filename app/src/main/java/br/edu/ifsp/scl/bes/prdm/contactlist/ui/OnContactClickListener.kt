package br.edu.ifsp.scl.bes.prdm.contactlist.ui

sealed interface OnContactClickListener {
    fun onContactClick(position: Int)
}