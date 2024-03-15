package com.mortizp.linkminify.services;

import com.mortizp.linkminify.model.ShortenedUrls;

public interface IShortenedUrlsService {
    String createShortenedUrl(String urlToShort);
    
    ShortenedUrls findByShortcode(String shortCode);

    void incrementAccessCount(String shortcode);
}
