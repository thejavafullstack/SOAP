package com.thejavafullstack.Covid19ProfilerSoapConsumer.exception;


public class Covid19ProfilerServiceFailedException extends RuntimeException {

    public Covid19ProfilerServiceFailedException() {
    }

    public Covid19ProfilerServiceFailedException(String message) {
        super(message);
    }

}