package com.lawencon.springdb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lawencon.springdb.model.Mahasiswa;
import com.lawencon.springdb.model.Universitas;
import com.lawencon.springdb.service.MahasiswaService;
import com.lawencon.springdb.service.MahasiswaServiceHibernateImpl;

public class App {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		MahasiswaService mhsService = context.getBean(MahasiswaServiceHibernateImpl.class);

		Mahasiswa m = new Mahasiswa();
		m.setNama("Iqbal");
		m.setNim("111");
		m.setWaktuMasuk(LocalDate.now());

		Universitas univ = new Universitas();
		univ.setId(1L);
		m.setUniversitas(univ);

		// mhsService.insert(m); // insert

		// m = mhsService.getMhsById(2L); // get by id
		if (m != null) {
			m.setNama("Iqbal2");
			// mhsService.updateCustom(m); // update

			// mhsService.delete(m); // delete
		}

		List<Mahasiswa> listMhs = mhsService.getAllMhs();
		if (listMhs != null) {
			listMhs.forEach(val -> {
				System.out.println(val.getNama());
				System.out.println(val.getUniversitas().getNama());
				System.out.println(val.getWaktuMasuk());
			});
		}

		List<Mahasiswa> listMhsCustom = mhsService.getAllMhsCustom();
		if (listMhsCustom != null) {
			listMhsCustom.forEach(val -> {
				System.out.println(val.getNama());
				System.out.println(val.getUniversitas().getNama());
				System.out.println(val.getWaktuMasuk());
			});
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
