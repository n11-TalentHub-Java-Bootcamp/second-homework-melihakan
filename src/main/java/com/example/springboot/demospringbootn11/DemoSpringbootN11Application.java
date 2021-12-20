package com.example.springboot.demospringbootn11;

import com.example.springboot.demospringbootn11.converter.JsonResponseConverter;
import com.example.springboot.demospringbootn11.entity.Kategori;
import com.example.springboot.demospringbootn11.entity.Urun;
import com.example.springboot.demospringbootn11.service.WebService;
import com.example.springboot.demospringbootn11.service.entityservice.KategoriEntityService;
import com.example.springboot.demospringbootn11.service.entityservice.UrunEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoSpringbootN11Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoSpringbootN11Application.class, args);

		KategoriEntityService serviceKategori = applicationContext.getBean(KategoriEntityService.class);
		UrunEntityService serviceUrun = applicationContext.getBean(UrunEntityService.class);

		//Kategori kategori = getTelefonKategori(service);

		//getTelefonUrun(serviceKategori, serviceUrun);

/*		List<Urun> urunList = serviceUrun.findAll();

		for (Urun urun : urunList) {
			System.out.println(urun.getAdi());
		}*/
	}

	private static void getTelefonUrun(KategoriEntityService serviceKategori, UrunEntityService serviceUrun) {
		Kategori kategori = serviceKategori.findById(52L);
		Urun urun = new Urun();
		urun.setAdi("Galaxy A70");
		urun.setFiyat(new BigDecimal("3000"));
		urun.setKayitTarihi(new Date());
		urun.setKategori(kategori);

		urun = serviceUrun.save(urun);

		System.out.println(urun);
	}

	private static Kategori getTelefonKategori(KategoriEntityService service) {
		Kategori ustKategori = service.findById(2L);
		System.out.println(ustKategori);
		Kategori kategori = new Kategori();
		kategori.setAdi("Telefon");
		kategori.setKirilim(2L);
		kategori.setUstKategori(ustKategori);
		kategori = service.save(kategori);
		System.out.println(kategori);
		return kategori;
	}

}
