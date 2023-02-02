/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author khalid
 */
public class Mariage {
     private int idMariage;

    /**
     * Get the value of idMariage
     *
     * @return the value of idMariage
     */
    public int getIdMariage() {
        return idMariage;
    }

    /**
     * Set the value of idMariage
     *
     * @param idMariage new value of idMariage
     */
    public void setIdMariage(int idMariage) {
        this.idMariage = idMariage;
    }

        private int idEpoux;

    /**
     * Get the value of idEpoux
     *
     * @return the value of idEpoux
     */
    public int getIdEpoux() {
        return idEpoux;
    }

    /**
     * Set the value of idEpoux
     *
     * @param idEpoux new value of idEpoux
     */
    public void setIdEpoux(int idEpoux) {
        this.idEpoux = idEpoux;
    }

        private int idEpouse;

    /**
     * Get the value of idEpouse
     *
     * @return the value of idEpouse
     */
    public int getIdEpouse() {
        return idEpouse;
    }

    /**
     * Set the value of idEpouse
     *
     * @param idEpouse new value of idEpouse
     */
    public void setIdEpouse(int idEpouse) {
        this.idEpouse = idEpouse;
    }

        private Date dateMariage;

    /**
     * Get the value of dateMariage
     *
     * @return the value of dateMariage
     */
    public Date getDateMariage() {
        return dateMariage;
    }

    /**
     * Set the value of dateMariage
     *
     * @param dateMariage new value of dateMariage
     */
    public void setDateMariage(Date dateMariage) {
        this.dateMariage = dateMariage;
    }

        private String lieuMariage;

    /**
     * Get the value of lieuMariage
     *
     * @return the value of lieuMariage
     */
    public String getLieuMariage() {
        return lieuMariage;
    }

    /**
     * Set the value of lieuMariage
     *
     * @param lieuMariage new value of lieuMariage
     */
    public void setLieuMariage(String lieuMariage) {
        this.lieuMariage = lieuMariage;
    }

    public Mariage() {
    }

    public Mariage(int idMariage, Date dateMariage, String lieuMariage, int idEpoux,int idEpouse) {
        this.idMariage = idMariage;
        this.dateMariage = dateMariage;
        this.lieuMariage = lieuMariage;
        this.idEpouse=idEpouse;
        this.idEpoux=idEpoux;
    }

    @Override
    public String toString() {
        return "Mariage{" + "idMariage=" + idMariage + ", idEpoux=" + idEpoux + ", idEpouse=" + idEpouse + ", dateMariage=" + dateMariage + ", lieuMariage=" + lieuMariage + '}';
    }

    

        
    
}
