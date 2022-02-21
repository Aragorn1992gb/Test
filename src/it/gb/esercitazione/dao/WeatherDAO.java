package it.gb.esercitazione.dao;

import java.util.ArrayList;

import it.gb.esercitazione.bean.WeatherBean;

public interface WeatherDAO {
	public abstract ArrayList<WeatherBean> findWeatherData();
}
