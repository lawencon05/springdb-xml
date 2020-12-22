package com.lawencon.springdb.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.springdb.model.Mahasiswa;
import com.lawencon.springdb.model.Universitas;

public class MahasiswaDaoHibernateNQImpl extends BaseDaoImpl implements MahasiswaDao {

	@Override
	public void insert(Mahasiswa data) throws Exception {
		getSession()
				.createNativeQuery(" INSERT INTO mahasiswa (nim, nama, univ_id, waktu_masuk) VALUES (?1, ?2, ?3, ?4) ")
				.setParameter(1, data.getNim()).setParameter(2, data.getNama())
				.setParameter(3, data.getUniversitas().getId()).setParameter(4, data.getWaktuMasuk()).executeUpdate();
	}

	@Override
	public void insertReturnId(Mahasiswa data) throws Exception {
		List<?> listResult = getSession().createNativeQuery(
				" INSERT INTO mahasiswa (nim, nama, univ_id, waktu_masuk) VALUES (?1, ?2, ?3, ?4) RETURNING id ")
				.setParameter(1, data.getNim()).setParameter(2, data.getNama())
				.setParameter(3, data.getUniversitas().getId()).setParameter(4, data.getWaktuMasuk()).list();

		data.setId(listResult.size() > 0 ? Long.valueOf(listResult.get(0).toString()) : null);
	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		getSession().createNativeQuery(" UPDATE mahasiswa SET nim = ?1, nama = ?2, univ_id = ?3 WHERE id = ?4  ")
				.setParameter(1, data.getNim()).setParameter(2, data.getNama())
				.setParameter(3, data.getUniversitas().getId()).setParameter(4, data.getId()).executeUpdate();
	}

	@Override
	public void updateCustom(Mahasiswa data) throws Exception {
		getSession().createNativeQuery(" UPDATE mahasiswa set nama = ?1 WHERE id = ?2 ").setParameter(1, data.getNama())
				.setParameter(2, data.getId()).executeUpdate();
	}

	@Override
	public void delete(Mahasiswa data) throws Exception {
		getSession().createNativeQuery(" DELETE FROM mahasiswa WHERE id = ?1 ").setParameter(1, data.getId())
				.executeUpdate();
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		List<Mahasiswa> listResult = getSession()
				.createNativeQuery("SELECT * from mahasiswa where id = ?1 ", Mahasiswa.class).setParameter(1, id)
				.list();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		List<Mahasiswa> listResult = getSession().createNativeQuery("SELECT * FROM mahasiswa", Mahasiswa.class).list();

		return listResult;
	}

	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		List<Mahasiswa> listMhs = new ArrayList<>();
		List<?> listObj = getSession()
				.createNativeQuery("SELECT m.id mhs_id, m.nim, m.nama mhs_nama, u.id, u.nama, m.waktu_masuk	 "
						+ " FROM mahasiswa as m" + " INNER JOIN universitas as u ON u.id = m.univ_id ")
				.list();
		listObj.forEach(val -> {
			Object[] objArr = (Object[]) val;
			Mahasiswa mhs = new Mahasiswa();
			mhs.setId(Long.valueOf(objArr[0].toString()));
			mhs.setNim((String) objArr[1]);
			mhs.setNama((String) objArr[2]);

			Universitas univ = new Universitas();
			univ.setId(Long.valueOf(objArr[3].toString()));
			univ.setNama((String) objArr[4]);
			mhs.setUniversitas(univ);

			mhs.setWaktuMasuk(((Date) objArr[5]).toLocalDate());
			listMhs.add(mhs);
		});

		return listMhs;
	}

}
