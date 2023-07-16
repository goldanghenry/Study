package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String phoneNumber;
    private String ownerName;
    private String petName;
    private String address;
    private String species;
    private int birthYear;
    private List<MedicalRecord> medicalRecords; // 진료 기록을 저장하는 리스트
    public Customer() {}

    public Customer(String phoneNumber, String ownerName, String petName, String address, String species, int birthYear) {
        this.phoneNumber = phoneNumber;
        this.ownerName = ownerName;
        this.petName = petName;
        this.address = address;
        this.species = species;
        this.birthYear = birthYear;
        this.medicalRecords = new ArrayList<>();// 빈 리스트로 초기화
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPetName() {
        return petName;
    }

    public String getAddress() {
        return address;
    }

    public String getSpecies() {
        return species;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // 고객별로 진료기록을 등록
    public void addMedicalRecords(MedicalRecord record) {
        this.medicalRecords.add(record);
    }
}