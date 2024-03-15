package com.mortizp.linkminify.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shortened_urls")
public class ShortenedUrls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url", nullable = false)
    private String originalUrl;

    @Column(unique = true, nullable = false)
    private String shortcode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "access_count")
    private Long access_count = 0L;

    public ShortenedUrls() { }

    public ShortenedUrls(Long id, String originalUrl, String shortcode, LocalDateTime createdAt,
            LocalDateTime expiresAt, Long access_count) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortcode = shortcode;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.access_count = access_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Long getAccess_count() {
        return access_count;
    }

    public void setAccess_count(Long access_count) {
        this.access_count = access_count;
    }

    public void incrementAccessCount() {
        if (this.access_count == null) {
            this.access_count = 0L;
        }
        this.access_count++;
    }

}

