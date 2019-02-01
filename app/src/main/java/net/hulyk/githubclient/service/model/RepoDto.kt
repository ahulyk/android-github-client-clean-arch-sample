package net.hulyk.githubclient.service.model

import com.fasterxml.jackson.annotation.JsonProperty

data class RepoDto(
        @JsonProperty("id")
        val id: Long,
        @JsonProperty("name")
        val name: String
)