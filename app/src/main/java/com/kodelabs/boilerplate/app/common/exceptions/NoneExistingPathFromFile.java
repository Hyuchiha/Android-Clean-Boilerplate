package com.kodelabs.boilerplate.app.common.exceptions;

import java.io.FileNotFoundException;

public class NoneExistingPathFromFile extends FileNotFoundException {

    public NoneExistingPathFromFile() {
        super("File from Uri is null");
    }
}
