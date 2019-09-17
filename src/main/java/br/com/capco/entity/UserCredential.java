package br.com.capco.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.capco.enums.ProfileEnum;

@Entity
@Table(name = "user_credential")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCredential implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String password;
    private String code;
    private ProfileEnum profile;
    private Date dateCreate;
    private Date dateUpdate;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the code
     */
    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the profile
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    public ProfileEnum getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }

    /**
     * @return the dateCreate
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreate", nullable = false)
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * @param dateCreate the dateCreate to set
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * @return the dateUpdate
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateUpdate", nullable = false)
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * @param dateUpdate the dateUpdate to set
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @PreUpdate
    public void preUpdate() {
        dateUpdate = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date now = new Date();
        dateCreate = now;
        dateUpdate = now;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserCredential other = (UserCredential) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserCredential [id=" + id + ", name=" + name + ", email=" + email + ", password="
                + password + ", code=" + code + ", profile=" + profile + ", dateCreate="
                + dateCreate + ", dateUpdate=" + dateUpdate + "]";
    }
}
