package com.example.blogapp

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blogapp.databinding.ActivityTeamMembersBinding
import com.example.blogapp.databinding.DialogAddMemberBinding
import com.example.blogapp.model.TeamMember

class TeamMembersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamMembersBinding
    private lateinit var adapter: TeamMemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamMembersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Convert sample list to mutable
        adapter = TeamMemberAdapter(TeamMember.getSampleMembers().toMutableList())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Add dividers between items
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        // Add new member button
        binding.btnAddMember.setOnClickListener {
            showAddMemberDialog()
        }
    }

    private fun showAddMemberDialog() {
        val dialogBinding = DialogAddMemberBinding.inflate(layoutInflater)

        AlertDialog.Builder(this)
            .setTitle("Add Team Member")
            .setView(dialogBinding.root)
            .setPositiveButton("Add") { _, _ ->
                val name = dialogBinding.etName.text.toString().trim()
                val role = dialogBinding.etRole.text.toString().trim()

                if (name.isNotEmpty() && role.isNotEmpty()) {
                    adapter.addMember(TeamMember(name, role))
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
