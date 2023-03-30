/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gunjitarora
 */
public class Doctor extends Person {

    public static int ID = 1001;

    int doctorId;
    int hospitalId;

    public Doctor(int doctorId, String firstName, String lastName, Gender gender, String email, String phone, int hospitalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
    }

    public Doctor() {

    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public String toString() {
        return firstName + ',' + lastName;
    }

}
