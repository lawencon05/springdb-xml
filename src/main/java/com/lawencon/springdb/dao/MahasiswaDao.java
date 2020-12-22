package com.lawencon.springdb.dao;

import java.util.List;

import com.lawencon.springdb.model.Mahasiswa;

public interface MahasiswaDao {

	void insert(Mahasiswa data) throws Exception;
	
	void insertReturnId(Mahasiswa data) throws Exception;

	void update(Mahasiswa data) throws Exception;
	
	void updateCustom(Mahasiswa data) throws Exception;

	void delete(Mahasiswa data) throws Exception;

	Mahasiswa getMhsById(Long id) throws Exception;

	List<Mahasiswa> getAllMhs() throws Exception;
	
	List<Mahasiswa> getAllMhsCustom() throws Exception;
}
