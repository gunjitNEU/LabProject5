/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author imkus
 */
public class Hospital {

    public static int ID = 1001;

    int hospitalId;
    String name;
    int communityId;

    public Hospital(int hospitalId, String name, int communityId) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.communityId = communityId;
    }

    public Hospital() {

    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    @Override
    public String toString() {
        return name;
    }

}
