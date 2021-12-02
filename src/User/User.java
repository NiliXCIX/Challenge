package User;


import java.util.UUID;

public abstract class User {
    String voornaam;
    String achternaam;
    String geboortedatum;
    String geslacht;
    String email;
    String gebruikersnaam;
    String wachtwoord;
    UUID gebruikerscode;


    public String getVoornaam(){return voornaam;}

    public String getAchternaam() {
        return achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getEmail() {
        return email;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public UUID getGebruikerscode() {
        return gebruikerscode;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setGebruikerscode(UUID gebruikerscode) {
        this.gebruikerscode = gebruikerscode;
    }
}
