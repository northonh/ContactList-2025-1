package br.edu.ifsp.scl.bes.prdm.contactlist.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.ifsp.scl.bes.prdm.contactlist.model.Contact
import br.edu.ifsp.scl.bes.prdm.contactlist.R
import br.edu.ifsp.scl.bes.prdm.contactlist.databinding.TileContactBinding

class ContactAdapter(context: Context, private val contactList: MutableList<Contact>) :
    ArrayAdapter<Contact>(
        context,
        R.layout.tile_contact,
        contactList
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Recuperar o contato que será usado para preencher os dados da célula
        val contact = contactList[position]

        // Verificar se existe uma célula reciclada ou se é necessário inflar uma nova
        var contactTileView = convertView
        if (contactTileView == null) {
            // Infla uma nova célula
            TileContactBinding.inflate(
                context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                parent,
                false
            ).apply {
                val tileContactViewHolder = TileContactViewHolder(nameTv, emailTv)
                contactTileView = root
                contactTileView.tag = tileContactViewHolder
            }
        }

        // Preencher a célula com os dados do contato
        val viewHolder = contactTileView?.tag as TileContactViewHolder
        viewHolder.nameTv.text = contact.name
        viewHolder.emailTv.text = contact.email

        // Devolver a célula preenchida para o ListView
        return contactTileView
    }

    private data class TileContactViewHolder(val nameTv: TextView, val emailTv: TextView)
}
