/*
 * Z-Way for Android is a UI for Z-Way server
 *
 * Created by Ivan Platonov on 07.07.14 17:59.
 * Copyright (c) 2014 Z-Wave.Me
 *
 * All rights reserved
 * info@z-wave.me
 * Z-Way for Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Z-Way for Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Z-Way for Android.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.z_wave.android.database.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import me.z_wave.android.dataModel.LocalProfile;
import me.z_wave.android.dataModel.Profile;

/**
 * Created by Ivan PL on 07.07.2014.
 */
public class ProfileTable {

    public static final String TABLE_NAME = "Profiles";

    public static final String P_SERVER_ID = "PServerId";
    public static final String P_NAME = "PName";
    public static final String P_INDOOR_SERVER = "PIndoorServer";
    public static final String P_LOGIN = "PLogin";
    public static final String P_PASSWORD = "PPassword";
    public static final String P_LONGITUDE = "PLongitude";
    public static final String P_LATITUDE = "PLatitude";
    public static final String P_ACTIVE = "PActive";

    private static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME + " ("
            + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + P_SERVER_ID + " INTEGER,"
            + P_NAME + " TEXT NOT NULL,"
            + P_INDOOR_SERVER + " TEXT NOT NULL,"
            + P_LOGIN + " TEXT NOT NULL,"
            + P_PASSWORD + " TEXT NOT NULL,"
            + P_LONGITUDE + " REAL,"
            + P_LATITUDE + " REAL,"
            + P_ACTIVE + " TEXT,"
            + "UNIQUE (" + BaseColumns._ID + "," + P_SERVER_ID + ") ON CONFLICT REPLACE)";

    public static void createTable(SQLiteDatabase database){
        database.execSQL(SQL_CREATE);
    }

    public static void removeTable(SQLiteDatabase database){
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public static ContentValues createContentValues(LocalProfile profile) {
        final ContentValues values = new ContentValues();
        values.put(P_SERVER_ID, profile.serverId);
        values.put(P_NAME, profile.name);
        values.put(P_INDOOR_SERVER, profile.indoorServer);
        values.put(P_LOGIN, profile.login);
        values.put(P_PASSWORD, profile.password);
        values.put(P_LONGITUDE, profile.longitude);
        values.put(P_LATITUDE, profile.latitude);
        values.put(P_ACTIVE, profile.active ? 1 : 0);
        return values;
    }



}