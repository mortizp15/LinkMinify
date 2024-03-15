package com.mortizp.linkminify.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.mortizp.linkminify.model.ShortenedUrls;
import com.mortizp.linkminify.services.IShortenedUrlsService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "https://keen-babka-f222ef.netlify.app/")
@RestController
public class Controller {

    private IShortenedUrlsService iShortenedUrlsService;

    public Controller(IShortenedUrlsService iShortenedUrlsService) {
        this.iShortenedUrlsService = iShortenedUrlsService;
    }

    @PostMapping("/urls")
    public String creaShortenedUrls(@RequestBody String urlToShort) {
        return iShortenedUrlsService.createShortenedUrl(urlToShort);
    }
    
    @GetMapping("/{shortcode}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortcode) {
        ShortenedUrls shortenedUrl = iShortenedUrlsService.findByShortcode(shortcode);

        iShortenedUrlsService.incrementAccessCount(shortcode);

        return new RedirectView(shortenedUrl.getOriginalUrl(), true);        
    }

}
