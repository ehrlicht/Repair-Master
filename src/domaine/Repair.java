/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

import java.sql.Date;

/**
 *
 * @author Hourglass
 */
public class Repair implements Comparable {
    private int repairNo;
    private Date beginDate;
    private Date endDate;
    private double totalCost;
    private String isFree;
    private int status;
    private String ownerFirstname;
    private String ownerLastname;
    private int ownerId;
    private String deviceSN;
    //private int noteId;
    private String technician;
    
    public Repair(int repairNo, Date beginDate, Date endDate, double totalCost, String isFree, int status, String ownerFirstname, String ownerlastname, int ownerId, String deviceSN, String technician) {
        this.repairNo = repairNo;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.isFree = isFree;
        this.status = status;
        this.ownerFirstname = ownerFirstname;
        this.ownerLastname = ownerlastname;
        this.ownerId = ownerId;
        this.deviceSN = deviceSN;
        //this.noteId = noteId;
        this.technician = technician;
    }

    public int getRepairNo() {
        return repairNo;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOwner() {
        return ownerFirstname + " " + ownerLastname;
    }

    public String getOwnerFirstname() {
        return ownerFirstname;
    }

    public void setOwnerFirstname(String ownerFirstname) {
        this.ownerFirstname = ownerFirstname;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }
    
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        int totalLength = 9;
        int repNoLength = String.valueOf(repairNo).length();
        String formatted = String.format("%0"+String.valueOf(totalLength-repNoLength)+"d", repairNo);
        return "R" + formatted;
    }
    
    
}
