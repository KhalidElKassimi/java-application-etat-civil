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
public class Personne {
    private int Id;

    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public int getId() {
        return Id;
    }

    /**
     * Set the value of Id
     *
     * @param Id new value of Id
     */
    public void setId(int Id) {
        this.Id = Id;
    }

        private String Nom;

    /**
     * Get the value of Nom
     *
     * @return the value of Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Set the value of Nom
     *
     * @param Nom new value of Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    
        private String Prenom;

    /**
     * Get the value of Prenom
     *
     * @return the value of Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * Set the value of Prenom
     *
     * @param Prenom new value of Prenom
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

        private String Sexe;

    /**
     * Get the value of Sexe
     *
     * @return the value of Sexe
     */
    public String getSexe() {
        return Sexe;
    }

    /**
     * Set the value of Sexe
     *
     * @param Sexe new value of Sexe
     */
    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

        private String lieuNaiss;

    /**
     * Get the value of lieuNaiss
     *
     * @return the value of lieuNaiss
     */
    public String getLieuNaiss() {
        return lieuNaiss;
    }

    /**
     * Set the value of lieuNaiss
     *
     * @param lieuNaiss new value of lieuNaiss
     */
    public void setLieuNaiss(String lieuNaiss) {
        this.lieuNaiss = lieuNaiss;
    }

        private Date dateNaiss;

    /**
     * Get the value of dateNaiss
     *
     * @return the value of dateNaiss
     */
    public Date getDateNaiss() {
        return dateNaiss;
    }

    /**
     * Set the value of dateNaiss
     *
     * @param dateNaiss new value of dateNaiss
     */
    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
    
        private int idPere;

    /**
     * Get the value of idPere
     *
     * @return the value of idPere
     */
    public int getIdPere() {
        return idPere;
    }

    /**
     * Set the value of idPere
     *
     * @param idPere new value of idPere
     */
    public void setIdPere(int idPere) {
        this.idPere = idPere;
    }

        private int idMere;

    /**
     * Get the value of idMere
     *
     * @return the value of idMere
     */
    public int getIdMere() {
        return idMere;
    }

    /**
     * Set the value of idMere
     *
     * @param idMere new value of idMere //ra ba9i makhdam hahah what
     */
    public void setIdMere(int idMere) {
        this.idMere = idMere;
    }

    

    public Personne() {
    }

    public Personne(int Id, String Nom, String Prenom, String Sexe, String lieuNaiss, Date dateNaiss, int idPere, int idMere) {
        this.Id = Id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Sexe = Sexe;
        this.lieuNaiss = lieuNaiss;
        this.dateNaiss = dateNaiss;
        this.idPere=idPere;
        this.idMere=idMere;

    }

    @Override
    public String toString() {
        return "Personne{" + "Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Sexe=" + Sexe + ", lieuNaiss=" + lieuNaiss + ", dateNaiss=" + dateNaiss + ", idPere=" + idPere + ", idMere=" + idMere + '}';
    }

   
    
    
     

    
    
    
    
}
