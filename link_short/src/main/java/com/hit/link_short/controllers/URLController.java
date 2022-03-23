package com.hit.link_short.controllers;

import com.hit.link_short.models.URL;
import com.hit.link_short.repository.URLRepository;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class URLController {

    @Autowired
    private URLRepository urlRepository;

    @GetMapping
    public ResponseEntity<?> getAllURL() {
        return ResponseEntity.status(200).body(urlRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createURL(@RequestParam("link") String link) {
        URL urlNew = new URL();

        URL urlOld = urlRepository.findURLByLink(link);

        if (urlOld != null) {
            return ResponseEntity.status(200).body(urlOld);
        }

        urlNew.setLink(link);
        urlNew.setLinkShort(RandomStringUtils.randomAlphanumeric(6));
        return ResponseEntity.status(200).body(urlRepository.save(urlNew));
    }

    @GetMapping("/{linkShort}")
    public RedirectView getURL(@PathVariable("linkShort") String linkShort) {
        return new RedirectView(urlRepository.findURLByLinkShort(linkShort).getLink());
    }
}
