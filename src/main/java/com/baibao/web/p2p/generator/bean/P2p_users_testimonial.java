package com.baibao.web.p2p.generator.bean;

public class P2p_users_testimonial {
    private String putTestimonialno;

    private String putName;

    private Integer putType;

    private Integer putQuantity;

    public String getPutTestimonialno() {
        return putTestimonialno;
    }

    public void setPutTestimonialno(String putTestimonialno) {
        this.putTestimonialno = putTestimonialno == null ? null : putTestimonialno.trim();
    }

    public String getPutName() {
        return putName;
    }

    public void setPutName(String putName) {
        this.putName = putName == null ? null : putName.trim();
    }

    public Integer getPutType() {
        return putType;
    }

    public void setPutType(Integer putType) {
        this.putType = putType;
    }

    public Integer getPutQuantity() {
        return putQuantity;
    }

    public void setPutQuantity(Integer putQuantity) {
        this.putQuantity = putQuantity;
    }
}