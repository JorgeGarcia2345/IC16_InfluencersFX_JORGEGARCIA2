package edu.miracostacollege.cs112.ic16_influencersfx.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

//TODO: Ensure the Influencer class can be written to a binary file

//TODO: Create child class Celebrity (ensure it can be written to a binary file)
//TODO: Create child class CEO (ensure it can be written to a binary file)

public abstract class Influencer implements Serializable, Comparable<Influencer> {

    protected String mName;
    protected String mCountry;
    protected long mFollowers;
    protected double mWorth;

    @Override
    public int compareTo(Influencer other) {
        //Name, country, followers, worth

        int nameComp = this.mName.compareTo(other.mName);
        if(nameComp!=0)
            return nameComp;

        int countryComp = this.mCountry.compareTo(other.mCountry);
        if(countryComp!=0)
            return countryComp;

        int followersComp = Long.compare(this.mFollowers, other.mFollowers);
        if(followersComp!=0)
            return followersComp;

        return Double.compare(this.mWorth, other.mWorth);
    }

    // static, only one version of them
    protected static NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected static NumberFormat number = NumberFormat.getNumberInstance();

    public Influencer(String name, String country, Long followers, double worth) {
        mName = name;
        mCountry = country;
        mFollowers = followers;
        mWorth = worth;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public long getFollowers() {
        return mFollowers;
    }

    public void setFollowers(long followers) {
        mFollowers = followers;
    }

    public double getWorth() {
        return mWorth;
    }

    public void setWorth(double worth) {
        mWorth = worth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Influencer that = (Influencer) o;
        return mFollowers == that.mFollowers &&
                Double.compare(that.mWorth, mWorth) == 0 &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mCountry, that.mCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mCountry, mFollowers, mWorth);
    }

}
