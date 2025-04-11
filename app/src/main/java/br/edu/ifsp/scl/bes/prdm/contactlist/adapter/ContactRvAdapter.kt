package br.edu.ifsp.scl.bes.prdm.contactlist.adapter

import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.scl.bes.prdm.contactlist.databinding.TileContactBinding
import br.edu.ifsp.scl.bes.prdm.contactlist.model.Contact
import br.edu.ifsp.scl.bes.prdm.contactlist.ui.OnContactClickListener

class ContactRvAdapter(
    private val contactList: MutableList<Contact>,
    private val onContactClickListener: OnContactClickListener
): RecyclerView.Adapter<ContactRvAdapter.ContactViewHolder>() {
    inner class ContactViewHolder(tcb: TileContactBinding): RecyclerView.ViewHolder(tcb.root){
        val nameTv: TextView = tcb.nameTv
        val emailTv: TextView = tcb.emailTv
    }

    // Chamado somente quando um novo holder (e consequentemente uma nova célula) precisa ser criado.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder = ContactViewHolder(
        TileContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    // Chamado sempre que os dados de um holder (ou seja, da célula) precisam ser preenchidos ou trocados.
    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
       contactList[position].let { contact ->
           with(holder) {
               nameTv.text = contact.name
               emailTv.text = contact.email
               holder.itemView.setOnClickListener {
                   onContactClickListener.onContactClick(position)
               }
           }
       }
    }

    // Retorna o número de elementos no data source
    override fun getItemCount(): Int = contactList.size
}