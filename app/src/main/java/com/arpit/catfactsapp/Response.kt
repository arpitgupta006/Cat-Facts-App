package com.arpit.catfactsapp

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("deleted")
	val deleted: Boolean? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("used")
	val used: Boolean? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("user")
	val user: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

