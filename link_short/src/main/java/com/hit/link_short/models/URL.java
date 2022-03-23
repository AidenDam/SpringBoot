package com.hit.link_short.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linkSort")
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;
    private String linkShort;

    public URL() {
    }

    public URL(Long id, String link, String linkShort) {
        this.id = id;
        this.link = link;
        this.linkShort = linkShort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkShort() {
        return linkShort;
    }

    public void setLinkShort(String linkShort) {
        this.linkShort = linkShort;
    }
}
