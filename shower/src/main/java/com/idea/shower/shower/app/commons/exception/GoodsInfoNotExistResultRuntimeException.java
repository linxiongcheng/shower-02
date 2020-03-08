package com.idea.shower.shower.app.commons.exception;

import com.idea.shower.shower.app.commons.utils.Results;
import com.idea.shower.web.webmvc.exception.ResultRuntimeException;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-02-12 16:57
 */
public class GoodsInfoNotExistResultRuntimeException extends ResultRuntimeException {
    public GoodsInfoNotExistResultRuntimeException() {
        super(Results.goodsInfoNotExistError());
    }
}