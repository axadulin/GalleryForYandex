package com.example.axadulin.galleryforyandex.model;

import java.io.Serializable;


public class FlickrPicture implements Serializable{
    private String smallPhotoURI;
    private String mediumPhotoURI;
    private String title;



    public FlickrPicture(String _FlickrPhotoURI,String m_FlickrPhotoURI, String _Title){
        smallPhotoURI = _FlickrPhotoURI;
        mediumPhotoURI =m_FlickrPhotoURI;
        title = _Title;
    }

    public String getSmallPhotoURI() {
        return smallPhotoURI;
    }

    public void setSmallPhotoURI(String smallPhotoURI) {
        this.smallPhotoURI = smallPhotoURI;
    }

    public void setMediumPhotoURI(String mediumPhotoURI) {
        this.mediumPhotoURI = mediumPhotoURI;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediumPhotoURI() {
        return mediumPhotoURI;
    }

}
