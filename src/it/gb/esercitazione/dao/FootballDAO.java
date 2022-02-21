package it.gb.esercitazione.dao;

import java.util.ArrayList;

import it.gb.esercitazione.bean.FootballBean;

public interface FootballDAO {
	public abstract ArrayList<FootballBean> findFootballData();
}
