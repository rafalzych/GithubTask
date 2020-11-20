package com.rafalzych.github.task.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafalzych.github.task.R
import com.rafalzych.github.task.model.GithubUser
import com.rafalzych.github.task.util.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.github_user_item.view.*

class GithubUsersAdapter : RecyclerView.Adapter<GithubUsersAdapter.GithubUsersViewHolder>() {

    private val items: MutableList<GithubUser> = mutableListOf()
    private val itemsAll: MutableList<GithubUser> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUsersViewHolder {
        return GithubUsersViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.github_user_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GithubUsersViewHolder, position: Int) {
        return holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<GithubUser>) {
        items.clear()
        items.addAll(newItems)
        itemsAll.addAll(newItems)
        notifyDataSetChanged()
    }

    fun filter(text: String) {
        items.clear()
        if (text.isEmpty()) {
            items.addAll(itemsAll)
        } else {
            for (user: GithubUser in itemsAll) {
                if (user.userName?.toLowerCase()
                        ?.contains(text) == true || user.userRepositories?.any { it.name == text } == true
                ) {
                    items.add(user)
                }
            }
        }
        notifyDataSetChanged()
    }

    inner class GithubUsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        LayoutContainer {

        override val containerView = itemView

        fun bind(user: GithubUser) {
            with(itemView) {
                ivUserAvatar.loadImage(user.userAvatarUrl ?: "")
                tvUserNameValue.text = user.userName
                tvUserReposValue.text =
                    user.userRepositories?.joinToString(separator = System.lineSeparator()) { "${it.name}" }
            }
        }
    }
}