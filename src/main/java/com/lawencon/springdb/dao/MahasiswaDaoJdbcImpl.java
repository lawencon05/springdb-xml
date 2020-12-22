package com.lawencon.springdb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.springdb.model.Mahasiswa;
import com.lawencon.springdb.model.Universitas;

public class MahasiswaDaoJdbcImpl extends BaseDaoImpl implements MahasiswaDao {

	@Override
	public void insert(Mahasiswa data) throws Exception {
		String sql = " INSERT INTO mahasiswa (nim, nama, univ_id) VALUES (?, ?, ?) ";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, data.getNim());
		ps.setString(2, data.getNama());
		ps.setLong(3, data.getUniversitas().getId());
		ps.executeUpdate();
	}

	@Override
	public void insertReturnId(Mahasiswa data) throws Exception {
		String sql = " INSERT INTO mahasiswa (nim, nama, univ_id) VALUES (?, ?, ?) returning id ";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, data.getNim());
		ps.setString(2, data.getNama());
		ps.setLong(3, data.getUniversitas().getId());

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			data.setId(rs.getLong("id"));
		}
	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		String sql = " UPDATE mahasiswa set nim = ?, nama = ?, univ_id = ? where id = ? ";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, data.getNim());
		ps.setString(2, data.getNama());
		ps.setLong(3, data.getUniversitas().getId());
		ps.setLong(4, data.getId());
		ps.executeUpdate();
	}
	
	@Override
	public void updateCustom(Mahasiswa data) throws Exception {
		//TODO : implement yourself
	}

	@Override
	public void delete(Mahasiswa data) throws Exception {
		//TODO : implement yourself
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		Mahasiswa mhs = new Mahasiswa();
		String sql = "SELECT * FROM mahasiswa WHERE id = ? ";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			mhs.setId(rs.getLong("id"));
			mhs.setNim(rs.getString("nim"));
			mhs.setNama(rs.getString("nama"));

			Universitas univ = new Universitas();
			univ.setId(rs.getLong("univ_id"));
			mhs.setUniversitas(univ);
		}

		return mhs;
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		List<Mahasiswa> listMhs = new ArrayList<>();
		String sql = "SELECT * FROM mahasiswa";
		Statement st = conn().createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			Mahasiswa mhs = new Mahasiswa();
			mhs.setId(rs.getLong("id"));
			mhs.setNim(rs.getString("nim"));
			mhs.setNama(rs.getString("nama"));

			Universitas univ = new Universitas();
			univ.setId(rs.getLong("univ_id"));
			mhs.setUniversitas(univ);

			listMhs.add(mhs);
		}

		return listMhs;
	}
	
	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		//TODO : implement yourself
		return null;
	}

}
