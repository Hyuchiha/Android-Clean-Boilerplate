package com.kodelabs.boilerplate.lib.base;

/**
 * Created by Kev' on 04/09/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
