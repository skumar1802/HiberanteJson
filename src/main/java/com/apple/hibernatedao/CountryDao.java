package com.apple.hibernatedao;

import java.util.List;

import com.apple.beans.Country;
import com.apple.beans.TopicData;

public interface CountryDao {

	
	public void addCountry(List<Country> list);
    public Country updateCountry(int id,Country country );
    public List<Country> listCountries();
    public Country getCountryById(int id);
    public void removeCountry(int id);
    public Country getSchedulerById(int id);
	public List<TopicData> getTopicData(int id);
	
}
