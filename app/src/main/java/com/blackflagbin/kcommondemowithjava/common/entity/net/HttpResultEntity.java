package com.blackflagbin.kcommondemowithjava.common.entity.net;

import com.blackflagbin.kcommon.entity.net.IHttpResultEntity;

import org.jetbrains.annotations.NotNull;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class HttpResultEntity<T> implements IHttpResultEntity<T> {
    public boolean error;
    public int     code;
    public String  message;
    public T       results;

    @Override
    public boolean isSuccess() {
        return !error;
    }

    @Override
    public int getErrorCode() {
        return 0;
    }

    @NotNull
    @Override
    public String getErrorMessage() {
        return message;
    }

    @Override
    public T getResult() {
        return results;
    }
}
