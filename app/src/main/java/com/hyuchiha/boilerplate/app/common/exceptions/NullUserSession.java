package com.hyuchiha.boilerplate.app.common.exceptions;

import java.util.concurrent.ExecutionException;

public class NullUserSession extends ExecutionException {

    public NullUserSession() {
        super("User is null");
    }

}
