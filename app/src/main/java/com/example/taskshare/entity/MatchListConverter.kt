package com.example.taskshare.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


//Data Class verilerimizi listeye almak için

class MatchListConverter {
        @TypeConverter
        fun fromMatchList(matchList: List<MatchEntity?>?): String? {
            if (matchList == null) {
                return null
            }
            val gson = Gson()
            val type =
                object : TypeToken<List<MatchEntity?>?>() {}.getType()
            return gson.toJson(matchList, type)
        }

        @TypeConverter
        fun toMatchList(matchString: String?): List<MatchEntity>? {
            if (matchString == null) {
                return null
            }
            val gson = Gson()
            val type =
                object : TypeToken<List<MatchEntity?>?>() {}.getType()
            return gson.fromJson(matchString, type)
        }

}