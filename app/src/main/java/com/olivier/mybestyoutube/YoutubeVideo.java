package com.olivier.mybestyoutube;

import java.net.URL;

public class YoutubeVideo {

    private Long id;
    private String title;
    private String description;
    private URL url;
    private String category;

    public YoutubeVideo() {
    }

    public YoutubeVideo(String title, String description, URL url, String category) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "YoutubeVideo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url=" + url +
                ", category='" + category + '\'' +
                '}';
    }
}
