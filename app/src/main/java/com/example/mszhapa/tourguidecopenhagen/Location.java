package com.example.mszhapa.tourguidecopenhagen;

/**
 * Created by MsZhapa on 26/06/2017. Custom class for Location object with getters and public constructor
 */

public class Location {

    private String mLocationName;
    private String mLocationDescription;
    private String mLocationHours;
    private String mLocationAddress;
    private String mLocationWebsite;
    private String mLocationPhone;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Location(String locationName, String locationDescription, String locationHours, String locationAddress, String locationWebsite, String locationPhone, int imageResourceId) {

        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mImageResourceId = imageResourceId;
        mLocationHours = locationHours;
        mLocationAddress = locationAddress;
        mLocationWebsite = locationWebsite;
        mLocationPhone = locationPhone;

    }

    public String getLocationName() {
        return mLocationName;
    }


    public String getLocationDescription() {
        return mLocationDescription;
    }


    public String getLocationHours() {
        return mLocationHours;
    }


    public String getLocationAddress() {
        return mLocationAddress;
    }


    public String getLocationWebsite() {
        return mLocationWebsite;
    }


    public String getLocationPhone() {
        return mLocationPhone;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }


    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
