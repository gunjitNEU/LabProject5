/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.Admin;
import model.Community;
import model.Doctor;
import model.Encounter;
import model.Hospital;
import model.Patient;

/**
 *
 * @author imkus
 */
public class MainDataList {

    private MainDataList() {

    }
    private static MainDataList mainDataList = new MainDataList();

    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static ArrayList<Patient> patientList = new ArrayList<>();
    public static ArrayList<Admin> adminList = new ArrayList<>();
    public static ArrayList<Encounter> encounters = new ArrayList<>();

    public static MainDataList getMainDataListInstance() {
        return mainDataList;
    }

}
