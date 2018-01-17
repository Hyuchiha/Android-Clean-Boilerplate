package com.hyuchiha.boilerplate.data.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by hyuchiha on 15/05/17.
 */
@Database(name= ApplicationDB.NAME, version = ApplicationDB.VERSION, foreignKeyConstraintsEnforced = true)
public class ApplicationDB {
    /**
     * Version actual de la BD
     */
    public static final int VERSION = 1;

    //TODO rename db name
    /**
     * Nombre de la BD
     */
    public static final String NAME = "db_name";
}
