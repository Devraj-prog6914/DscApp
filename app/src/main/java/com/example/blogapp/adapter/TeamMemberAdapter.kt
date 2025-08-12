package com.example.blogapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blogapp.databinding.ItemTeamMemberBinding
import com.example.blogapp.model.TeamMember

class TeamMemberAdapter(private val members: MutableList<TeamMember>) :
    RecyclerView.Adapter<TeamMemberAdapter.TeamMemberViewHolder>() {

    inner class TeamMemberViewHolder(val binding: ItemTeamMemberBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        val binding = ItemTeamMemberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TeamMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        val member = members[position]
        holder.binding.tvName.text = member.name
        holder.binding.tvRole.text = member.role

        // Delete button action
        holder.binding.btnDelete.setOnClickListener {
            removeMember(position)
        }
    }

    override fun getItemCount(): Int = members.size

    // Add a member
    fun addMember(member: TeamMember) {
        members.add(member)
        notifyItemInserted(members.size - 1)
    }

    // Remove a member
    fun removeMember(position: Int) {
        if (position in members.indices) {
            members.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}
