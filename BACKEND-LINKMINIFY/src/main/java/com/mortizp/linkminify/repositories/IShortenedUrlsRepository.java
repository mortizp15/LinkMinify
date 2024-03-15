package com.mortizp.linkminify.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortizp.linkminify.model.ShortenedUrls;


public interface IShortenedUrlsRepository extends JpaRepository<ShortenedUrls, Long>{
    ShortenedUrls findByOriginalUrl(String url);
    ShortenedUrls findByShortcode(String shortcode);
    void deleteByExpiresAtBefore(LocalDateTime dateTime);
}
