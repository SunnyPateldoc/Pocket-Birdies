package com.example.pocketbirdies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ModelInstructors(val imageProfile: String, val nameInstructors:String, val nameCenter:String,
                            var isSelected:Boolean):Parcelable
