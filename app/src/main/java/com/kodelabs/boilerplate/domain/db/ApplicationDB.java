package com.kodelabs.boilerplate.domain.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by hyuchiha on 15/05/17.
 */
@Database(name= ApplicationDB.NAME, version = ApplicationDB.VERSION)
public class ApplicationDB {
    /**
     * Version actual de la BD
     */
    public static final int VERSION = 1;
    /**
     * Nombre de la BD
     */
    public static final String NAME = "Soranus";
}
