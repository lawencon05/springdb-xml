package com.lawencon.springdb.service;

import java.util.List;

import com.lawencon.springdb.dao.MahasiswaDao;
import com.lawencon.springdb.model.Mahasiswa;

public class MahasiswaServiceHibernateImpl extends BaseServiceImpl implements MahasiswaService {

	private MahasiswaDao mahasiswaDao;

	public void setMahasiswaDao(MahasiswaDao mahasiswaDao) {
		this.mahasiswaDao = mahasiswaDao;
	}

	@Override
	public void insert(Mahasiswa data) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				mahasiswaDao.insert(data);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public void insertReturnId(Mahasiswa data) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				mahasiswaDao.insertReturnId(data);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public void update(Mahasiswa data) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				mahasiswaDao.update(data);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public void updateCustom(Mahasiswa data) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				mahasiswaDao.updateCustom(data);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public void delete(Mahasiswa data) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				mahasiswaDao.delete(data);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public Mahasiswa getMhsById(Long id) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return mahasiswaDao.getMhsById(id);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public List<Mahasiswa> getAllMhs() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return mahasiswaDao.getAllMhs();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public List<Mahasiswa> getAllMhsCustom() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return mahasiswaDao.getAllMhsCustom();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

}
