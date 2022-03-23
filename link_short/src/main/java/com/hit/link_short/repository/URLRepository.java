package com.hit.link_short.repository;

import com.hit.link_short.models.URL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URL, Long> {
    URL findURLByLink(String link);

    URL findURLByLinkShort(String linkShort);
}
