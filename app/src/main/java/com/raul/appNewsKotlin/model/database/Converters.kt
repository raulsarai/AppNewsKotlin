package com.raul.appNewsKotlin.model.database

import androidx.room.TypeConverter
import com.raul.appNewsKotlin.model.Source


class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String) : Source {
        return Source(name, name)
    }
}