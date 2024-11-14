package com.hmmk.melkite.web.rest.vm;

import io.quarkus.panache.common.Page;
import jakarta.ws.rs.QueryParam;

public class PageRequestVM {

    @QueryParam("page")
    public int index;

    @QueryParam("size")
    public int size;

    public Page toPage() {
        return Page.of(index, size);
    }

    @Override
    public String toString() {
        return "PageRequestVM{" + "page=" + index + ", size=" + size + '}';
    }
}
