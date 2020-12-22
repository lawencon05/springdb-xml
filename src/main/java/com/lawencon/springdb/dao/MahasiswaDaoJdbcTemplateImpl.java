package com.lawencon.springdb.dao;

import java.sql.Types;
import java.util.List;

import com.lawencon.springdb.model.Mahasiswa;
import com.lawencon.springdb.model.Universitas;

public class MahasiswaDaoJdbcTemplateImpl extends BaseDaoImpl implements MahasiswaDao {

	@Override
	public void insert(Mahasiswa data) throws Exception {
		String sql = "INSERT INTO mahasiswa (nim, nama, univ_id) VALUES (?, ?, ?) ";

		getJdbcTemplate().update(sql, data.getNim(), data.getNama(), data.getUniversitas().getId());
	}

	@Override
	public void insertReturnId(Mahasiswa data) throws Exception {
		String sql = "INSERT INTO mahasiswa (nim, nama, univ_id) VALUES (?, ?, ?) returning id ";
		Object[] params = new Object[] { data.getNim(), data.getNama(), data.getUniversitas().getId() };
		int[] paramTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		List<Long> listId = getJdbcTemplate().query(sql, params, paramTypes, (rs, ro) -> {
			return rs.getLong("id");
		});

		data.setId(listId.size() > 0 ? listId.get(0) : -1);

	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		String sql = " UPDATE mahasiswa set nim = ?, nama = ?, univ_id = ? where id = ? ";

		getJdbcTemplate().update(sql, data.getNim(), data.getNama(), data.getUniversitas().getId(), data.getId());
	}
	
	@Override
	public void updateCustom(Mahasiswa data) throws Exception {
		//TODO : implement yourself
	}

	@Override
	public void delete(Mahasiswa data) throws Exception {
		// TODO : implement yourself
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		String sql = "SELECT * FROM mahasiswa WHERE id = ? ";

		Object[] params = new Object[] { id };
		int[] paramTypes = new int[] { Types.INTEGER };

		List<Mahasiswa> listMhs = getJdbcTemplate().query(sql, params, paramTypes, (rs, ro) -> {
			Mahasiswa mhs = new Mahasiswa();
			mhs.setId(rs.getLong("id"));
			mhs.setNim(rs.getString("nim"));
			mhs.setNama(rs.getString("nama"));
			
			Universitas univ = new Universitas();
			univ.setId(rs.getLong("univ_id"));
			mhs.setUniversitas(univ);
			
			return mhs;
		});

		return listMhs.size() > 0 ? listMhs.get(0) : null;
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		String sql = "SELECT * FROM mahasiswa";

		List<Mahasiswa> listMhs = getJdbcTemplate().query(sql, (rs, ro) -> {
			Mahasiswa mhs = new Mahasiswa();
			mhs.setId(rs.getLong("id"));
			mhs.setNim(rs.getString("nim"));
			mhs.setNama(rs.getString("nama"));
			
			Universitas univ = new Universitas();
			univ.setId(rs.getLong("univ_id"));
			mhs.setUniversitas(univ);
			
			return mhs;
		});

		return listMhs;
	}
	
	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		//TODO : implement yourself
		return null;
	}

}
