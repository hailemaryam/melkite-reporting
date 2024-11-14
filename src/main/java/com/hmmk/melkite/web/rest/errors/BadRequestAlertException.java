package com.hmmk.melkite.web.rest.errors;

import java.io.Serializable;

public class BadRequestAlertException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public BadRequestAlertException() {
        super();
    }
    public BadRequestAlertException(String msg) {
        super(msg);
    }
    public BadRequestAlertException(String msg, Exception e)  {
        super(msg, e);
    }
}