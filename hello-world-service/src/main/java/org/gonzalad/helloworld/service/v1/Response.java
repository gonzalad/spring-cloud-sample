package org.gonzalad.helloworld.service.v1;

public class Response<E> {
    private E data;

    public Response(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
