package com.lawencon.springdb.model;

import java.time.LocalDate;

public class Mahasiswa	 {
	private Long id;
	private String nim;
	private String nama;
	private Universitas universitas;
	private LocalDate waktuMasuk;
	
	public LocalDate getWaktuMasuk() {
		return waktuMasuk;
	}

	public void setWaktuMasuk(LocalDate waktuMasuk) {
		this.waktuMasuk = waktuMasuk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Universitas getUniversitas() {
		return universitas;
	}

	public void setUniversitas(Universitas universitas) {
		this.universitas = universitas;
	}
}
