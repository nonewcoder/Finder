package com.example.android.finder;

public class objectData {

    String centerId;

    String centerName;
    String address;
    String stateName;
    String districtName;
    String blockName;
    String pincode;
    String timingFrom;
    String timingTo;
    String feeType;
    String date;
    String fee;
    String availableCapacity;
    String dose1;
    String dose2;
    String ageLimit;
    String vaccine;
    String slots;

    public objectData(String centerId, String centerName, String address, String stateName, String districtName, String blockName, String pincode, String timingFrom, String timingTo, String feeType, String date, String fee, String availableCapacity, String dose1, String dose2, String ageLimit, String vaccine, String slots) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.address = address;
        this.stateName = stateName;
        this.districtName = districtName;
        this.blockName = blockName;
        this.pincode = pincode;
        this.timingFrom = timingFrom;
        this.timingTo = timingTo;
        this.feeType = feeType;
        this.date = date;
        this.fee = fee;
        this.availableCapacity = availableCapacity;
        this.dose1 = dose1;
        this.dose2 = dose2;
        this.ageLimit = ageLimit;
        this.vaccine = vaccine;
        this.slots = slots;
    }

    public String getDose1() {
        return dose1;
    }

    public void setDose1(String dose1) {
        this.dose1 = dose1;
    }

    public String getDose2() {
        return dose2;
    }

    public void setDose2(String dose2) {
        this.dose2 = dose2;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String  getCenterId() {
        return centerId;
    }

    public void setCenterId(String  centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String  getPincode() {
        return pincode;
    }

    public void setPincode(String  pincode) {
        this.pincode = pincode;
    }

    public String getTimingFrom() {
        return timingFrom;
    }

    public void setTimingFrom(String timiinFrom) {
        this.timingFrom = timiinFrom;
    }

    public String getTimingTo() {
        return timingTo;
    }

    public void setTimingTo(String timingTo) {
        this.timingTo = timingTo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(String availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }
}
