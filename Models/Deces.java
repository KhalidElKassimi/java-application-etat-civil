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
public class Deces {
    private int idDeces;

    /**
     * Get the value of idDeces
     *
     * @return the value of idDeces
     */
    public int getIdDeces() {
        return idDeces;
    }

    /**
     * Set the value of idDeces
     *
     * @param idDeces new value of idDeces
     */
    public void setIdDeces(int idDeces) {
        this.idDeces = idDeces;
    }

        private int idPersonne;

    /**
     * Get the value of idPersonne
     *
     * @return the value of idPersonne
     */
    public int getIdPersonne() {
        return idPersonne;
    }

    /**
     * Set the value of idPersonne
     *
     * @param idPersonne new value of idPersonne
     */
    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

        private Date dateDeces;

    /**
     * Get the value of dateDeces
     *
     * @return the value of dateDeces
     */
    public Date getDateDeces() {
        return dateDeces;
    }

    /**
     * Set the value of dateDeces
     *
     * @param dateDeces new value of dateDeces
     */
    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

        private String causeDeces;

    /**
     * Get the value of causeDeces
     *
     * @return the value of causeDeces
     */
    public String getCauseDeces() {
        return causeDeces;
    }

    /**
     * Set the value of causeDeces
     *
     * @param causeDeces new value of causeDeces
     */
    public void setCauseDeces(String causeDeces) {
        this.causeDeces = causeDeces;
    }

    public Deces() {
    }
    
    private String lieuDeces;

    /**
     * Get the value of lieuDeces
     *
     * @return the value of lieuDeces
     */
    public String getLieuDeces() {
        return lieuDeces;
    }

    /**
     * Set the value of lieuDeces
     *
     * @param lieuDeces new value of lieuDeces
     */
    public void setLieuDeces(String lieuDeces) {
        this.lieuDeces = lieuDeces;
    }

       
    

    public Deces(int idDeces, Date dateDeces, String causeDeces, String lieuDeces, int idPersonne) {
        this.idDeces = idDeces;
        this.dateDeces = dateDeces;
        this.causeDeces = causeDeces;
        this.lieuDeces = lieuDeces;
        this.idPersonne = idPersonne;
    }

    @Override
    public String toString() {
        return "Deces{" + "idDeces=" + idDeces + ", idPersonne=" + idPersonne + ", dateDeces=" + dateDeces + ", causeDeces=" + causeDeces + ", lieuDeces=" + lieuDeces + '}';
    }

    
}
