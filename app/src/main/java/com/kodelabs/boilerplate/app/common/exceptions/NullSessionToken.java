package com.kodelabs.boilerplate.app.common.exceptions;

import java.util.concurrent.ExecutionException;

public class NullSessionToken extends ExecutionException {

    public NullSessionToken() {
        super("Session token is null");
    }

}
